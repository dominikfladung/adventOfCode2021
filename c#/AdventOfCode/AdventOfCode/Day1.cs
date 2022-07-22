namespace AdventOfCode;

public class Day1 : Day
{
    public override int Part1(string[] puzzleInput)
    {
        var rows = ToInt(puzzleInput);
        var increaseCounter = 0;

        for (var i = 1; i < rows.Length; i++)
        {
            if(rows[i - 1] < rows[i])
            {
                increaseCounter++;
            }
        }
        
        return increaseCounter;
    }

    public override int Part2(string[] puzzleInput)
    {
        var rows = ToInt(puzzleInput);
        var increaseCounter = 0;

        var firstSlice = SumSlice(0, 3, rows);
        for (var i = 0; i < puzzleInput.Length; i++)
        {
            var secondSlice = SumSlice(i + 1, 3, rows);
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