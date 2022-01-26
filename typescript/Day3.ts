import { BaseDay } from "./BaseDay";

class Day3 extends BaseDay {
    part1(puzzleInput: string[]): string {
        let length = puzzleInput[0].length;
        let zeros: Array<number> = [];

        let gammaRate = "";
        let epsilonRate = "";

        for (let i = 0; i < puzzleInput.length; i++) {
            for (let j = 0; j < length; j++) {
                let number = puzzleInput[i][j];
                if (number == '0') {
                    if (zeros[j]) {
                        zeros[j]++;
                    } else {
                        zeros[j] = 1;
                    }
                }
            }
        }

        for (let i = 0; i < length; i++) {
            if (zeros[i] > Math.floor(puzzleInput.length / 2)) {
                gammaRate += "0";
                epsilonRate += "1";
            } else {
                gammaRate += "1";
                epsilonRate += "0";
            }
        }

        return (parseInt(gammaRate, 2) * parseInt(epsilonRate, 2)).toString();
    }

    part2(puzzleInput: string[]): string {
        let oxygenGeneratorRating = this.getOxygenGeneratorRating(puzzleInput);
        let co2ScrubberRating = this.getCo2ScrubberRating(puzzleInput);
        return (oxygenGeneratorRating * co2ScrubberRating).toString();
    }

    getCo2ScrubberRating(puzzleInput: Array<string>) {
        let list: Array<string> = this.getListOfLessOccurs(puzzleInput);
        return parseInt(list[0], 2);
    }

    getOxygenGeneratorRating(puzzleInput: Array<string>) {
        let list: Array<string> = this.getListOfMostOccurs(puzzleInput);
        return parseInt(list[0], 2);
    }

    getListOfMostOccurs(list: Array<string>, position: number = 0): Array<string> {
        return this.getListOf(list, position, (countZeros: number, countOnes: number) => countZeros > countOnes);
    }

    getListOfLessOccurs(list: Array<string>, position: number = 0): Array<string> {
        return this.getListOf(list, position, (countZeros: number, countOnes: number) => countZeros <= countOnes);
    }

    getListOf(list: Array<string>, position: number, listFilter: ListFilter): Array<string> {
        let numbersWithZeros: Array<string> = [];
        let numbersWithOnes: Array<string> = [];

        for (let i = 0; i < list.length; i++) {
            let number = list[i][position];
            if (number == '0') {
                numbersWithZeros.push(list[i]);
            } else {
                numbersWithOnes.push(list[i]);
            }
        }

        let countZeros = numbersWithZeros.length;
        let countOnes = numbersWithOnes.length;
        let nextList: Array<string> = listFilter(countZeros, countOnes) ? numbersWithZeros : numbersWithOnes;

        if (nextList.length == 1) {
            return nextList;
        } else {
            return this.getListOf(nextList, position + 1, listFilter);
        }
    }
}

interface ListFilter {
    (countZeros: number, countOnes: number): boolean;
}

new Day3().run(3);