import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int availableClass = Integer.parseInt(st.nextToken());
            int reservedClass = Integer.parseInt(st.nextToken());

            int availableMemberCnt = 0;

            int memberCnt = Integer.parseInt(br.readLine());
            for (int memberNum = 0; memberNum < memberCnt; memberNum++) {
                int memberAvailableCnt = Integer.parseInt(br.readLine());

                StringTokenizer memberAvailableClasses = new StringTokenizer(br.readLine());
                for (int i = 0; i < memberAvailableCnt; i++) {
                    int memberAvailableClass = Integer.parseInt(memberAvailableClasses.nextToken());
                    if (memberAvailableClass == reservedClass) {
                        availableMemberCnt++;
                    }
                }
            }

            sb.append(availableMemberCnt == memberCnt ? "YES" : "NO");

            bw.write(sb.toString());
        }
    }
}
