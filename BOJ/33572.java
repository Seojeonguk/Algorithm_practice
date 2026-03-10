import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int friendCnt = Integer.parseInt(st.nextToken());
        long dimigoTime = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long totalTime = 0;
        for (int i = 0; i < friendCnt; i++) {
            long fallingLoveTime = Long.parseLong(st.nextToken());
            totalTime += fallingLoveTime;
        }

        if (dimigoTime > totalTime - friendCnt) {
            sb.append("OUT");
        } else {
            sb.append("DIMI");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
