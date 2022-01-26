import { BaseDay } from "./BaseDay";

class Day1 extends BaseDay {
    part1(puzzleInput: string[]): string {
        const puzzleInputAsNumber: Array<number> = this.toInt(puzzleInput);
        let increaseCounter = 0;
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
        const puzzleInputAsNumber = this.toInt(puzzleInput);
        let increaseCounter = 0;

        for (let i = 0; i < puzzleInputAsNumber.length - 3; i++) {
            const overlap = puzzleInputAsNumber[i + 1] + puzzleInputAsNumber[i + 2];
            const current = puzzleInputAsNumber[i] + overlap;
            const next = overlap + puzzleInputAsNumber[i + 3];

            if (next > current) {
                increaseCounter++;
            }
        }

        return increaseCounter.toString();
    }
}

//new Day1().run(1);

export default Day1;