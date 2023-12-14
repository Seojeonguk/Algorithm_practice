import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        char[][] ch = new char[5][3];
        String[] strings = br.readLine().split(" ");
        for (String str : strings) {
            ch[str.charAt(0) - '1'][str.charAt(1) - 'A']++;
        }
        boolean isGood = true;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (ch[i][j] < (i == 4 ? 2 : 1)) {
                    isGood = false;
                    break;
                }
            }
        }

        sb.append(isGood ? "TAK" : "NIE");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
