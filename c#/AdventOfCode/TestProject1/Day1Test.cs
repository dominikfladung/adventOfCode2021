using AdventOfCode;
using NUnit.Framework;

namespace TestProject1;

public class Day1Test : IDayTest
{
    public Day GetDay()
    {
        return new Day1();
    }
    
    [Test]
    public void Part1Test()
    {
        Assert.AreEqual(1711, GetDay().Part1());
    }

    [Test]
    public void Part2Test()
    {
        Assert.AreEqual(1743, GetDay().Part2());   
    }
}