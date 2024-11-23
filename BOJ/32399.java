import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final StringBuilder HAMBURGER_STR = new StringBuilder("(1)");

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            String str = br.readLine();

            if (str.contentEquals(HAMBURGER_STR)) {
                sb.append(0);
            } else if (str.contentEquals(HAMBURGER_STR.reverse())) {
                sb.append(2);
            } else {
                sb.append(1);
            }

            bw.write(sb.toString());
        }
    }
}
