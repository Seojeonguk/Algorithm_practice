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

            int arrSize = Integer.parseInt(br.readLine());
            boolean isLastEven = false;
            int maxArr = 1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < arrSize; i++) {
                int a = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    isLastEven = (a % 2 == 0);
                }

                if (isLastEven && a % 2 == 1) {
                    maxArr++;
                    isLastEven = false;
                } else if (!isLastEven && a % 2 == 0) {
                    maxArr++;
                    isLastEven = true;
                }
            }

            sb.append(maxArr);

            bw.write(sb.toString());
        }
    }
}
