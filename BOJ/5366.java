import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void  main(String[] args) throws Exception {
        HashMap<String, Integer> hm = new HashMap<>();
        ArrayList<String> fighterList = new ArrayList<>();
        while(true) {
            String fighter = br.readLine();
            if("0".equals(fighter)) {
                break;
            }

            Integer cnt = 0;
            if(hm.containsKey(fighter)) {
                cnt = hm.get(fighter);
            } else {
                fighterList.add(fighter);
            }
            hm.put(fighter,cnt+1);
        }

        int total = 0;
        for(String fighter : fighterList) {
            total += hm.get(fighter);
            sb.append(fighter + ": " + String.valueOf(hm.get(fighter) + "\n"));
        };
        sb.append("Grand Total: " + String.valueOf(total));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}