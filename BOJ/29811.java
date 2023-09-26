import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] people = new int[n + m + 1];

        TreeMap<Integer, TreeSet<Integer>> roadA = getCostToIndex(people, 1, n);
        TreeMap<Integer, TreeSet<Integer>> roadB = getCostToIndex(people, n + 1, n + m);

        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            char mode = st.nextToken().charAt(0);
            if (mode == 'U') {
                int idx = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                int deleteKey = people[idx];

                removeKeyAndAddIdx(idx <= n ? roadA : roadB, deleteKey, idx, value);
                people[idx] = value;
            } else {
                int minFromDoorToPlayground = getMinRoadNum(roadA);
                int minFromPlaygroundToITBT = getMinRoadNum(roadB);
                sb.append(minFromDoorToPlayground).append(" ").append(minFromPlaygroundToITBT).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static TreeMap<Integer, TreeSet<Integer>> getCostToIndex(int[] people, int startIdx, int endIdx) throws IOException {
        TreeMap<Integer, TreeSet<Integer>> road = new TreeMap<>();
        st = new StringTokenizer(br.readLine());
        for (int idx = startIdx; idx <= endIdx; idx++) {
            people[idx] = Integer.parseInt(st.nextToken());
            TreeSet<Integer> tree = (road.containsKey(people[idx]) ? road.get(people[idx]) : new TreeSet<>());
            tree.add(idx);
            road.put(people[idx], tree);
        }
        return road;
    }

    public static void removeKeyAndAddIdx(TreeMap<Integer, TreeSet<Integer>> road, int deleteKey, int idx, int value) {
        TreeSet<Integer> tree = road.get(deleteKey);
        tree.remove(idx);
        if (tree.isEmpty()) {
            road.remove(deleteKey);
        }

        TreeSet<Integer> tree2 = road.get(value);
        if (tree2 == null || tree2.isEmpty()) {
            tree2 = new TreeSet<>();
        }
        tree2.add(idx);
        road.put(value, tree2);
    }

    public static int getMinRoadNum(TreeMap<Integer, TreeSet<Integer>> road) {
        Iterator<Integer> it = road.keySet().iterator();
        TreeSet<Integer> minIndexes = road.get(it.next());
        return minIndexes.iterator().next();
    }
}
