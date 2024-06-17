import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int octopusCnt = Integer.parseInt(br.readLine());

            int recursionCnt = (octopusCnt / 2) * 2;
            for (int i = 0; i < recursionCnt; i++) {
                sb.append(i % 2 == 0 ? 1 : 2).append(" ");
            }

            if (octopusCnt % 2 == 1) {
                sb.append(3);
            }

            bw.write(sb.toString());
        }
    }
}
