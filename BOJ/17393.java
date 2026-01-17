import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int length = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] inks = new long[length];
        for (int i = 0; i < length; i++) {
            inks[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        long[] viscosities = new long[length];
        for (int i = 0; i < length; i++) {
            viscosities[i] = Long.parseLong(st.nextToken());
        }

        for (int idx = 0; idx < length; idx++) {
            long ink = inks[idx];

            int a = binarySearch(viscosities, idx + 1, length, ink);
            sb.append(a - (idx + 1)).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    public static int binarySearch(long[] arr, int startIdx, int endIdx, long target) {
        if (startIdx >= endIdx) {
            return endIdx;
        }
        int midIdx = (startIdx + endIdx) / 2;

        if (arr[midIdx] <= target) {
            return binarySearch(arr, midIdx + 1, endIdx, target);
        }

        return binarySearch(arr, startIdx, midIdx, target);
    }
}
