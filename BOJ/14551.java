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
            int gameCnt = Integer.parseInt(st.nextToken());
            int mod = Integer.parseInt(st.nextToken());

            int way = 1;
            for (int i = 0; i < gameCnt; i++) {
                int card = Integer.parseInt(br.readLine());
                way = (way * (card == 0 ? 1 : card)) % mod;
            }

            sb.append(way % mod);

            bw.write(sb.toString());
        }
    }
}
