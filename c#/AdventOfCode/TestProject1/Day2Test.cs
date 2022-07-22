using AdventOfCode;
using NUnit.Framework;

namespace TestProject1;

public class Day2Test : IDayTest
{
    public Day GetDay()
    {
        return new Day2();
    }

    [Test]
    public void Part1Test()
    {
        Assert.AreEqual(2091984, GetDay().Part1(Day.GetPuzzleInput("2.txt")));
    }

    [Test]
    public void Part1SampleTest()
    {
        Assert.AreEqual(150, GetDay().Part1(Day.GetPuzzleInput("2_sample.txt")));
    }

    [Test]
    public void Part2Test()
    {
        Assert.AreEqual(2086261056, GetDay().Part2(Day.GetPuzzleInput("2.txt")));
    }

    [Test]
    public void Part2SampleTest()
    {
        Assert.AreEqual(900, GetDay().Part2(Day.GetPuzzleInput("2_sample.txt")));
    }
}