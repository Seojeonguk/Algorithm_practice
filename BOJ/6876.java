import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final String[] PHONE = {"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= testCase; tc++) {
            String memorable = br.readLine().replaceAll("-", "");
            for (int idx = 0; idx < 10; idx++) {
                char c = memorable.charAt(idx);
                if (Character.isDigit(c)) {
                    sb.append(c);
                } else {
                    for (int i = 2; i < PHONE.length; i++) {
                        if (PHONE[i].indexOf(c) > -1) {
                            sb.append(i);
                            break;
                        }
                    }
                }

                if (idx == 2 || idx == 5) {
                    sb.append("-");
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
