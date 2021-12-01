<?php
// Get Data
$puzzleInput = file_get_contents(__DIR__ . "/1.txt");
$puzzleInput = explode("\n", $puzzleInput);


// Part 1
$increaseCounter = 0;
$lastInput = (int)$puzzleInput[0];

foreach ($puzzleInput as $input) {
    if((int)$input > $lastInput) {
        $increaseCounter++;
    }
    $lastInput = $input;
}

echo $increaseCounter;

echo chr(10);

// Part 2
$increaseCounter = 0;
$lastChunk = array_sum(array_slice($puzzleInput, 0, 3));

for($i = 0; $i < count($puzzleInput); $i++) {
    $chunk = array_sum(array_slice($puzzleInput, $i, 3));
    
    if($chunk > $lastChunk) {
        $increaseCounter++;
    }
    $lastChunk = $chunk;
}

echo $increaseCounter;