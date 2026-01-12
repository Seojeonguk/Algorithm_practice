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
        int[] arr = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (arr[0] == arr[3]) {
            arr[1] = arr[2];

            sb.append("JAH").append("\n");
            for (int i = 0; i < 4; i++) {
                sb.append(arr[i]).append(" ");
            }
        } else if (arr[1] == arr[2]) {
            arr[0] = arr[3];

            sb.append("JAH").append("\n");
            for (int i = 0; i < 4; i++) {
                sb.append(arr[i]).append(" ");
            }
        } else {
            sb.append("EI");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
