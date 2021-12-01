const {Day} = require('./Day');

class Day1 extends Day {
    part1(puzzleInput) {
        let increaseCounter = 0;
        let lastInput = puzzleInput[0];
        puzzleInput = this.toInt(puzzleInput);

        puzzleInput.forEach(input => {
            if (input > lastInput) {
                increaseCounter++;
            }
            lastInput = input;
        })

        return increaseCounter;
    }

    part2(puzzleInput) {
        let increaseCounter = 0;
        puzzleInput = this.toInt(puzzleInput);

        for (let i = 0; i < puzzleInput.length - 3; i++) {
            let overlap = puzzleInput[i + 1] + puzzleInput[i + 2];
            let current = puzzleInput[i] + overlap;
            let next = overlap + puzzleInput[i + 3];

            if (next > current) {
                increaseCounter++;
            }    
        }

        return increaseCounter;
    }
}

new Day1().run(1);