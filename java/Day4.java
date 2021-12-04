import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Day4 extends Day {
    public static void main(String[] args) {
        new Day4().run(4);
    }

    @Override
    int part1(String[] puzzleInput) {
        Bingo bingo = new Bingo(puzzleInput);
        int i = 0;
        Board winnerBoard = null;

        while (winnerBoard == null && i < bingo.bingSubsystem.length) {
            bingo.markFields(bingo.bingSubsystem[i]);
            winnerBoard = bingo.getWinner();
            i++;
        }

        if (winnerBoard == null) {
            return -1;
        }

        return winnerBoard.getScore(bingo.bingSubsystem[i - 1]);
    }

    @Override
    int part2(String[] puzzleInput) {
        Bingo bingo = new Bingo(puzzleInput);
        int lastWinnerScore = 0;

        for (int number : bingo.bingSubsystem) {
            for (Board board : bingo.boards) {
                if(!board.won) {
                    board.markFields(number);
                    if (board.isWinner()) {
                        lastWinnerScore = board.getScore(number);
                        //System.out.println("Winner board: " + board.getScore(number) + " " + board.id);
                    }
                  // board.printBoard();
                }
            }
        }

        return lastWinnerScore;
    }

    private class Bingo {
        public List<Board> boards = new ArrayList<Board>();
        public int[] bingSubsystem;

        Bingo(String[] puzzleInput) {
            this.bingSubsystem = toInt(puzzleInput[0].split(","));
            for (int i = 1; i < puzzleInput.length; i += 6) {
                Board board = new Board(Arrays.copyOfRange(puzzleInput, i + 1, i + 6));
                boards.add(board);
            }
        }

        void markFields(int number) {
            for (Board board : boards) {
                board.markFields(number);
            }
        }

        Board getWinner() {
            for (Board board : boards) {
                if (board.isWinner()) {
                    return board;
                }
            }

            return null;
        }
    }

    private class Board implements Iterable<Field[]> {
        public static int BoardCounter = 0;
        private final Field[][] fields = new Field[5][5];
        public final int id = BoardCounter++;
        public boolean won = false;

        Board(String[] input) {
            for (int y = 0; y < 5; y++) {
                String[] row = filterEmptyRows(input[y].split(" "));
                int[] numbers = toInt(row);
                for (int x = 0; x < numbers.length; x++) {
                    fields[y][x] = new Field(numbers[x]);
                }
            }
        }

        void printBoard() {
            System.out.println("----------------------" + id + "--------------------------");
            for (int y = 0; y < 5; y++) {
                for (int x = 0; x < 5; x++) {
                    System.out.print((fields[y][x].isMarked ? "X" : fields[y][x].number) + " ");
                }
                System.out.println();
            }
            System.out.println("---------------------/" + id + "--------------------------");
        }

        void markFields(int number) {
            for (Field[] row : this) {
                for (Field field : row) {
                    field.markIfNumbersMatch(number);
                }
            }
        }

        int getScore(int number) {
            int sum = getSumOfUnmarkedFields();
            return sum * number;
        }

        int getSumOfUnmarkedFields() {
            int score = 0;
            for (Field[] row : this) {
                for (Field field : row) {
                    if (!field.isMarked) {
                        score += field.number;
                    }
                }
            }

            return score;
        }

        boolean isWinner() {
            int xCounter = 0;
            int yCounter = 0;

            for (int i = 0; i < this.fields.length; i++) {
                for (int j = 0; j < this.fields[i].length; j++) {
                    if (this.fields[i][j].isMarked) {
                        xCounter++;
                    }

                    if (this.fields[j][i].isMarked) {
                        yCounter++;
                    }
                }

                if (xCounter == this.fields[i].length || yCounter == this.fields.length) {
                    this.won = true;
                    return true;
                }

                xCounter = 0;
                yCounter = 0;
            }

            return false;
        }

        @Override
        public Iterator<Day4.Field[]> iterator() {
            return new Iterator<Field[]>()
            {
                private int i = 0;
     
                @Override
                public boolean hasNext() {
                    return fields.length > i;
                }
     
                @Override
                public Field[] next() {
                    return fields[i++];
                }
            };
        }
    }

    private class Field {
        public int number;
        public boolean isMarked = false;

        public Field(int number) {
            this.number = number;
        }

        public void markIfNumbersMatch(int number) {
            if (this.number == number) {
                this.isMarked = true;
            }
        }
    }
}