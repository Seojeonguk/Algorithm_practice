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
        int festivalX = Integer.parseInt(st.nextToken());
        int festivalY = Integer.parseInt(st.nextToken());

        int students = Integer.parseInt(br.readLine());
        for (int student = 0; student < students; student++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x == festivalX || y == festivalY) {
                sb.append(0);
            } else {
                sb.append(1);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
