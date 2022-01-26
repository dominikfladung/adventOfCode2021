import { BaseDay } from "./BaseDay";

class Day1 extends BaseDay {
    part1(puzzleInput: string[]): string {
        let increaseCounter = 0;
        let puzzleInputAsNumber = this.toInt(puzzleInput);
        let lastInput: number = puzzleInputAsNumber[0];

        puzzleInputAsNumber.forEach(function (input) {
            if (input > lastInput) {
                increaseCounter++;
            }
            lastInput = input;
        })

        return increaseCounter.toString();
    }

    part2(puzzleInput: string[]): string {
        let increaseCounter = 0;
        let puzzleInputAsNumber = this.toInt(puzzleInput);

        for (let i = 0; i < puzzleInputAsNumber.length - 3; i++) {
            let overlap = puzzleInputAsNumber[i + 1] + puzzleInputAsNumber[i + 2];
            let current = puzzleInputAsNumber[i] + overlap;
            let next = overlap + puzzleInputAsNumber[i + 3];

            if (next > current) {
                increaseCounter++;
            }
        }

        return increaseCounter.toString();
    }
}

new Day1().run(1);