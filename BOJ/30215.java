import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int doctorAge = Integer.parseInt(st.nextToken());
        int AlyssaAge = Integer.parseInt(st.nextToken());
        int KonariAge = Integer.parseInt(st.nextToken());

        sb.append(isFindNum(doctorAge, AlyssaAge, KonariAge));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int isFindNum(int doctorAge, int AlyssaAge, int KonariAge) {
        for (int a = 1; ; a++) {
            if (AlyssaAge * a > doctorAge) {
                break;
            }
            for (int k = 1; ; k++) {
                int sumAge = AlyssaAge * a + KonariAge * k;
                if (sumAge > doctorAge) {
                    break;
                }
                if (sumAge == doctorAge) {
                    return 1;
                }
            }

        }
        return 0;
    }
}
