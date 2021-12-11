import java.util.Arrays;
import java.util.stream.IntStream;

public class Day7 extends Day {

    public static void main(String[] args) {
        new Day7().run(7);
    }

    static int additionSum(int n) {
        return (n * (n + 1)) / 2;
    }

    static int calcFuel(int[] horizontalPosition, int target) {
        int fuel = 0;
        for (int i : horizontalPosition) {
            fuel += Math.abs(i - target);
        }

        return fuel;
    }

    static int calcFuel2(int[] horizontalPosition, int target) {
        int fuel = 0;
        for (int i : horizontalPosition) {
            fuel += additionSum(Math.abs(i - target));
        }

        return fuel;
    }

    @Override
    int part1(String[] puzzleInput) {
        int[] horizontalPositions = toInt(puzzleInput[0].split(","));
        int max = Arrays.stream(horizontalPositions).max().orElse(-1);
        int min = Arrays.stream(horizontalPositions).min().orElse(-1);

        return IntStream.range(min, max).map(i -> calcFuel(horizontalPositions, i)).min().orElse(-1);
    }

    @Override
    int part2(String[] puzzleInput) {
        int[] horizontalPositions = toInt(puzzleInput[0].split(","));
        int max = Arrays.stream(horizontalPositions).max().orElse(-1);
        int min = Arrays.stream(horizontalPositions).min().orElse(-1);

        return IntStream.range(min, max).map(i -> calcFuel2(horizontalPositions, i)).min().orElse(-1);
    }
}
