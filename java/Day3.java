import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                epsilonRate.append("1");
            } else {
                gammaRate.append("1");
                epsilonRate.append("0");
            }
        }
        
        return Integer.parseInt(gammaRate.toString(), 2) * Integer.parseInt(epsilonRate.toString(), 2);
    }

    @Override
    int part2(String[] puzzleInput) {
        int oxygenGeneratorRating = getOxygenGeneratorRating(puzzleInput);
        int co2ScrubberRating = getCo2ScrubberRating(puzzleInput);
        return oxygenGeneratorRating * co2ScrubberRating;
    }

    private int getCo2ScrubberRating(String[] puzzleInput) {
        List<String> list = getListOfLessOccurs(puzzleInput);
        return Integer.parseInt(list.get(0), 2);
    }

    private int getOxygenGeneratorRating(String[] puzzleInput) {
        List<String> list = getListOfMostOccurs(puzzleInput);
        return Integer.parseInt(list.get(0), 2);
    }

    private List<String> getListOfMostOccurs(String[] list) {
        return getListOfMostOccurs(Arrays.asList(list), 0);
    }

    private List<String> getListOfLessOccurs(String[] list) {
        return getListOfLessOccurs(Arrays.asList(list), 0);
    }

    private List<String> getListOfMostOccurs(List<String> list, int position) {
        return getListOf(list, position, (countZeros, countOnes) -> countZeros > countOnes);
    }

    private List<String> getListOfLessOccurs(List<String> list, int position) {
        return getListOf(list, position, (countZeros, countOnes) -> countZeros <= countOnes);
    }

    private List<String> getListOf(List<String> list, int position, ListFilter listFilter) {
        List<String> numbersWithZeros = new ArrayList<String>();
        List<String> numbersWithOnes = new ArrayList<String>();

        for (int i = 0; i < list.size(); i++) {
            char number = list.get(i).charAt(position);
            if (number == '0') {
                numbersWithZeros.add(list.get(i));
            } else {
                numbersWithOnes.add(list.get(i));
            }
        }

        int countZeros = numbersWithZeros.size();
        int countOnes = numbersWithOnes.size();
        List<String> nextList = listFilter.filter(countZeros, countOnes) ? numbersWithZeros : numbersWithOnes;
        if (nextList.size() == 1) {
            return nextList;
        } else {
            return getListOf(nextList, position + 1, listFilter);
        }
    }

    public static void main(String[] args) {
        new Day3().run(3);
    }

    interface ListFilter {
        boolean filter(int countZeros, int countOnes);
    }
}