namespace AdventOfCode;

public class Day3 : Day
{
    public override int Part1(string[] puzzleInput)
    {
        var gamaRateBinaryString = "";
        var epsilonRateBinaryString = "";

        for (var x = 0; x < puzzleInput[0].Length; x++)
        {
            var zeroCounter = puzzleInput.Sum(t => t[x] == '0' ? 1 : 0);

            if(zeroCounter < puzzleInput.Length / 2)
            {
                gamaRateBinaryString += "1";
                epsilonRateBinaryString += "0";
            }
            else
            {
                gamaRateBinaryString += "0";
                epsilonRateBinaryString += "1";
            }
        }

        var gammaRate = BinaryToInt(gamaRateBinaryString);
        var epsilonRate = BinaryToInt(epsilonRateBinaryString);
        return gammaRate * epsilonRate;
    }

    public override int Part2(string[] puzzleInput)
    {
        var cO2ScrubberRating = Co2ScrubberRating(puzzleInput);
        var oxygenGeneratorRating = OxygenGeneratorRating(puzzleInput);
        return cO2ScrubberRating * oxygenGeneratorRating;
    }

    private int Co2ScrubberRating(IEnumerable<string> puzzleInput)
    {
        return FilterPuzzleInput(puzzleInput.ToList(), 0, isMoreZero => isMoreZero ? '0' : '1');
    }

    private int OxygenGeneratorRating(IEnumerable<string> puzzleInput)
    {
        return FilterPuzzleInput(puzzleInput.ToList(), 0, isMoreZero => isMoreZero ? '1' : '0');
    }
    
    private int FilterPuzzleInput(List<string> puzzleInput, int position, Func<bool, char> filter)
    {
        var zeroCounter = puzzleInput.Sum(t => t[position] == '0' ? 1 : 0);
        var isMoreZero = zeroCounter <= puzzleInput.Count / 2;
        var list = puzzleInput.FindAll(e => e[position] == filter(isMoreZero));
        
        if (list.Count > 1)
        {
            return FilterPuzzleInput(list, ++position, filter);
        }

        return BinaryToInt(list.First());
    }
}