import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int girlGroupCnt = Integer.parseInt(st.nextToken());
        int query = Integer.parseInt(st.nextToken());

        String[] girlGroups = new String[girlGroupCnt];
        HashMap<String, Integer> girlGroupIndex = new HashMap<>();
        TreeSet<String>[] girlGroupMembers = new TreeSet[girlGroupCnt];

        for (int girlGroup = 0; girlGroup < girlGroupCnt; girlGroup++) {
            String girlGroupName = br.readLine();
            girlGroups[girlGroup] = girlGroupName;

            girlGroupMembers[girlGroup] = new TreeSet<>();

            girlGroupIndex.put(girlGroupName, girlGroup);
            int memberCnt = Integer.parseInt(br.readLine());
            for (int i = 0; i < memberCnt; i++) {
                String member = br.readLine();
                girlGroupMembers[girlGroup].add(member);
            }
        }

        while (query-- > 0) {
            String name = br.readLine();
            int command = Integer.parseInt(br.readLine());
            if (command == 1) {
                for (int i = 0; i < girlGroupCnt; i++) {
                    if (girlGroupMembers[i].contains(name)) {
                        sb.append(girlGroups[i]).append("\n");
                        break;
                    }
                }
            } else {
                int idx = girlGroupIndex.get(name);
                for (String member : girlGroupMembers[idx]) {
                    sb.append(member).append("\n");
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
