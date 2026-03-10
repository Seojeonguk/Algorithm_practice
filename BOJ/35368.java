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
        int roomCnt = Integer.parseInt(st.nextToken());
        int exitRoom = Integer.parseInt(st.nextToken());
        int cratesCnt = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = 0;
        for (int i = 0; i < cratesCnt; i++) {
            int cratesPlace = Integer.parseInt(br.readLine());

            if (exitRoom > cratesPlace) {
                left++;
            } else {
                right++;
            }
        }

        sb.append(Math.min(left, right));

        bw.write(sb.toString());
        bw.flush();
    }
}
