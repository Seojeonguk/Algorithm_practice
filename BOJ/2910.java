import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int messageLength = Integer.parseInt(st.nextToken());
        int maxValue = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> appearedNum = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        ArrayList<Num> nums = new ArrayList<>();
        for (int i = 0; i < messageLength; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (appearedNum.containsKey(num)) {
                int idx = appearedNum.get(num);
                nums.get(idx).appeared();
            } else {
                int idx = appearedNum.size();
                appearedNum.put(num, idx);
                nums.add(new Num(num, 1, i));
            }
        }

        Collections.sort(nums, (o1, o2) -> {
            if (o1.appearedCnt == o2.appearedCnt) {
                return Integer.compare(o1.firstAppearedIdx, o2.firstAppearedIdx);
            }
            return Integer.compare(o2.appearedCnt, o1.appearedCnt);
        });

        for (Num num : nums) {
            for (int i = 0; i < num.appearedCnt; i++) {
                sb.append(num.value).append(" ");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Num {
        int value;
        int appearedCnt;
        int firstAppearedIdx;

        Num(int value, int appearedCnt, int firstAppearedIdx) {
            this.value = value;
            this.appearedCnt = appearedCnt;
            this.firstAppearedIdx = firstAppearedIdx;
        }

        public void appeared() {
            this.appearedCnt++;
        }
    }
}
