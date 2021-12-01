const fs = require('fs')

class Day {
    part1(puzzelInput) { return -1 }
    part2(puzzelInput) { return -1 }

    toInt(puzzelInput) { 
        return puzzelInput.map(x => parseInt(x)) 
    }

    run(day) {
        const fileData = fs.readFileSync('./puzzle_input/' + day + '.txt', 'utf8');
        const puzzleInput = fileData.split("\n");

        console.log("Day: " + day);
        console.log("Part 1: ", this.part1(puzzleInput));
        console.log("Part 2: ", this.part2(puzzleInput));
    }
}

exports.Day = Day;