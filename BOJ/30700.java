import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

    static final char[] KOREA = {'K', 'O', 'R', 'E', 'A'};

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            char[] str = br.readLine().toCharArray();
            int koreaIdx = 0;

            int maxKoreaLength = 0;
            for (char c : str) {
                if (c == KOREA[koreaIdx]) {
                    koreaIdx = (koreaIdx + 1) % KOREA.length;
                    maxKoreaLength++;
                }
            }

            sb.append(maxKoreaLength);

            bw.write(sb.toString());
        }
    }
}
