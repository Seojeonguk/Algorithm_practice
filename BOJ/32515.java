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
            char[] JHSelections = br.readLine().toCharArray();
            char[] JHKeys = br.readLine().toCharArray();
            char[] IASelections = br.readLine().toCharArray();
            char[] IAKeys = br.readLine().toCharArray();

            boolean isWiretapping = false;
            for (int idx = 0; idx < length; idx++) {
                if (JHSelections[idx] == IASelections[idx]) {
                    if (JHKeys[idx] != IAKeys[idx]) {
                        isWiretapping = true;
                    }
                    sb.append(JHKeys[idx]);
                }
            }

            if (isWiretapping) {
                sb.delete(0, sb.length()).append("htg!");
            }

            bw.write(sb.toString());
        }
    }
}
