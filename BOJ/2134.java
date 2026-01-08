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

        private int originalContainerFloor;
        private int newContainerFloor;
        private int workerCnt;

        private int[] originalContainerThingCnt;
        private int[] newContainerThingCnt;

        private int maxMovedThingCnt;
        private long cost;

        public void init() throws IOException {
            StringTokenizer st = new StringTokenizer(br.readLine());
            originalContainerFloor = Integer.parseInt(st.nextToken());
            newContainerFloor = Integer.parseInt(st.nextToken());
            workerCnt = Integer.parseInt(st.nextToken());

            originalContainerThingCnt = new int[originalContainerFloor];
            for (int i = 0; i < originalContainerFloor; i++) {
                originalContainerThingCnt[i] = Integer.parseInt(br.readLine());
            }

            newContainerThingCnt = new int[newContainerFloor];
            for (int i = 0; i < newContainerFloor; i++) {
                newContainerThingCnt[i] = Integer.parseInt(br.readLine());
            }
        }

        public void solve() throws IOException {
            maxMovedThingCnt = Math.min(
                    Arrays.stream(originalContainerThingCnt).sum(),
                    Arrays.stream(newContainerThingCnt).sum()
            );

            int originalContainerIdx = 0;
            int newContainerIdx = 0;
            while (originalContainerIdx < originalContainerFloor && newContainerIdx < newContainerFloor) {
                int movedThingCnt = Math.min(
                        originalContainerThingCnt[originalContainerIdx],
                        newContainerThingCnt[newContainerIdx]
                );
                cost += (long) (originalContainerIdx + newContainerIdx + 2) * movedThingCnt;

                newContainerThingCnt[newContainerIdx] -= movedThingCnt;
                if (newContainerThingCnt[newContainerIdx] == 0) {
                    newContainerIdx += 1;
                }

                originalContainerThingCnt[originalContainerIdx] -= movedThingCnt;
                if (originalContainerThingCnt[originalContainerIdx] == 0) {
                    originalContainerIdx += 1;
                }
            }
        }

        public void printAns() throws IOException {
            bw.write(String.format("%d %d", maxMovedThingCnt, cost));
            bw.flush();
        }
    }
}
