import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day4 extends Day {
    public static void main(String[] args) {
        new Day4().run(4);
    }

    @Override
    int part1(String[] puzzleInput) {
        Bingo bingo = new Bingo(puzzleInput);
        int i = 0;
        Field[][] winnerBoard = null;

        while (winnerBoard == null && i < bingo.bingSubsystem.length) {
            bingo.markFields(bingo.bingSubsystem[i]);
            winnerBoard = bingo.getWinner();
            i++;
        }

        if (winnerBoard == null) {
            return -1;
        }

        return bingo.getScore(winnerBoard, bingo.bingSubsystem[i - 1]);
    }

    @Override
    int part2(String[] puzzleInput) {
        Bingo bingo = new Bingo(puzzleInput);
        int i = 0;
        List<Integer> winners = new ArrayList<Integer>();

        while (i < bingo.bingSubsystem.length) {
            bingo.markFields(bingo.bingSubsystem[i]);
            Field[][] winnerBoard = bingo.getAndRemoveWinner();
            
            if (winnerBoard != null) {
                winners.add(bingo.getScore(winnerBoard, bingo.bingSubsystem[i]));
            }

            i++;
        }
        
        return winners.get(winners.size()-1);
    }

    private class Bingo {
        public List<Field[][]> boards = new ArrayList<Field[][]>();
        public int[] bingSubsystem;

        Bingo(String[] puzzleInput) {
            this.bingSubsystem = toInt(puzzleInput[0].split(","));
            for (int i = 1; i < puzzleInput.length; i += 6) {
                Field[][] board = toBoard(Arrays.copyOfRange(puzzleInput, i, i + 6));
                boards.add(board);
            }
        }

        Field[][] toBoard(String[] input) {
            Field[][] board = new Field[5][5];

            for (int y = 1; y < 6; y++) {
                String[] row = filterEmptyRows(input[y].split(" "));
                int[] numbers = toInt(row);
                for (int x = 0; x < numbers.length; x++) {
                    board[y - 1][x] = new Field(numbers[x]);
                }
            }

            return board;
        }

        void markFields(int number) {
            for (Field[][] board : boards) {
                for (Field[] row : board) {
                    for (Field field : row) {
                        field.markIfNumbersMatch(number);
                    }
                }
            }
        }

        Field[][] getWinner() {
            for (Field[][] board : boards) {
                if (isWinnerBoard(board)) {
                    return board;
                }
            }

            return null;
        }

        Field[][] getAndRemoveWinner() {
            for (int i = 0; i < boards.size(); i++) {
                if (isWinnerBoard(boards.get(i))) {
                    return boards.remove(i);
                }
            }

            return null;
        }

        int getScore(Field[][] board, int lastUsedNumber) {
            int sum = getSumOfUnmarkedFields(board);
            return sum * lastUsedNumber;
        }

        int getSumOfUnmarkedFields(Field[][] board) {
            int score = 0;
            for (Field[] row : board) {
                for (Field field : row) {
                    if (!field.isMarked) {
                        score += field.number;
                    }
                }
            }

            return score;
        }

        boolean isWinnerBoard(Field[][] board) {
            int xCounter = 0;
            int yCounter = 0;

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j].isMarked) {
                        xCounter++;
                    }

                    if (board[j][i].isMarked) {
                        yCounter++;
                    }
                }

                if (xCounter == board[i].length || yCounter == board.length) {
                    return true;
                }

                xCounter = 0;
                yCounter = 0;
            }

            return false;
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
