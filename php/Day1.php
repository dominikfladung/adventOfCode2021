<?php
require_once(__DIR__ . '/Day.php');

class Day1 extends Day
{
    protected function part1($puzzleInput)
    {
        $puzzleInput = $this->toInt($puzzleInput);
        $increaseCounter = 0;
        
        for ($i = 1; $i < count($puzzleInput); $i++) {
            if ($puzzleInput[$i] > $puzzleInput[$i - 1]) {
                $increaseCounter++;
            }
        }

        return $increaseCounter;
    }

    protected function part2($puzzleInput)
    {
        $puzzleInput = $this->toInt($puzzleInput);
        $increaseCounter = 0;
        
        for ($i = 0; $i < count($puzzleInput); $i++) {
            $current = array_sum(array_slice($puzzleInput, $i, 3));
            $next = array_sum(array_slice($puzzleInput, $i + 1, 3));
            
            if ($next > $current) {
                $increaseCounter++;
            }
        }

        return $increaseCounter;
    }
}

$day = new Day1();
$day->run(1);
