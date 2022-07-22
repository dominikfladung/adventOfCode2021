namespace AdventOfCode;

public class Day2 : Day
{
    private enum CommandType
    {
        Forward,
        Down,
        Up
    }
    
    private class Command
    {
        public readonly int Units;
        public readonly CommandType Type;

        public Command(string row)
        {
            var splits = row.Split(' ');
            Units = int.Parse(splits[1]);
            Type = splits[0] switch
            {
                "up" => CommandType.Up,
                "down" => CommandType.Down,
                "forward" => CommandType.Forward,
                _ => throw new ArgumentOutOfRangeException(nameof(row), row, "Invalid command")
            };
        }
    }
    
    public override int Part1(string[] puzzleInput)
    {
        var x = 0;
        var y = 0;
        
        foreach (var row in puzzleInput)
        {
            var command = new Command(row);
            switch (command.Type)
            {
                case CommandType.Up:
                    y -= command.Units;
                    break;
                case CommandType.Down:
                    y += command.Units;
                    break;
                case CommandType.Forward:
                    x += command.Units;
                    break;
                default:
                    throw new ArgumentOutOfRangeException();
            }
        }

        return x * y;
    }

    public override int Part2(string[] puzzleInput)
    {
        var horizontalPosition = 0;
        var depth = 0;
        var aim = 0;
        
        foreach (var row in puzzleInput)
        {
            var command = new Command(row);
            switch (command.Type)
            {
                case CommandType.Up:
                    aim -= command.Units;
                    break;
                case CommandType.Down:
                    aim += command.Units;
                    break;
                case CommandType.Forward:
                    horizontalPosition += command.Units;
                    depth += aim * command.Units;
                    break;
                default:
                    throw new ArgumentOutOfRangeException();
            }
        }

        return horizontalPosition * depth;
    }
}