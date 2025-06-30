import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int numCandidate = Integer.parseInt(br.readLine());

            int validNameCnt = 0;
            for (int i = 0; i < numCandidate; i++) {
                char[] candidateName = br.readLine().toCharArray();
                if (candidateName[0] == 'C') {
                    validNameCnt++;
                }
            }

            sb.append(validNameCnt);

            bw.write(sb.toString());
        }
    }
}
