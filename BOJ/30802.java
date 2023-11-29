import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int participantCnt = Integer.parseInt(br.readLine());


        int[] shirtSizes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        st = new StringTokenizer(br.readLine());

        int shirtBundle = Integer.parseInt(st.nextToken());
        int penBundle = Integer.parseInt(st.nextToken());

        int minShirtBundle = 0;
        for (int i = 0; i < shirtSizes.length; i++) {
            minShirtBundle += shirtSizes[i] / shirtBundle + (shirtSizes[i] % shirtBundle > 0 ? 1 : 0);
        }

        sb.append(minShirtBundle).append("\n")
                .append(participantCnt / penBundle).append(" ").append(participantCnt % penBundle);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
