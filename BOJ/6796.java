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

        int[] values = new int[2];

        while (true) {
            StringTokenizer queryInfo = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(queryInfo.nextToken());

            if (query == 1) {
                char x = queryInfo.nextToken().charAt(0);
                int changedValue = Integer.parseInt(queryInfo.nextToken());
                values[x - 'A'] = changedValue;
            } else if (query == 2) {
                char x = queryInfo.nextToken().charAt(0);
                sb.append(values[x - 'A']).append("\n");
            } else if (query == 3) {
                char x = queryInfo.nextToken().charAt(0);
                char y = queryInfo.nextToken().charAt(0);
                values[x - 'A'] += values[y - 'A'];
            } else if (query == 4) {
                char x = queryInfo.nextToken().charAt(0);
                char y = queryInfo.nextToken().charAt(0);
                values[x - 'A'] *= values[y - 'A'];
            } else if (query == 5) {
                char x = queryInfo.nextToken().charAt(0);
                char y = queryInfo.nextToken().charAt(0);
                values[x - 'A'] -= values[y - 'A'];
            } else if (query == 6) {
                char x = queryInfo.nextToken().charAt(0);
                char y = queryInfo.nextToken().charAt(0);
                values[x - 'A'] /= values[y - 'A'];
            } else if (query == 7) {
                break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
