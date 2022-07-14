namespace AdventOfCode;

public abstract class Day
{
    protected abstract int GetDayIndex();
    public abstract int Part1();
    public abstract int Part2();
    
    public void Run()
    {
        Console.WriteLine(this.GetType().Name);
        Console.WriteLine("Part 1: " + this.Part1());
        Console.WriteLine("Part 2: " + this.Part2());
    }

    protected string[] GetPuzzleInput()
    {
        var fileName = Path.Combine(Directory.GetCurrentDirectory(), "\\../../../../../../../../puzzle_input/" + this.GetDayIndex() + ".txt");
        return File.ReadAllLines(fileName);
    }

    protected int[] GetNumericPuzzleInput()
    {
        return Array.ConvertAll(this.GetPuzzleInput(), int.Parse);
    }
}