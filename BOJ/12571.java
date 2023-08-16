import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCase; tc++) {
            List<WireConnection> wireConnections = new ArrayList<>();
            int wireCnt = Integer.parseInt(br.readLine());
            for (int i = 0; i < wireCnt; i++) {
                st = new StringTokenizer(br.readLine());
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());

                wireConnections.add(new WireConnection(left, right));
            }

            int crossCnt = 0;
            for (int i = 0; i < wireCnt; i++) {
                for (int j = i + 1; j < wireCnt; j++) {
                    int leftCompare = Integer.compare(wireConnections.get(i).getLeft(), wireConnections.get(j).getLeft());
                    int rightCompare = Integer.compare(wireConnections.get(i).getRight(), wireConnections.get(j).getRight());

                    if (leftCompare != rightCompare) {
                        crossCnt++;
                    }
                }
            }
            sb.append(String.format("Case #%d: %d\n", tc + 1, crossCnt));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class WireConnection {
        private int left;
        private int right;

        WireConnection(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public int getLeft() {
            return this.left;
        }

        public int getRight() {
            return this.right;
        }
    }
}
