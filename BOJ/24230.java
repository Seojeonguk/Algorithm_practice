import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int peekCnt = Integer.parseInt(br.readLine());

            StringTokenizer colorInfo = new StringTokenizer(br.readLine());
            int[] colors = new int[peekCnt + 1];
            for (int peekNum = 1; peekNum <= peekCnt; peekNum++) {
                colors[peekNum] = Integer.parseInt(colorInfo.nextToken());
            }

            ArrayList<Integer>[] connected = new ArrayList[peekCnt + 1];
            for (int i = 1; i <= peekCnt; i++) {
                connected[i] = new ArrayList<>();
            }

            for (int i = 0; i < peekCnt - 1; i++) {
                StringTokenizer connectedInfo = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(connectedInfo.nextToken());
                int b = Integer.parseInt(connectedInfo.nextToken());

                connected[a].add(b);
                connected[b].add(a);
            }

            sb.append(calDrawColors(colors, connected, 0, 1));

            bw.write(sb.toString());
        }
    }

    public static int calDrawColors(int[] colors, ArrayList<Integer>[] connected, int parent, int current) {
        int drawColors = (colors[parent] != colors[current] ? 1 : 0);

        for (int next : connected[current]) {
            if (next == parent) {
                continue;
            }

            drawColors += calDrawColors(colors, connected, current, next);
        }

        return drawColors;
    }
}
