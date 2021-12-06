import java.util.ArrayList;
import java.util.List;

class Day6 extends Day {

    @Override
    int part1(String[] puzzleInput) {
        var initialState = toInt(puzzleInput[0].split(","));
        var lanternfishs = new ArrayList<Lanternfish>();

        for(var i : initialState) {
            lanternfishs.add(new Lanternfish(i));
        }
        //printState(lanternfishs, 0);
        for(int i = 0; i < 80; i++) {
            var newFishes = new ArrayList<Lanternfish>();
            for(var fish : lanternfishs) {
                if(fish.isCreateNewFish()) {
                    newFishes.add(new Lanternfish(8));
                }
            }
            lanternfishs.addAll(newFishes);
           // printState(lanternfishs, i + 1);
        }

        return lanternfishs.size();
    }

    public void printState(List<Lanternfish> fishes, int day) {
        System.out.print("After " + day + " days ");
        for(var fish : fishes) {
            System.out.print(fish.internalTimer + ",");
        }
        System.out.println("");
    }

    @Override
    int part2(String[] puzzleInput) {
        var lanternfishs = toInt(puzzleInput[0].split(","));

       
       return 0;
    }

    public static void main(String[] args) {
        new Day6().run(6);
    }

    private class Lanternfish {
        private int internalTimer = 8;

        Lanternfish(int internalTimer) {
            this.internalTimer = internalTimer;
        }

        public boolean isCreateNewFish() {
            if(internalTimer > 0) {
                internalTimer--;
                return false;
            }
            internalTimer = 6;
            return true;
        }
    }
}