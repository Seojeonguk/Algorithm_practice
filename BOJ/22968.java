import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int testCase = Integer.parseInt(br.readLine());
            int[] minRequiredVertex = new int[44];
            minRequiredVertex[1] = 1;
            minRequiredVertex[2] = 2;
            for (int i = 3; i < 44; i++) {
                minRequiredVertex[i] = minRequiredVertex[i - 1] + minRequiredVertex[i - 2] + 1;
            }

            for (int tc = 0; tc < testCase; tc++) {
                int vertexCnt = Integer.parseInt(br.readLine());
                for (int i = 0; i < 44; i++) {
                    if (minRequiredVertex[i] > vertexCnt) {
                        sb.append(i - 1).append("\n");
                        break;
                    }
                }
            }

            bw.write(sb.toString());
        }
    }
}
