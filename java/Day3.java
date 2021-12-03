public class Day3 extends Day {
    @Override
    int part1(String[] puzzleInput) {
        int charLength = puzzleInput[0].length();
        int[] zeros = new int[charLength];

        StringBuilder gammaRate = new StringBuilder();
        StringBuilder epsilonRate = new StringBuilder();

        for (int i = 0; i < puzzleInput.length; i++) {
            for (int j = 0; j < charLength; j++) {
                char number = puzzleInput[i].charAt(j);
                if (number == '0') {
                    zeros[j]++;
                }
            }
        }

        for (int i = 0; i < charLength; i++) {
            if (zeros[i] > Math.floor(puzzleInput.length / 2)) {
                gammaRate.append("0");
            } else {
                gammaRate.append("1");
            }
        }
        
        return Integer.parseInt(gammaRate.toString(), 2) * Integer.parseInt(epsilonRate.toString(), 2);
    }

    @Override
    int part2(String[] puzzleInput) {
        return 0;
    }

    public static void main(String[] args) {
        new Day3().run(3);
    }
}
