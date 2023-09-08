import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int MAX_SUM = 2000;

    public static void main(String[] args) throws Exception {
        boolean[] isPrime = new boolean[MAX_SUM];
        for (int i = 2; i < MAX_SUM; i++) {
            if (isPrime[i]) {
                continue;
            }
            for (int j = i + i; j < MAX_SUM; j += i) {
                isPrime[j] = true;
            }
        }

        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < size; idx++) {
            arr[idx] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Integer> ans = getAnswer(arr, isPrime);
        while (!ans.isEmpty()) {
            sb.append(ans.poll()).append(" ");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static PriorityQueue<Integer> getAnswer(int[] arr, boolean[] isPrime) {
        PriorityQueue<Integer> ret = new PriorityQueue<>();
        ArrayList<Integer>[] edge = new ArrayList[arr.length];

        for (int idx = 0; idx < arr.length; idx++) {
            edge[idx] = new ArrayList<>();
        }

        int oddCnt = 0, evenCnt = 0;
        for (int idx = 0; idx < arr.length; idx++) {
            if ((arr[idx] & 1) == 1) {
                oddCnt++;
            } else {
                evenCnt++;
            }
            for (int j = idx + 1; j < arr.length; j++) {
                if (!isPrime[arr[idx] + arr[j]]) {
                    edge[idx].add(j);
                    edge[j].add(idx);
                }
            }
        }
        if (oddCnt != evenCnt) {
            ret.add(-1);
            return ret;
        }

        boolean[] isVisit = new boolean[arr.length];
        int[] matched = new int[arr.length];

        while (!edge[0].isEmpty()) {
            int cnt = 0;
            Arrays.fill(matched, -1);
            for (int idx = 0; idx < arr.length; idx++) {
                Arrays.fill(isVisit, false);
                if (dfs(idx, isVisit, matched, edge)) {
                    cnt++;
                }
            }

            if (cnt != arr.length) {
                break;
            }

            int removeIdx = 0;
            for (int idx = 0; idx < matched.length; idx++) {
                if (matched[idx] == 0) {
                    removeIdx = idx;
                    break;
                }
            }

            ret.add(arr[removeIdx]);

            for (int idx = 0; idx < edge[0].size(); idx++) {
                if (edge[0].get(idx) == removeIdx) {
                    edge[0].remove(idx);
                    break;
                }
            }
        }

        if (ret.isEmpty()) {
            ret.add(-1);
        }
        return ret;
    }

    public static boolean dfs(int pos, boolean[] isVisit, int[] matched, ArrayList<Integer>[] edge) {
        if (isVisit[pos]) {
            return false;
        }
        isVisit[pos] = true;
        for (int next : edge[pos]) {
            if (matched[next] == -1 || dfs(matched[next], isVisit, matched, edge)) {
                matched[next] = pos;
                return true;
            }
        }
        return false;
    }
}
