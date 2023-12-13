import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int classroomCnt = Integer.parseInt(st.nextToken());
        int schoolCnt = Integer.parseInt(st.nextToken());

        long sum = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).sum();

        sb.append((sum + classroomCnt - 1) / classroomCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
