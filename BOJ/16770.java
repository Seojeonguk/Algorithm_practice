import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {

    static final int LIMIT_TIME = 1000;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int cowCnt = Integer.parseInt(br.readLine());
            int[] requiredBuckets = new int[LIMIT_TIME + 1];
            for (int i = 0; i < cowCnt; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                int bucket = Integer.parseInt(st.nextToken());

                requiredBuckets[s] += bucket;
                requiredBuckets[t] -= bucket;
            }

            int neededBucket = 0;
            for (int idx = 1; idx <= LIMIT_TIME; idx++) {
                requiredBuckets[idx] += requiredBuckets[idx - 1];
                neededBucket = Math.max(neededBucket, requiredBuckets[idx]);
            }

            sb.append(neededBucket);

            bw.write(sb.toString());
        }
    }
}
