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

            int addedScrollCnt = Integer.parseInt(st.nextToken());
            int multipleScrollCnt = Integer.parseInt(st.nextToken());

            StringTokenizer addedScrolls = new StringTokenizer(br.readLine());
            long sumScroll = 0;
            for (int i = 0; i < addedScrollCnt; i++) {
                sumScroll += Long.parseLong(addedScrolls.nextToken());
            }

            StringTokenizer multipleScrolls = new StringTokenizer(br.readLine());
            long multipleScroll = 1;
            for (int i = 0; i < multipleScrollCnt; i++) {
                long scroll = Long.parseLong(multipleScrolls.nextToken());
                if (scroll > 0) {
                    multipleScroll *= scroll;
                }
            }

            sb.append(sumScroll * multipleScroll);

            bw.write(sb.toString());
        }
    }
}
