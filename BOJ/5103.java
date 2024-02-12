import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String title = br.readLine();
            if ("#".equals(title)) {
                break;
            }

            StringTokenizer DVDInfo = new StringTokenizer(br.readLine());
            int maxDVDCnt = Integer.parseInt(DVDInfo.nextToken());
            int currentTitleNum = Integer.parseInt(DVDInfo.nextToken());

            int transactionCnt = Integer.parseInt(br.readLine());
            for (int i = 0; i < transactionCnt; i++) {
                StringTokenizer transactionInfo = new StringTokenizer(br.readLine());
                char saleKind = transactionInfo.nextToken().charAt(0);
                int DVDCnt = Integer.parseInt(transactionInfo.nextToken());

                if (saleKind == 'S') {
                    currentTitleNum = Math.max(0, currentTitleNum - DVDCnt);
                } else {
                    currentTitleNum = Math.min(currentTitleNum + DVDCnt, maxDVDCnt);
                }
            }

            sb.append(title).append(" ").append(currentTitleNum).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
