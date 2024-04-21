import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final String[] ROMA = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII"};

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int length = Integer.parseInt(br.readLine());
            String str = br.readLine();

            for (int i = 0; i < ROMA.length; i++) {
                if (str.contains(ROMA[i])) {
                    sb.append(i + 1).append(" ");
                }
            }

            bw.write(sb.toString());
        }
    }
}
