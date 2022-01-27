import { readFileSync } from 'fs';

interface Day {
    part1(puzzleInput: Array<string>): string;
    part2(puzzleInput: Array<string>): string;
    
    runPart1(day: number): Promise<string>;
    runPart2(day: number): Promise<string>;

    run(day: number): void;
}

abstract class BaseDay implements Day {
    abstract part1(puzzleInput: Array<string>): string;
    abstract part2(puzzleInput: Array<string>): string;

    toInt(puzzleInput: Array<string>): Array<number> {
        return puzzleInput.map(x => parseInt(x))
    }

    async getPuzzleInput(day: number): Promise<Array<string>> {
        const file = await import('./puzzle_input/' + day + '.ts');
        return file.input.split("\n");
    }

    run(day: number) {
        this.getPuzzleInput(day).then(puzzleInput => {
            console.log("Day: " + day);
            console.log("Part 1: ", this.part1(puzzleInput));
            console.log("Part 2: ", this.part2(puzzleInput));
            console.log("");
        })
    }

    async runPart1(day: number): Promise<string> {
        return this.part1(await this.getPuzzleInput(day));
    }

    async runPart2(day: number): Promise<string> {
        return this.part2(await this.getPuzzleInput(day));
    }
}

export { Day, BaseDay };