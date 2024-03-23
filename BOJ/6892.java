import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= testCase; tc++) {
            String a = br.readLine();
            String b = br.readLine();
            String c = br.readLine();

            if (isFix(a, b, c) || isFix(b, a, c) || isFix(c, a, b)) {
                sb.append("No\n");
            } else {
                sb.append("Yes\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isFix(String a, String b, String c) {
        return (a.startsWith(b) || a.endsWith(b) || a.startsWith(c) || a.endsWith(c));
    }
}
