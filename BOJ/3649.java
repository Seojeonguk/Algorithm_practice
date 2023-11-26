import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int CENTIMETER = 10000000;

    public static void main(String[] args) throws Exception {
        String str;
        while ((str = br.readLine()) != null && !"".equals(str)) {
            int holeWidth = Integer.parseInt(str);

            int legoCnt = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> appeared = new TreeMap<>();
            for (int lego = 0; lego < legoCnt; lego++) {
                int legoLength = Integer.parseInt(br.readLine());
                int appearedCnt = 0;
                if (appeared.containsKey(legoLength)) {
                    appearedCnt = appeared.get(legoLength);
                }
                appeared.put(legoLength, appearedCnt + 1);
            }

            int[] legoLengths = appeared.keySet().stream().mapToInt(Integer::intValue).toArray();

            int ans = -1;
            for (int lego = 0; lego < legoLengths.length; lego++) {
                int legoLength = legoLengths[lego];
                int idx = Arrays.binarySearch(legoLengths, holeWidth * CENTIMETER - legoLength);
                if (idx >= 0) {
                    int anotherLegoLength = legoLengths[idx];
                    if (legoLength == anotherLegoLength) {
                        if (appeared.get(legoLength) >= 2) {
                            ans = legoLength;
                            break;
                        }
                    } else {
                        ans = legoLength;
                        break;
                    }
                }
            }

            if (ans == -1) sb.append("danger").append("\n");
            else sb.append("yes ").append(ans).append(" ").append(holeWidth * CENTIMETER - ans).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
