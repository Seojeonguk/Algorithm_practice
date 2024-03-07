import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int length = Integer.parseInt(br.readLine());
        int[] brr = new int[length + 1];
        StringTokenizer mex = new StringTokenizer(br.readLine());
        for (int idx = 1; idx <= length; idx++) {
            brr[idx] = Integer.parseInt(mex.nextToken());
        }

        int[] arr = findOriginalArray(length, brr);
        if (arr[0] == 0) {
            sb.append("No");
        } else {
            sb.append("Yes").append("\n");
            for (int idx = 1; idx <= length; idx++) {
                sb.append(arr[idx]).append(" ");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int[] findOriginalArray(int length, int[] brr) {
        int[] arr = new int[brr.length];
        if (brr[length] != length + 1) {
            return arr;
        }

        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 1; i <= length; i++) {
            ts.add(i);
            if (brr[i] > i + 1) {
                return arr;
            }
        }

        arr[0] = 1;

        for (int i = 2; i <= length; i++) {
            if (brr[i - 1] > brr[i]) {
                arr[0] = 0;
                return arr;
            }
            if (brr[i - 1] != brr[i]) {
                arr[i] = brr[i - 1];
                ts.remove(arr[i]);
            }
        }

        for (int i = length; i >= 1; i--) {
            if (arr[i] == 0) {
                arr[i] = ts.pollLast();
            }
        }

        return arr;
    }
}
