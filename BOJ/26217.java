import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int flowerKindCnt = Integer.parseInt(br.readLine());
            double neededExpectedFlowers = 0;
            for (int i = 1; i <= flowerKindCnt; i++) {
                neededExpectedFlowers += 1.0 * flowerKindCnt / i;
            }

            sb.append(neededExpectedFlowers);

            bw.write(sb.toString());
        }
    }
}
