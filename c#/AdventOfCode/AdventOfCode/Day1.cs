namespace AdventOfCode;

public class Day1 : Day
{
    protected override int GetDayIndex()
    {
        return 1;
    }

    public override int Part1()
    {
        var puzzleInput = this.GetNumericPuzzleInput();
        var increaseCounter = 0;

        for (var i = 1; i < puzzleInput.Length; i++)
        {
            if(puzzleInput[i - 1] < puzzleInput[i])
            {
                increaseCounter++;
            }
        }
        
        return increaseCounter;
    }

    public override int Part2()
    {
        var puzzleInput = this.GetNumericPuzzleInput();
        var increaseCounter = 0;

        var firstSlice = SumSlice(0, 3, puzzleInput);
        for (var i = 0; i < puzzleInput.Length; i++)
        {
            var secondSlice = SumSlice(i + 1, 3, puzzleInput);
            if(firstSlice < secondSlice)
            {
                increaseCounter++;
            }

            firstSlice = secondSlice;
        }
        
        return increaseCounter;
    }

    private static int SumSlice(int start, int size, IReadOnlyList<int> data)
    {
        var sum = 0;
        var length = Math.Min(data.Count, start + size);
        for (var j = start; j < length; j++)
        {
            sum += data[j];
        }

        return sum;
    }
}