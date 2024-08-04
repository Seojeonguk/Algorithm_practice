import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int MAX_DAY = 31;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int requestCnt = Integer.parseInt(br.readLine());

            int[][] requestInfos = new int[requestCnt][2];
            for (int i = 0; i < requestCnt; i++) {
                StringTokenizer requestInfoToken = new StringTokenizer(br.readLine());
                requestInfos[i][0] = Integer.parseInt(requestInfoToken.nextToken());
                requestInfos[i][1] = Integer.parseInt(requestInfoToken.nextToken());
            }

            int bookCnt = Integer.parseInt(br.readLine());

            sb.append(canProcessAllRequest(requestInfos, bookCnt));

            bw.write(sb.toString());
        }
    }

    public static int canProcessAllRequest(int[][] requestInfos, int bookCnt) {
        int[] borrowBooks = new int[MAX_DAY + 1];
        for (int i = 0; i < requestInfos.length; i++) {
            borrowBooks[requestInfos[i][0]]++;
            borrowBooks[requestInfos[i][1]]--;
        }

        for (int i = 1; i < borrowBooks.length; i++) {
            borrowBooks[i] += borrowBooks[i - 1];
        }

        for (int borrowBook : borrowBooks) {
            if (borrowBook > bookCnt) {
                return 0;
            }
        }

        return 1;
    }
}
