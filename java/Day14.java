import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;

public class Day14 extends Day{

    @Override
    int part1(String[] puzzleInput) {
        var emptyRowPosition = this.getEmptyRowPosition(puzzleInput);
        var polymerTemplate = getPolymerTemplate(puzzleInput);
        var pairInsertionRules = getPairInsertionRules(puzzleInput, emptyRowPosition);

        for(int i = 0; i < 10; i++) {
            polymerTemplate = pairInsertionRules[i].apply(polymerTemplate);
        }

        var charsMap = countChars(polymerTemplate);
        return charsMap.lastKey() - charsMap.firstKey();
    }

    @Override
    int part2(String[] puzzleInput) {
        // TODO Auto-generated method stub
        return 0;
    }

    private SortedMap<Character, Integer> countChars(String polymerTemplate) {
        var map = new TreeMap<Character, Integer>();
        for(int i = 0; i < polymerTemplate.length(); i++) {
            var c = polymerTemplate.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }
    
    String getPolymerTemplate(String[] puzzleInput) {
        return puzzleInput[0];
    }

    PairInsertionRule[] getPairInsertionRules(String[] puzzleInput, int emptyRowPosition) {
        return Arrays.stream(Arrays.copyOfRange(puzzleInput, emptyRowPosition + 1, puzzleInput.length))
                .map(PairInsertionRule::new)
                .toArray(PairInsertionRule[]::new);
    }

    public static void main(String[] args) {
        new Day14().run(14);
    }

    private class PairInsertionRule {
        String rule;
        String insert;

        public PairInsertionRule(String row) {
            var split = row.split(" -> ");
            this.rule = split[0];
            this.insert = split[1];
        }

        public String apply(String polymerTemplate) {
            System.out.println(polymerTemplate + " " + this);
            return polymerTemplate.replaceAll(rule, rule.charAt(0) + insert + rule.charAt(1));
        }

        public String toString() {
            return this.rule + " -> " + this.insert;
        }
    }
}
