import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());

            int bottomStartTrainCnt = Integer.parseInt(st.nextToken());
            int leftStartTrainCnt = Integer.parseInt(st.nextToken());

            HashSet<Integer> bottomStartTrains = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            while (bottomStartTrainCnt-- > 0) {
                int bottomStartTrain = Integer.parseInt(st.nextToken());
                bottomStartTrains.add(bottomStartTrain);
            }

            int requiredMinimumCancelTrainCnt = 0;
            st = new StringTokenizer(br.readLine());
            while (leftStartTrainCnt-- > 0) {
                int leftStartTrain = Integer.parseInt(st.nextToken());
                if (bottomStartTrains.contains(leftStartTrain)) {
                    requiredMinimumCancelTrainCnt++;
                }
            }

            sb.append(requiredMinimumCancelTrainCnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
