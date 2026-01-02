import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        Problem problem = new Problem();
        problem.init();
        problem.solve();
        problem.printAns();
    }

    public static class Problem {

        private final int MAX_X = 10000 * 3;

        private int platformCnt;
        private Platform[] platforms;
        private int[] prevHeights;
        private int requiredPillarsLength;

        public void init() throws IOException {
            platformCnt = Integer.parseInt(br.readLine());
            platforms = new Platform[platformCnt];
            prevHeights = new int[MAX_X + 1];

            for (int i = 0; i < platformCnt; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int height = Integer.parseInt(st.nextToken());
                int startX = Integer.parseInt(st.nextToken());
                int endX = Integer.parseInt(st.nextToken());

                platforms[i] = new Platform(height, startX, endX);
            }
        }

        public void solve() throws IOException {
            Arrays.sort(platforms, (a, b) -> {
                if (a.height != b.height) {
                    return Integer.compare(a.height, b.height);
                }
                return Integer.compare(a.startX, b.startX);
            });

            for (int platformNum = 0; platformNum < platformCnt; platformNum++) {
                int height = platforms[platformNum].height;
                int startX = platforms[platformNum].startX * 2 + 1;
                int endX = platforms[platformNum].endX * 2 - 1;

                requiredPillarsLength += height * 2 - prevHeights[startX] - prevHeights[endX];

                for (int x = startX; x <= endX; x++) {
                    prevHeights[x] = height;
                }
            }
        }

        public void printAns() throws IOException {
            bw.write(String.valueOf(requiredPillarsLength));
            bw.flush();
        }
    }

    public static class Platform {
        private int height;
        private int startX;
        private int endX;

        public Platform(int height, int startX, int endX) {
            this.height = height;
            this.startX = startX;
            this.endX = endX;
        }
    }
}
