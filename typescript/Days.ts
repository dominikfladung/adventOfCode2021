import Day1 from './Day1';
import Day2 from './Day2';
import Day3 from './Day3';
import { Day } from './BaseDay';

let days: Array<Day> = [];

days.push(new Day1(), new Day2(), new Day3());

for (let i = 0; i < days.length; i++) {
    days[i].run(i + 1);
    console.log("");
}