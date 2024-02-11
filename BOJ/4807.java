import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; ; tc++) {
            int arrSize = Integer.parseInt(br.readLine());
            if (arrSize == 0) {
                break;
            }

            int[] arr = new int[arrSize];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < arrSize; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int everyEntrySameIteration = calEveryEntrySameIteration(arr);
            sb.append("Case ").append(tc).append(": ");
            if (everyEntrySameIteration == -1) {
                sb.append("not attained\n");
            } else {
                sb.append(everyEntrySameIteration).append(" iterations\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calEveryEntrySameIteration(int[] arr) {
        int iteration = -1;

        for (int i = 0; i <= 1000; i++) {
            if (isSame(arr)) {
                iteration = i;
                break;
            }
            arr = rotation(arr);
        }

        return iteration;
    }

    public static int[] rotation(int[] arr) {
        int[] brr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            brr[i] = Math.abs(arr[i] - arr[(i + 1) % arr.length]);
        }
        return brr;
    }

    public static boolean isSame(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[0] != arr[i]) {
                return false;
            }
        }

        return true;
    }
}
