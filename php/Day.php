<?php

abstract class Day {
    public function run($day) {
        $puzzleInput = $this->readFile(__DIR__ . "/../puzzle_input/$day.txt");
        echo "Day: $day\n";
        echo "Part 1: {$this->part1($puzzleInput)}\n";
        echo "Part 2: {$this->part2($puzzleInput)}";
    }

    protected function readFile($path) {
        $puzzleInput = file_get_contents($path);
        return explode("\n", $puzzleInput);
    }

    protected function toInt($puzzleInput) {
        return array_map(static function($value) {
            return (int) $value;
        }, $puzzleInput);
    }

    protected abstract function part1($puzzleInput);
    protected abstract function part2($puzzleInput);
}