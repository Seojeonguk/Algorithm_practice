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

            int pairCnt = Integer.parseInt(br.readLine());
            for (int i = 0; i < pairCnt; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                String t = st.nextToken();

                int idx = Math.max(s.indexOf("x"), s.indexOf("X"));
                char c = t.charAt(idx);
                if (Character.isAlphabetic(c)) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(c);
                }
            }

            bw.write(sb.toString());
        }
    }
}
