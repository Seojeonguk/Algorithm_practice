import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int MAX = 100000;

    public static void main(String[] args) throws Exception {
        int queryCnt = Integer.parseInt(br.readLine());
        HashMap<String, Integer> nameIdxs = new HashMap<>();
        PriorityQueue<Integer>[] infoValues = new PriorityQueue[MAX];
        for (int i = 0; i < MAX; i++) {
            infoValues[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        long totalInfoValue = 0;
        int nameIdx = 0;
        for (int i = 0; i < queryCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            if (query == 1) {
                int k = Integer.parseInt(st.nextToken());
                int idx = nameIdx;
                if (nameIdxs.containsKey(name)) {
                    idx = nameIdxs.get(name);
                } else {
                    nameIdxs.put(name, nameIdx++);
                }
                for (int j = 0; j < k; j++) {
                    infoValues[idx].add(Integer.parseInt(st.nextToken()));
                }
            } else if (query == 2) {
                int idx = (nameIdxs.containsKey(name) ? nameIdxs.get(name) : -1);
                if (idx == -1) {
                    continue;
                }
                int cnt = Integer.parseInt(st.nextToken());
                while (!infoValues[idx].isEmpty() && cnt > 0) {
                    totalInfoValue += infoValues[idx].poll();
                    cnt--;
                }
            }
        }
        sb.append(totalInfoValue);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
