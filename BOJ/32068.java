import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int testCase = Integer.parseInt(br.readLine());
            for (int tc = 0; tc < testCase; tc++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                int start = Integer.parseInt(st.nextToken());

                sb.append(getEndedRound(l, r, start)).append("\n");
            }

            bw.write(sb.toString());
        }
    }

    public static int getEndedRound(int l, int r, int start) {
        int leftDistance = Math.abs(l - start);
        int rightDistance = Math.abs(r - start);

        return (leftDistance >= rightDistance ? rightDistance * 2 : leftDistance * 2 + 1);
    }
}
