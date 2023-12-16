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
        int currentInventions = Integer.parseInt(st.nextToken());
        int createInventionPerWeek = Integer.parseInt(st.nextToken());

        int inventionAfterTenWeek = currentInventions + createInventionPerWeek * 10;
        int orderedInventions = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            int currentCompetitorInventions = Integer.parseInt(st.nextToken());
            int createCompetitorInventionPerWeek = Integer.parseInt(st.nextToken());

            int competitorInventionAfterTenWeek = currentCompetitorInventions + createCompetitorInventionPerWeek * 10;
            orderedInventions = Math.max(orderedInventions, competitorInventionAfterTenWeek - inventionAfterTenWeek + 1);
        }

        sb.append(orderedInventions);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
