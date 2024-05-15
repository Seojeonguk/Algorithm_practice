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
            for (int tc = 0; tc < testCase; tc++) {
                int length = Integer.parseInt(br.readLine());
                String[] v1 = br.readLine().split(" ");
                String[] v2 = br.readLine().split(" ");

                int hammingDistance = 0;
                for (int idx = 0; idx < length; idx++) {
                    if (!v1[idx].equals(v2[idx])) {
                        hammingDistance++;
                    }
                }

                sb.append(hammingDistance).append("\n");
            }

            bw.write(sb.toString());
        }
    }
}
