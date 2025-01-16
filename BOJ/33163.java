import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int length = Integer.parseInt(br.readLine());
            char[] str = br.readLine().toCharArray();

            for (int idx = 0; idx < length; idx++) {
                sb.append(convert(str[idx]));
            }

            bw.write(sb.toString());
        }
    }

    public static char convert(char c) {
        if (c == 'J') {
            return 'O';
        } else if (c == 'O') {
            return 'I';
        } else {
            return 'J';
        }
    }
}
