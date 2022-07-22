using AdventOfCode;
using NUnit.Framework;

namespace TestProject1;

public class Day4Test : IDayTest
{
    public Day GetDay()
    {
        return new Day4();
    }

    [Test]
    public void Part1Test()
    {
        Assert.AreEqual(2091984, GetDay().Part1(Day.GetPuzzleInput("4.txt")));
    }

    [Test]
    public void Part1SampleTest()
    {
        Assert.AreEqual(150, GetDay().Part1(Day.GetPuzzleInput("4_sample.txt")));
    }

    [Test]
    public void Part2Test()
    {
        Assert.AreEqual(2086261056, GetDay().Part2(Day.GetPuzzleInput("4.txt")));
    }

    [Test]
    public void Part2SampleTest()
    {
        Assert.AreEqual(900, GetDay().Part2(Day.GetPuzzleInput("4_sample.txt")));
    }
}