namespace AdventOfCode;

public abstract class Day
{
    public abstract int Part1(string[] puzzleInput);
    public abstract int Part2(string[] puzzleInput);

    public static string[] GetPuzzleInput(string fileName)
    {
        var path = "\\../../../../../../../../puzzle_input/" + fileName;
        var fullPath = Path.Combine(Directory.GetCurrentDirectory(), path);
        return File.ReadAllLines(fullPath);
    }

    protected int[] ToInt(string[] array)
    {
        return Array.ConvertAll(array, int.Parse);
    }
    
    protected int BinaryToInt(string binaryString)
    {
        return Convert.ToInt32(binaryString, 2);
    }
}