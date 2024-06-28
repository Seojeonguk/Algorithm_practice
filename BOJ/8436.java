import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            char[] word = br.readLine().toCharArray();

            int possibleWordCnt = 1;
            for (char c : word) {
                if (c == 'T' || c == 'D' || c == 'L' || c == 'F') {
                    possibleWordCnt *= 2;
                }
            }

            sb.append(possibleWordCnt);

            bw.write(sb.toString());
        }
    }
}
