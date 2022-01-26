import fs from 'fs';

interface Day {
    part1(puzzleInput: Array<string>): string;
    part2(puzzleInput: Array<string>): string;

    run(day: number): void;
}

abstract class BaseDay implements Day  {
    abstract part1(puzzleInput: Array<string>): string;
    abstract part2(puzzleInput: Array<string>): string;

    toInt(puzzleInput: Array<string>) : Array<number> { 
        return puzzleInput.map(x => parseInt(x)) 
    }

    run(day: number) {
        const fileData = fs.readFileSync('../puzzle_input/' + day + '.txt', 'utf8');
        const puzzleInput = fileData.split("\n");

        console.log("Day: " + day);
        console.log("Part 1: ", this.part1(puzzleInput));
        console.log("Part 2: ", this.part2(puzzleInput));
    }
}

export { Day, BaseDay };