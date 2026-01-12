import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        double sum = 0;
        double addedBonus = 0;
        for (int i = 0; i < n; i++) {
            char[] str = br.readLine().toCharArray();
            if (str[0] == 'A') {
                sum += 4;
            } else if (str[0] == 'B') {
                sum += 3;
            } else if (str[0] == 'C') {
                sum += 2;
            } else if (str[0] == 'D') {
                sum += 1;
            }

            if (str[1] == '1' && isGoodGrade(str[0])) {
                addedBonus += 0.05;
            } else if (str[1] == '2' && isGoodGrade(str[0])) {
                addedBonus += 0.025;
            }
        }

        sb.append(sum / n + addedBonus);

        bw.write(sb.toString());
        bw.flush();
    }

    public static boolean isGoodGrade(char c) {
        return (c == 'A' || c == 'B' || c == 'C');
    }
}
