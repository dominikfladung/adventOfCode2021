<?php
require_once(__DIR__ . '/Day.php');

class Day2 extends Day
{
    protected function part1($puzzleInput)
    {
        $depth = 0;
        $horizontalPosition = 0;
        
        foreach ($puzzleInput as $line) {
            $split = explode(" ", $line);    
            $units = (int) $split[1];
            $direction = trim($split[0]);

            if ($direction === "forward") {
                $horizontalPosition += $units;
            } else if ($direction === "up") {
                $depth -= $units;
            } else if ($direction === "down") {
                $depth += $units;
            }
        }

        return $depth * $horizontalPosition;
    }

    protected function part2($puzzleInput)
    {
        $depth = 0;
        $horizontalPosition = 0;
        $aim = 0;

        foreach ($puzzleInput as $line) {
            $split = explode(" ", $line);
            $units = (int) $split[1];
            $direction = trim($split[0]);

            if ($direction === "forward") {
                $horizontalPosition += $units;
                $depth += $units * $aim;
            } else if ($direction === "up") {
                $aim -= $units;
            } else if ($direction === "down") {
                $aim += $units;
            }
        };

        return $depth * $horizontalPosition;
    }
}

$day = new Day2();
$day->run(2);
