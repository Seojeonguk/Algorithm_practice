import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int buildingCnt = Integer.parseInt(br.readLine());
        int[] buildings = new int[buildingCnt];
        for (int idx = 0; idx < buildingCnt; idx++) {
            buildings[idx] = Integer.parseInt(br.readLine());
        }

        Stack<Information> informations = new Stack<>();
        long ans = 0;
        for (int idx = buildingCnt - 1; idx >= 0; idx--) {
            int height = buildings[idx];
            int cnt = 1;

            while (!informations.isEmpty()) {
                if (informations.peek().getHeight() >= height) {
                    break;
                }
                cnt += informations.pop().getCnt();
            }
            informations.add(new Information(height, cnt));
            ans += cnt - 1;
        }
        sb.append(ans);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Information {
        private int height;
        private int cnt;

        Information(int height, int cnt) {
            this.height = height;
            this.cnt = cnt;
        }

        public int getHeight() {
            return this.height;
        }

        public int getCnt() {
            return this.cnt;
        }
    }
}
