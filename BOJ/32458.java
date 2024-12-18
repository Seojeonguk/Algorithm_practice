import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            char[] floatingPointNum = br.readLine().toCharArray();

            for (char c : floatingPointNum) {
                if (c == '.') {
                    break;
                }

                sb.append(c);
            }

            bw.write(sb.toString());
        }
    }
}
