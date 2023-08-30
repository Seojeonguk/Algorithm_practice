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
            for (int aroundDistributor : aroundPersons[distributor]) {
                aroundDistributors[aroundDistributor]++;
            }
        }

        int time = 1;
        while (!distributors.isEmpty()) {
            HashSet<Integer> candidateDistributors = new HashSet<>();
            int size = distributors.size();
            for (int i = 0; i < size; i++) {
                int currentDistributor = distributors.poll();
                for (int candidateNextDistributors : aroundPersons[currentDistributor]) {
                    if (rumorTime[candidateNextDistributors] != -1 || aroundDistributors[candidateNextDistributors] < (aroundPersons[candidateNextDistributors].size() + 1) / 2) {
                        continue;
                    }
                    candidateDistributors.add(candidateNextDistributors);
                }
            }

            Iterator<Integer> iterator = candidateDistributors.iterator();
            while (iterator.hasNext()) {
                int distributor = iterator.next();
                rumorTime[distributor] = time;
                for (int aroundDistributor : aroundPersons[distributor]) {
                    aroundDistributors[aroundDistributor]++;
                }
                distributors.add(distributor);
            }
            time++;
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
