import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public abstract class Day {
    abstract int Part1(String[] puzzleInput);

    abstract int Part2(String[] puzzleInput);

    protected static String[] readFile(String path) throws IOException {
        List<String> lines = new ArrayList<String>();
        InputStream inputStream = new FileInputStream(path);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines.toArray(new String[lines.size()]);
    }

    protected int[] ToInt(String[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(array[i]);
        }
        return result;
    }

    protected void run(int day) {
        try {
            String[] puzzleInput = readFile("./../puzzle_input/" + day + ".txt");
            System.out.println("Day: " + day);
            System.out.println("Part 1: " + this.Part1(puzzleInput));
            System.out.println("Part 2: " + this.Part2(puzzleInput));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}