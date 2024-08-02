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

            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(calSum(start, end));

            bw.write(sb.toString());
        }
    }

    public static int calSum(int start, int end) {
        int sum = 0;

        for (int i = 1; i <= end; i++) {
            int a = end / i;
            int b = (start - 1) / i;

            sum += (a - b) * (i % 2 == 0 ? 1 : -1);
        }

        return sum;
    }
}
