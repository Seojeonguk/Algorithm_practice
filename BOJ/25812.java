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

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int teamMemberCnt = Integer.parseInt(st.nextToken());
        int fixedRaised = Integer.parseInt(st.nextToken());

        int selectFixedRaised = 0, selectDoubleRaised = 0;
        for (int i = 0; i < teamMemberCnt; i++) {
            int currentSalary = Integer.parseInt(br.readLine());
            if (currentSalary > fixedRaised) {
                selectDoubleRaised++;
            } else if (currentSalary < fixedRaised) {
                selectFixedRaised++;
            }
        }

        if (selectFixedRaised < selectDoubleRaised) {
            sb.append(2);
        } else if (selectFixedRaised > selectDoubleRaised) {
            sb.append(1);
        } else {
            sb.append(0);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
