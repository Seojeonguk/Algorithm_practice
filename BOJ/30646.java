import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int arraySize = Integer.parseInt(br.readLine());

        int[] arr = new int[arraySize + 1];
        long[] prefixSums = new long[arraySize + 1];
        HashMap<Integer, AppearIndex> appearedValues = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= arraySize; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefixSums[i] = prefixSums[i - 1] + arr[i];

            if (!appearedValues.containsKey(arr[i])) {
                AppearIndex appearIndex = new AppearIndex(i);
                appearedValues.put(arr[i], appearIndex);
            } else {
                AppearIndex appearIndex = appearedValues.get(arr[i]);
                appearIndex.setEnd(i);
            }
        }

        long maxSum = 0, maxSumCnt = 0;
        Iterator<Integer> it = appearedValues.keySet().iterator();
        while (it.hasNext()) {
            int key = it.next();
            AppearIndex appearIndex = appearedValues.get(key);
            long sum = prefixSums[appearIndex.end] - prefixSums[appearIndex.start - 1];

            if (sum > maxSum) {
                maxSum = sum;
                maxSumCnt = 1;
            } else if (sum == maxSum) {
                maxSumCnt++;
            }
        }

        sb.append(maxSum).append(" ").append(maxSumCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class AppearIndex {
        int start, end;

        AppearIndex(int idx) {
            this.start = idx;
            this.end = idx;
        }

        public void setEnd(int idx) {
            this.end = idx;
        }
    }
}
