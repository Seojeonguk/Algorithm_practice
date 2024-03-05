import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer heartWeights = new StringTokenizer(br.readLine());
        long haveHeartWeight = Long.parseLong(heartWeights.nextToken());
        long wantHeartWeight = Long.parseLong(heartWeights.nextToken());

        HashSet<Long> appeared = new HashSet<>();
        Queue<Long> q = new LinkedList<>();

        appeared.add(haveHeartWeight);
        q.add(haveHeartWeight);

        boolean canMakeWeight = false;
        while (!q.isEmpty()) {
            long cur = q.poll();

            if (cur == wantHeartWeight) {
                canMakeWeight = true;
                break;
            }

            long half = cur / 2;
            if (!appeared.contains(half)) {
                appeared.add(half);
                q.add(half);
            }

            if (cur % 2 == 1) {
                if (!appeared.contains(half + 1)) {
                    appeared.add(half + 1);
                    q.add(half + 1);
                }
            }
        }

        sb.append(canMakeWeight ? "YES" : "NO");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
