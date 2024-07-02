import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int scaleCnt = Integer.parseInt(br.readLine());
            char[] word = br.readLine().toCharArray();

            int minCubes = getMinCubes(scaleCnt, word);
            sb.append(minCubes == -1 ? "Impossible" : minCubes);

            bw.write(sb.toString());
        }
    }

    public static int getMinCubes(int scaleCnt, char[] word) {
        if (scaleCnt < word.length) {
            return -1;
        }

        int minCubes = 0;
        for (char c : word) {
            minCubes += (c - 'a' + 1);
        }

        return minCubes;
    }
}
