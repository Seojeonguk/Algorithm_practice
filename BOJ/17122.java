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

            int tc = Integer.parseInt(br.readLine());

            for (int testCase = 0; testCase < tc; testCase++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String left = st.nextToken();
                int right = Integer.parseInt(st.nextToken());

                int leftRow = left.charAt(1) - '0' - 1;
                int leftCol = left.charAt(0) - 'A';

                int rightRow = (right - 1) / 8;
                int rightCol = (right - 1) % 8;

                int leftColor = (leftRow + leftCol) % 2;
                int rightColor = (rightRow + rightCol) % 2;

                sb.append(leftColor == rightColor ? "YES" : "NO").append("\n");
            }

            bw.write(sb.toString());
        }
    }
}
