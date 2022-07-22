using AdventOfCode;
using NUnit.Framework;

namespace TestProject1;

public class Day3Test : IDayTest
{
    public Day GetDay()
    {
        return new Day3();
    }

    [Test]
    public void Part1Test()
    {
        Assert.AreEqual(3009600, GetDay().Part1(Day.GetPuzzleInput("3.txt")));
    }

    [Test]
    public void Part1SampleTest()
    {
        Assert.AreEqual(198, GetDay().Part1(Day.GetPuzzleInput("3_sample.txt")));
    }

    [Test]
    public void Part2Test()
    {
        Assert.AreEqual(6940518, GetDay().Part2(Day.GetPuzzleInput("3.txt")));
    }

    [Test]
    public void Part2SampleTest()
    {
        Assert.AreEqual(230, GetDay().Part2(Day.GetPuzzleInput("3_sample.txt")));
    }
}