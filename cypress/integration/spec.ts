import Day1 from "../../typescript/Day1"
import Day2 from '../../typescript//Day2';
import Day3 from '../../typescript//Day3';
import { Day } from '../../typescript//BaseDay';

class DaySolution {
    day: Day
    part1Solution: string
    part2Solution: string

    constructor(day: Day, part1Solution: string, part2Solution: string) {
        this.day = day;
        this.part1Solution = part1Solution;
        this.part2Solution = part2Solution;
    }
}

let testDays: Array<DaySolution> = [];

testDays.push(
    new DaySolution(new Day1(), "1711", "1743"),
    new DaySolution(new Day2(), "2091984", "2086261056"),
    new DaySolution(new Day3(), "3009600", "6940518"),
);

for (let i = 1; i <= testDays.length; i++) {
    describe(`Day ${i}`, () => {
        const testDay = testDays[i - 1];
        
        it('Part1', () => {
            testDay.day.runPart1(i).then(result => {
                expect(result).to.equal(testDay.part1Solution)
            });
        })

        it('Part2', () => {
            testDay.day.runPart2(i).then(result => {
                expect(result).to.equal(testDay.part2Solution)
            });
        })
    })
}

