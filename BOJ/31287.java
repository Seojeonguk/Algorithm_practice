import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int strLength = Integer.parseInt(st.nextToken());
        int repetitionCount = Integer.parseInt(st.nextToken());
        
        char[] moves = br.readLine().toCharArray();

        sb.append(canReachCenter(moves, repetitionCount) ? "YES" : "NO");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean canReachCenter(char[] moves, int repetitionCount) {
        if (repetitionCount > moves.length / 2) {
            repetitionCount = moves.length / 2;
        }

        int x = 0, y = 0;
        for (int i = 0; i < repetitionCount; i++) {
            for (char c : moves) {
                if (c == 'U') {
                    y++;
                } else if (c == 'D') {
                    y--;
                } else if (c == 'L') {
                    x--;
                } else if (c == 'R') {
                    x++;
                }

                if (x == 0 && y == 0) {
                    return true;
                }
            }
        }

        return false;
    }
}
