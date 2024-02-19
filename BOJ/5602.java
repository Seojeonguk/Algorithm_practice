import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer info = new StringTokenizer(br.readLine());
        int studentCnt = Integer.parseInt(info.nextToken());
        int tripPlaceCnt = Integer.parseInt(info.nextToken());

        int[] agrees = new int[tripPlaceCnt];
        for (int i = 0; i < studentCnt; i++) {
            StringTokenizer studentOpinion = new StringTokenizer(br.readLine());
            for (int j = 0; j < tripPlaceCnt; j++) {
                int opinion = Integer.parseInt(studentOpinion.nextToken());
                if (opinion == 1) {
                    agrees[j]++;
                }
            }
        }

        Trip[] trips = new Trip[tripPlaceCnt];
        for (int i = 0; i < tripPlaceCnt; i++) {
            trips[i] = new Trip(agrees[i], i + 1);
        }

        Arrays.sort(trips, Comparator.comparingInt(Trip::getAgreeCnt).reversed().thenComparing(Trip::getIdx));

        for (int i = 0; i < tripPlaceCnt; i++) {
            sb.append(trips[i].idx).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Trip {
        int agreeCnt, idx;

        Trip(int agreeCnt, int idx) {
            this.agreeCnt = agreeCnt;
            this.idx = idx;
        }

        public int getAgreeCnt() {
            return agreeCnt;
        }

        public int getIdx() {
            return idx;
        }
    }
}
