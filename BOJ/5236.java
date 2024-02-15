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
            String str = br.readLine();

            String LDS = "";
            for (int i = 0; i < str.length(); i++) {
                String subStr = str.substring(i);
                if (isDS(subStr)) {
                    LDS = subStr;
                    break;
                }
            }

            sb.append("The longest decreasing suffix of ").append(str).append(" is ").append(LDS).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isDS(String s) {
        char[] str = s.toCharArray();
        for (int i = 1; i < str.length; i++) {
            if (str[i] >= str[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
