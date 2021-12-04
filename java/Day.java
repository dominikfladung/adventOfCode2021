import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public abstract class Day {
    abstract int part1(String[] puzzleInput);

    abstract int part2(String[] puzzleInput);

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

    protected int[] toInt(String[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(array[i]);
        }
        return result;
    }

    protected String[] filterEmptyRows(String[] array) {
        return Arrays.stream(array).filter(x -> !x.trim().isEmpty()).toArray(String[]::new);
    }

    protected void run(int day) {
        try {
            String[] puzzleInput = readFile("./../puzzle_input/" + day + ".txt");
            System.out.println("Day: " + day);
            ExecutorService executorService = Executors.newFixedThreadPool(2);
            Future<Integer> futurePart1 = executorService.submit(() -> this.part1(puzzleInput));
            Future<Integer> futurePart2 = executorService.submit(() -> this.part2(puzzleInput));
            executorService.shutdown();

            System.out.println("Part 1: " + futurePart1.get());
            System.out.println("Part 2: " + futurePart2.get());
        } catch (ExecutionException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}