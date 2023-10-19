import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int cardCnt = Integer.parseInt(st.nextToken());
        int secretPrediction = Integer.parseInt(st.nextToken());
        int stepCnt = Integer.parseInt(st.nextToken());

        while (stepCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int chosenCnt = Integer.parseInt(st.nextToken());
            boolean containSecretPrediction = false;
            while (chosenCnt-- > 0) {
                int chosenCard = Integer.parseInt(st.nextToken());
                if (chosenCard == secretPrediction) {
                    containSecretPrediction = true;
                    break;
                }
            }
            sb.append(containSecretPrediction ? "KEEP" : "REMOVE").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
