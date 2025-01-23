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

            int reportCnt = Integer.parseInt(br.readLine());

            int requiredPaperCnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < reportCnt; i++) {
                int papers = Integer.parseInt(st.nextToken());
                requiredPaperCnt += papers / 2 + (papers % 2 == 0 ? 0 : 1);
            }

            sb.append(requiredPaperCnt);

            bw.write(sb.toString());
        }
    }
}
