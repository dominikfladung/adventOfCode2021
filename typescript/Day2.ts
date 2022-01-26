import { BaseDay } from "./BaseDay";

class Day2 extends BaseDay {
    part1(puzzleInput: string[]): string {
        let depth = 0;
        let horizontalPosition = 0;

        puzzleInput.forEach(line => {
            let split = line.split(" ");
            let units = parseInt(split[1]);
            let direction = split[0].trim();

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
            let split = line.split(" ");
            let units = parseInt(split[1]);
            let direction = split[0].trim();

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

new Day2().run(2);