using AdventOfCode;
using NUnit.Framework;

namespace TestProject1;

public interface IDayTest
{
    public Day GetDay();
    
    public void Part1Test();
    
    public void Part2Test();
}