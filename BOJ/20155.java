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

            StringTokenizer convenienceStoreToken = new StringTokenizer(br.readLine());
            int convenienceStoreCnt = Integer.parseInt(convenienceStoreToken.nextToken());
            int totalConvenienceStoreCategoryCnt = Integer.parseInt(convenienceStoreToken.nextToken());

            int[] convenienceStoreCategoryCnt = new int[totalConvenienceStoreCategoryCnt + 1];
            StringTokenizer convenienceBrandToken = new StringTokenizer(br.readLine());
            int requiredPeople = 0;
            for (int i = 0; i < convenienceStoreCnt; i++) {
                int convenienceBrand = Integer.parseInt(convenienceBrandToken.nextToken());
                convenienceStoreCategoryCnt[convenienceBrand]++;

                requiredPeople = Math.max(requiredPeople, convenienceStoreCategoryCnt[convenienceBrand]);
            }

            sb.append(requiredPeople);

            bw.write(sb.toString());
        }
    }
}
