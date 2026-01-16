import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String passwords = br.readLine();
        int passwordCnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int idx = 0;
        for (int i = 0; i < passwordCnt; i++) {
            String type = st.nextToken();
            String disk = "";
            if ("char".equals(type)) {
                disk = passwords.substring(idx, idx + 2);
                idx += 2;
            } else if ("int".equals(type)) {
                disk = passwords.substring(idx, idx + 8);
                idx += 8;
            } else {
                disk = passwords.substring(idx, idx + 16);
                idx += 16;
            }

            sb.append(Long.parseLong(disk, 16)).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
