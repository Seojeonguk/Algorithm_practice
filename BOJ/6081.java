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

        StringTokenizer info = new StringTokenizer(br.readLine());
        int totalDay = Integer.parseInt(info.nextToken());
        int queryCnt = Integer.parseInt(info.nextToken());

        int[] hayBaleCounts = new int[totalDay + 1];
        int[] prefixSum = new int[totalDay + 1];
        for (int day = 1; day <= totalDay; day++) {
            hayBaleCounts[day] = Integer.parseInt(br.readLine());
            prefixSum[day] = prefixSum[day - 1] + hayBaleCounts[day];
        }

        for (int query = 0; query < queryCnt; query++) {
            StringTokenizer range = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(range.nextToken());
            int end = Integer.parseInt(range.nextToken());

            sb.append(prefixSum[end] - prefixSum[start - 1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
