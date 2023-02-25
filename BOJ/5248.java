import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static Scanner sc = new Scanner(System.in);



    public static void  main(String[] args) throws Exception {
        sc.nextLine();

        while(sc.hasNext()) {
             Map<String,Integer> m = new HashMap<>();
             int idx=0;
             String[] s = new String[1000];
             ArrayList<Integer>[] l = new ArrayList[1000];
             boolean isVisit[] = new boolean[1000];
             String input="";
             Queue<Integer[]> q = new LinkedList<>();
             PriorityQueue<String> pq = new PriorityQueue<>();

             while(sc.hasNext()) {
                 input = sc.nextLine();
                 if(input.equals("GRAPH END"))
                     break;

                 String[] inputs = input.split(" ");
                 String mine = inputs[0];
                 if(!m.containsKey(mine)) {
                     l[idx]=new ArrayList<>();
                     s[idx] = mine;
                     m.put(mine,idx++);
                 }
                 int mine_idx = m.get(mine);
                 for(int i=1;i<inputs.length;i++) {
                     String node = inputs[i];

                     if (!m.containsKey(node)) {
                         l[idx] = new ArrayList<>();
                         s[idx] = node;
                         m.put(node, idx++);
                     }
                     int node_idx = m.get(node);

                     l[mine_idx].add(node_idx);
                     l[node_idx].add(mine_idx);
                 }
             }

             while(sc.hasNext()) {
                 input = sc.nextLine();
                 if(input.equals("GRAPH BEGIN")) {
                     break;
                 }
                 Arrays.fill(isVisit, false);

                 int st_idx = m.get(input);
                 q.add(new Integer[]{0, st_idx});
                 isVisit[st_idx] = true;

                 while (!q.isEmpty()) {
                     int cnt = q.peek()[0];
                     int now = q.peek()[1];
                     q.poll();

                     if (cnt == 2) {
                         pq.add(s[now]);
                         continue;
                     }

                     for (Integer next : l[now]) {
                         if (isVisit[next]) continue;
                         isVisit[next] = true;
                         q.add(new Integer[]{cnt + 1, next});
                     }
                 }

                 while (!pq.isEmpty()) {
                     sb.append(pq.poll() + " ");
                 }
                 sb.append("\n");
             }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}