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

        private int wineTypeCnt;
        private int drinkableCnt;
        private int[] wineTastes;
        private long maxTasty;

        public void init() throws IOException {
            StringTokenizer st = new StringTokenizer(br.readLine());
            wineTypeCnt = Integer.parseInt(st.nextToken());
            drinkableCnt = Integer.parseInt(st.nextToken());

            wineTastes = new int[wineTypeCnt + 1];

            StringTokenizer wineToken = new StringTokenizer(br.readLine());
            for (int i = 1; i <= wineTypeCnt; i++) {
                wineTastes[i] = Integer.parseInt(wineToken.nextToken());
            }
        }

        public void solve() throws IOException {
            Arrays.sort(wineTastes);

            int left = 0;
            int right = wineTypeCnt + 1;

            for (int i = 0; i < drinkableCnt; i++) {
                if (i % 2 == 0) {
                    right--;
                    maxTasty += Math.max(0, wineTastes[right] - wineTastes[left]);
                } else {
                    left++;
                }
            }
        }

        public void printAns() throws IOException {
            bw.write(String.valueOf(maxTasty));
            bw.flush();
        }
    }
}
