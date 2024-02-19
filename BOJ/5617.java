import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] triangles = new int[3];
        while (true) {
            int[] triangleLengths = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Arrays.sort(triangleLengths);

            if (triangleLengths[0] + triangleLengths[1] <= triangleLengths[2]) {
                break;
            }

            int smallestLengthPow = triangleLengths[0] * triangleLengths[0];
            int middleLengthPow = triangleLengths[1] * triangleLengths[1];
            int longestLengthPow = triangleLengths[2] * triangleLengths[2];

            if (smallestLengthPow + middleLengthPow < longestLengthPow) {
                triangles[2]++;
            } else if (smallestLengthPow + middleLengthPow > longestLengthPow) {
                triangles[1]++;
            } else {
                triangles[0]++;
            }
        }

        sb.append(Arrays.stream(triangles).sum()).append(" ");
        for (int i = 0; i < 3; i++) {
            sb.append(triangles[i]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
