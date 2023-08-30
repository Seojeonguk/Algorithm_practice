import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int personCnt = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] aroundPersons = new ArrayList[personCnt + 1];
        int[] rumorTime = new int[personCnt + 1];
        int[] aroundDistributors = new int[personCnt + 1];
        for (int i = 1; i <= personCnt; i++) {
            rumorTime[i] = -1;
            aroundPersons[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            while (true) {
                int around = Integer.parseInt(st.nextToken());
                if (around == 0) {
                    break;
                }
                aroundPersons[i].add(around);
            }
        }
        int firstDistributorCnt = Integer.parseInt(br.readLine());
        Queue<Integer> distributors = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < firstDistributorCnt; i++) {
            int distributor = Integer.parseInt(st.nextToken());
            rumorTime[distributor] = 0;
            distributors.add(distributor);
        }

        while (!distributors.isEmpty()) {
            int distributor = distributors.poll();

            for (int nextDistributor : aroundPersons[distributor]) {
                aroundDistributors[nextDistributor]++;

                if (rumorTime[nextDistributor] != -1 || aroundDistributors[nextDistributor] < (aroundPersons[nextDistributor].size() + 1) / 2) {
                    continue;
                }
                distributors.add(nextDistributor);
                rumorTime[nextDistributor] = rumorTime[distributor] + 1;
            }
        }

        for (int idx = 1; idx <= personCnt; idx++) {
            sb.append(rumorTime[idx]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
