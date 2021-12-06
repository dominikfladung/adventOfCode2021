import java.util.HashMap;

public class Day5 extends Day {
    public static void main(String[] args) {
        new Day5().run(5);
    }

    @Override
    int part1(String[] puzzleInput) {
        var lines = getLines(puzzleInput);
        var map = new HashMap<String, Integer>();

        for (var line : lines) {
          //  System.out.println("----" + line + "----");

            if (!(line.start.x == line.end.x || line.start.y == line.end.y)) {
              //  System.out.println("Not horizontal or vertical: " + line);
            } else {
                for (int x = line.getMinX(); x <= line.getMaxX(); x++) {
                    for (int y = line.getMinY(); y <= line.getMaxY(); y++) {
                        markCoordinate(map, x, y);
                    }
                }
              //  printMap(map);
            }
          //  System.out.println("----/" + line + "----");
        }

        return countOverlap(map);
    }

    private int countOverlap(HashMap<String, Integer> map) {
        int counter = 0;
        for (var entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                counter++;
            }
        }
        return counter;
    }

    private void printMap(HashMap<String, Integer> map) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                String key = new Coordinate(j, i).toString();
                String value = map.containsKey(key) ? map.get(key).toString() : ".";
                System.out.print(value);
            }
            System.out.println();
        }
    }

    @Override
    int part2(String[] puzzleInput) {
        var lines = getLines(puzzleInput);
        var map = new HashMap<String, Integer>();

        for (var line : lines) {
            //System.out.println("----" + line + "----");

            if (!(line.start.x == line.end.x || line.start.y == line.end.y)) {
                int x = line.start.x;
                int y = line.start.y;
                while(x != line.end.x && y != line.end.y) {
                    markCoordinate(map, x, y);
                    x = line.start.x < line.end.x ? x + 1 : x - 1;
                    y = line.start.y < line.end.y ? y + 1 : y - 1;
                }   
                
                markCoordinate(map, x, y);
            } else {
                for (int x = line.getMinX(); x <= line.getMaxX(); x++) {
                    for (int y = line.getMinY(); y <= line.getMaxY(); y++) {
                        markCoordinate(map, x, y);
                    }
                }
            }

            //printMap(map);
            //System.out.println("----/" + line + "----");
        }

        return countOverlap(map);
    }

    private void markCoordinate(HashMap<String, Integer> map, int x, int y) {
        var coord = new Coordinate(x, y).toString();
        if (map.containsKey(coord)) {
            map.put(coord, map.get(coord) + 1);
        } else {
            map.put(coord, 1);
        }
    }

    Line[] getLines(String[] puzzleInput) {
        Line[] lines = new Line[puzzleInput.length];
        for (int i = 0; i < puzzleInput.length; i++) {
            lines[i] = new Line(puzzleInput[i]);
        }
        return lines;
    }

    private class Line {
        Coordinate start;
        Coordinate end;

        public int getMinX() {
            return Math.min(start.x, end.x);
        }

        public int getMaxX() {
            return Math.max(start.x, end.x);
        }

        public int getMinY() {
            return Math.min(start.y, end.y);
        }

        public int getMaxY() {
            return Math.max(start.y, end.y);
        }

        public Line(String line) {
            String[] parts = line.split(" -> ");
            int[] startCoordinates = toInt(parts[0].split(","));
            int[] endCoordinates = toInt(parts[1].split(","));

            start = new Coordinate(startCoordinates[0], startCoordinates[1]);
            end = new Coordinate(endCoordinates[0], endCoordinates[1]);
        }

        @Override
        public String toString() {
            return "(" + start.x + "," + start.y + ") -> " + "(" + end.x + "," + end.y + ")";
        }
    }

    private class Coordinate implements Comparable<Coordinate> {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }

        @Override
        public int compareTo(Coordinate o) {
            if (x == o.x) {
                return y - o.y;
            } else {
                return x - o.x;
            }
        }
    }
}
