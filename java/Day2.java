public class Day2 extends Day {

    @Override
    int part1(String[] puzzleInput) {
        int depth = 0;
        int horizontalPosition = 0;

        for (String line : puzzleInput) {
            String[] split = line.split(" ");
            int units = Integer.parseInt(split[1]);
            String direction = split[0].trim();
            
            if(direction.equals("forward")) {
                horizontalPosition += units;
            } else if(direction.equals("up")) {
                depth -= units;
            } else if(direction.equals("down")) {
                depth += units;
            }
        }        

        return depth * horizontalPosition;
    }

    @Override
    int part2(String[] puzzleInput) {
        int depth = 0;
        int horizontalPosition = 0;
        int aim = 0;

        for (String line : puzzleInput) {
            String[] split = line.split(" ");
            int units = Integer.parseInt(split[1]);
            String direction = split[0].trim();
            
            if(direction.equals("forward")) {
                horizontalPosition += units;
                depth += units * aim;
            } else if(direction.equals("up")) {
                aim -= units;
            } else if(direction.equals("down")) {
                aim += units;
            } else {
                System.out.println("?" + direction);
            }

            //System.out.println("horizontalPosition: " + horizontalPosition + " depth: " + depth + " aim: " + aim);
        }        

        return depth * horizontalPosition;
    }

    public static void main(String[] args) {
        new Day2().run(2);
    }
}
