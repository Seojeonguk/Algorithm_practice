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
            String str = "";

            int[] chars = new int[2];
            while ((str = br.readLine()) != null && !str.equals("")) {
                check(chars, str);
            }

            int efficiencyRatio = 10000 * (chars[0] - chars[1]) / chars[0];
            if (efficiencyRatio % 10 >= 5) {
                efficiencyRatio += 10;
            }

            int decimal = (efficiencyRatio / 10) % 10;

            sb.append("Efficiency ratio is ").append(efficiencyRatio / 100).append(decimal > 0 ? "." + decimal : "").append("%.\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void check(int[] chars, String str) {
        char[] s = str.toCharArray();
        for (int idx = 0; idx < s.length; idx++) {
            if (s[idx] == '#') {
                chars[1]++;
            }
            chars[0]++;
        }
    }
}
