public class Day1 extends Day {
    @Override
    int part1(String[] puzzleInput) {
        int counter = 0;
        int[] numbers = ToInt(puzzleInput);

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > numbers[i - 1]) {
                counter++;
            }    
        }

        return counter;
    }

    @Override
    int part2(String[] puzzleInput) {
        int counter = 0;
        int[] numbers = ToInt(puzzleInput);

        for (int i = 0; i < numbers.length - 3; i++) {
            int overlap = numbers[i + 1] + numbers[i + 2];
            int current = numbers[i] + overlap;
            int next = overlap + numbers[i + 3];

            if (next > current) {
                counter++;
            }    
        }

        return counter;
    }

    public static void main(String[] args) {
        new Day1().run(1);
    }
}