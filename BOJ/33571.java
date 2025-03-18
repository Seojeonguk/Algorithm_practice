import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final int[] UPPER_HOLES = {1, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0};
    static final int[] LOWER_HOLES = {1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            char[] str = br.readLine().toCharArray();

            int holeCnt = 0;
            for (char c : str) {
                if (c == ' ') {
                    continue;
                }

                if (Character.isAlphabetic(c)) {
                    if (Character.isUpperCase(c)) {
                        holeCnt += UPPER_HOLES[c - 'A'];
                    } else {
                        holeCnt += LOWER_HOLES[c - 'a'];
                    }
                } else if (c == '@') {
                    holeCnt++;
                }
            }

            sb.append(holeCnt);

            bw.write(sb.toString());
        }
    }
}
