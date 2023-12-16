import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= testCase; tc++) {
            st = new StringTokenizer(br.readLine());
            int interestingCougar = Integer.parseInt(st.nextToken());
            int totalCougar = Integer.parseInt(st.nextToken());

            int ancestryCnt = 0;
            int ancestryCougar = interestingCougar;
            int[] parents = new int[totalCougar + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= totalCougar; i++) {
                parents[i] = Integer.parseInt(st.nextToken());
            }

            while (ancestryCougar != 0) {
                ancestryCnt++;
                ancestryCougar = parents[ancestryCougar];
            }

            sb.append("Data Set ").append(tc).append(":\n").append(ancestryCnt).append("\n\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
