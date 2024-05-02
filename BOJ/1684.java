import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int arrLength = Integer.parseInt(br.readLine());

            int[] arr = new int[arrLength];
            StringTokenizer arrInfo = new StringTokenizer(br.readLine());
            for (int idx = 0; idx < arrLength; idx++) {
                arr[idx] = Integer.parseInt(arrInfo.nextToken());
            }

            Arrays.sort(arr);
            ArrayList<Integer> diff = new ArrayList<>();
            for (int idx = 0; idx < arrLength - 1; idx++) {
                diff.add(arr[idx + 1] - arr[idx]);
            }

            int d = diff.get(0);
            for (int i = 1; i < diff.size(); i++) {
                d = gcd(d, diff.get(i));
            }

            sb.append(d);

            bw.write(sb.toString());
        }
    }

    public static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
}
