import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int ribbonCnt = Integer.parseInt(br.readLine());
        int[] ribbonPlaces = new int[ribbonCnt];
        int[] ribbonLengths = new int[ribbonCnt];
        char[] ribbonColors = new char[ribbonCnt];

        st = new StringTokenizer(br.readLine());
        for (int ribbon = 0; ribbon < ribbonCnt; ribbon++) {
            ribbonPlaces[ribbon] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int ribbon = 0; ribbon < ribbonCnt; ribbon++) {
            ribbonLengths[ribbon] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int ribbon = 0; ribbon < ribbonCnt; ribbon++) {
            ribbonColors[ribbon] = st.nextToken().charAt(0);
        }

        int firstBeautifulRibbon = -1, secondBeautifulRibbon = -1;
        for (int idx = 0; idx < ribbonCnt; idx++) {
            for (int idx2 = idx + 1; idx2 < ribbonCnt; idx2++) {
                if (Math.abs(ribbonPlaces[idx] - ribbonPlaces[idx2]) <= ribbonLengths[idx] + ribbonLengths[idx2] && ribbonColors[idx] != ribbonColors[idx2]) {
                    firstBeautifulRibbon = idx + 1;
                    secondBeautifulRibbon = idx2 + 1;
                    break;
                }
            }
        }

        if (firstBeautifulRibbon != -1) {
            sb.append("YES").append("\n").append(firstBeautifulRibbon).append(" ").append(secondBeautifulRibbon);
        } else {
            sb.append("NO");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
