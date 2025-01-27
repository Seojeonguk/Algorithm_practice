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

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(getResult(a, b));

            bw.write(sb.toString());
        }
    }

    public static char getResult(int a, int b) {
        char result = 0;

        if (a == 0) {
            if (b == 1 || b == 2 || b == 3 || b == 4) {
                result = '>';
            } else if (b == 5) {
                result = '<';
            }
        } else if (a == 2) {
            if (b == 0) {
                result = '<';
            } else if (b == 1 || b == 3 || b == 4 || b == 5) {
                result = '>';
            }
        } else if (a == 5) {
            if (b == 0 | b == 1 || b == 3 || b == 4) {
                result = '>';
            } else if (b == 2) {
                result = '<';
            }
        } else {
            if (b == 0 || b == 2 || b == 5) {
                result = '<';
            }
        }

        return result == 0 ? '=' : result;
    }
}
