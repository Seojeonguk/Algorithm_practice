import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int pushBtnCnt = Integer.parseInt(br.readLine());
            long heatedTime = 0;
            for (int i = 0; i < pushBtnCnt; i++) {
                heatedTime += (i / 5 + 1) * 30L;
            }

            sb.append(heatedTime);

            bw.write(sb.toString());
        }
    }
}
