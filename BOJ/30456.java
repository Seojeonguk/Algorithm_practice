import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int bottomNum = Integer.parseInt(st.nextToken());
        int originalLength = Integer.parseInt(st.nextToken());

        for (int i = 0; i < originalLength - 1; i++) {
            sb.append(1);
        }
        sb.append(bottomNum);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
