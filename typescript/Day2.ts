import { BaseDay } from "./BaseDay";

class Day2 extends BaseDay {
    part1(puzzleInput: string[]): string {
        let depth = 0;
        let horizontalPosition = 0;

        puzzleInput.forEach(line => {
            const split = line.split(" ");
            const units = parseInt(split[1]);
            const direction = split[0].trim();

            if (direction === "forward") {
                horizontalPosition += units;
            } else if (direction === "up") {
                depth -= units;
            } else if (direction === "down") {
                depth += units;
            }
        });

        return (depth * horizontalPosition).toString();
    }

    part2(puzzleInput: string[]): string {
        let depth = 0;
        let horizontalPosition = 0;
        let aim = 0;

        puzzleInput.forEach(line => {
            const split = line.split(" ");
            const units = parseInt(split[1]);
            const direction = split[0].trim();

            if (direction === "forward") {
                horizontalPosition += units;
                depth += units * aim;
            } else if (direction === "up") {
                aim -= units;
            } else if (direction === "down") {
                aim += units;
            }
        });

        return (depth * horizontalPosition).toString();
    }
}

//new Day2().run(2);

export default Day2;