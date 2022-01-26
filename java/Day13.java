import java.util.Arrays;

public class Day13 extends Day {
    public static void main(String[] args) {
        new Day13().run(13);
    }

    @Override
    int part1(String[] puzzleInput) {
        var emptyRowPosition = this.getEmptyRowPosition(puzzleInput);
        var coordinates = getCoordinates(puzzleInput, emptyRowPosition);
        var foldings = getFoldings(puzzleInput, emptyRowPosition);
        var map = new Map(coordinates);
        // map.print();
        map = map.fold(foldings[0]);

        return map.countMarkedFields();
    }

    private Folding[] getFoldings(String[] puzzleInput, int emptyRowPosition) {
        return Arrays.stream(Arrays.copyOfRange(puzzleInput, emptyRowPosition + 1, puzzleInput.length))
                .map(Folding::new)
                .toArray(Folding[]::new);
    }

    private Coordinate[] getCoordinates(String[] puzzleInput, int emptyRowPosition) {
        return Arrays.stream(Arrays.copyOfRange(puzzleInput, 0, emptyRowPosition))
                .map(Coordinate::new)
                .toArray(Coordinate[]::new);
    }

    @Override
    int part2(String[] puzzleInput) {
        var emptyRowPosition = this.getEmptyRowPosition(puzzleInput);
        var coordinates = getCoordinates(puzzleInput, emptyRowPosition);
        var foldings = getFoldings(puzzleInput, emptyRowPosition);
        var map = new Map(coordinates);
        // map.print();

        for (var fold : foldings) {
            map = map.fold(fold);
            // map.print();
        }
        map.print();
        return map.countMarkedFields();
    }

    private class Map {
        Boolean[][] fields;

        public Map(int x, int y) {
            this.fields = new Boolean[y][x];
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    this.fields[i][j] = false;
                }
            }
        }

        public Map(Coordinate[] coordinates) {
            this(getMaxX(coordinates) + 1, getMaxY(coordinates) + 1);

            for (var coordinate : coordinates) {
                this.fields[coordinate.y][coordinate.x] = true;
            }
        }

        public Map fold(Folding folding) {
            int mapX, mapY;
            boolean isFoldLeft = folding.type == Folding.Type.FOLD_LEFT;

            if (isFoldLeft) {
                mapX = folding.value;
                mapY = this.fields.length;
            } else {
                mapX = this.fields[0].length;
                mapY = folding.value;
            }

            var newMap = new Map(mapX, mapY);

            for (int y = 0; y < mapY; y++) {
                for (int x = 0; x < mapX; x++) {
                    Boolean isNewFieldSet = this.fields[y][x];
                    int mirrorY = !isFoldLeft ? this.fields.length - y - 1 : y;
                    int mirrorX = isFoldLeft ? this.fields[0].length - x - 1 : x;
                    newMap.fields[y][x] = isNewFieldSet ? isNewFieldSet : this.fields[mirrorY][mirrorX];
                }
            }

            return newMap;
        }

        public int countMarkedFields() {
            int count = 0;
            for (var field : this.fields) {
                for (var fieldValue : field) {
                    if (fieldValue) {
                        count++;
                    }
                }
            }
            return count;
        }

        private void print() {
            System.out.println("----------------------------------------------------------------");
            for (var row : this.fields) {
                for (var column : row) {
                    System.out.print(column ? "#" : ".");
                }
                System.out.println();
            }
            System.out.println("----------------------------------------------------------------");
        }

        private static int getMaxX(Coordinate[] coordinates) {
            return Arrays.stream(coordinates).mapToInt(c -> c.x).max().orElse(0);
        }

        private static int getMaxY(Coordinate[] coordinates) {
            return Arrays.stream(coordinates).mapToInt(c -> c.y).max().orElse(0);
        }
    }

    private class Folding {
        enum Type {
            FOLD_LEFT, FOLD_DOWN
        }

        Type type;
        int value;

        Folding(String input) {
            var split = input.replace("fold along ", "").split("=");
            this.value = Integer.parseInt(split[1]);
            if (split[0].equals("x")) {
                this.type = Type.FOLD_LEFT;
            } else {
                this.type = Type.FOLD_DOWN;
            }
        }
    }

    private class Coordinate {
        int x;
        int y;

        public Coordinate(String input) {
            var split = input.split(",");
            this.x = Integer.parseInt(split[0]);
            this.y = Integer.parseInt(split[1]);
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }
}
