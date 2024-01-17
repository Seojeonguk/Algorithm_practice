import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int ret = 4;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int verticalSize = Integer.parseInt(st.nextToken());
        int totalHorizontal = Integer.parseInt(st.nextToken());
        int horizontalSize = Integer.parseInt(st.nextToken());

        boolean[][] existHorizontalLine = new boolean[verticalSize + 1][horizontalSize + 1];
        for (int i = 0; i < totalHorizontal; i++) {
            st = new StringTokenizer(br.readLine());
            int horizontal = Integer.parseInt(st.nextToken());
            int vertical = Integer.parseInt(st.nextToken());

            existHorizontalLine[vertical][horizontal] = true;
        }

        for (int i = 0; i < 4; i++) {
            calMinAddedLine(verticalSize, horizontalSize, existHorizontalLine, 0, i);
            if (ret != 4) {
                break;
            }
        }
        if (ret == 4) {
            ret = -1;
        }

        sb.append(ret);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void calMinAddedLine(int vSize, int hSize, boolean[][] horizontalLine, int cnt, int max) {
        if (max == cnt) {
            if (verifyLineByLine(vSize, hSize, horizontalLine)) {
                ret = max;
            }
            return;
        }

        for (int vertical = 1; vertical < vSize; vertical++) {
            for (int horizontal = 1; horizontal <= hSize; horizontal++) {
                if (horizontalLine[vertical - 1][horizontal] || horizontalLine[vertical][horizontal] || horizontalLine[vertical + 1][horizontal]) {
                    continue;
                }

                horizontalLine[vertical][horizontal] = true;
                calMinAddedLine(vSize, hSize, horizontalLine, cnt + 1, max);
                horizontalLine[vertical][horizontal] = false;
            }
        }
    }

    public static boolean verifyLineByLine(int vSize, int hSize, boolean[][] horizontalLine) {
        for (int vertical = 1; vertical <= vSize; vertical++) {
            int currentVertical = vertical;
            int currentHorizontal = 0;

            while (currentHorizontal != hSize) {
                currentHorizontal++;
                if (horizontalLine[currentVertical][currentHorizontal]) {
                    currentVertical++;
                } else if (horizontalLine[currentVertical - 1][currentHorizontal]) {
                    currentVertical--;
                }
            }
            if (currentVertical != vertical) {
                return false;
            }
        }
        return true;
    }
}
