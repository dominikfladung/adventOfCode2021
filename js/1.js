const fs = require('fs')

// Get Date
const fileData = fs.readFileSync('./puzzle_input/1.txt', 'utf8');
const puzzleInput = fileData.split("\n");

// Part 1
let increaseCounter = 0;
let lastInput = puzzleInput[0];

puzzleInput.forEach(input => {
    if (input > lastInput) {
        increaseCounter++;
    }
    lastInput = input;
})

console.log(increaseCounter);

// Part 2
const sum = (previousValue, currentValue) => previousValue + currentValue;

increaseCounter = 0;
lastChunk = puzzleInput.slice(0, 2).reduce(sum);

for (let i = 0; i < puzzleInput.length; i++) {
    chunk = puzzleInput.slice(i, i + 3).reduce(sum);

    if (chunk > lastChunk) {
        increaseCounter++;
    }
    lastChunk = chunk;
}

console.log(increaseCounter);