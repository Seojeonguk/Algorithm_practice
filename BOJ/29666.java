import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int[] arr = new int[3];
        String str = br.readLine();
        for (int i = 0; i < 3; i++) {
            char c = str.charAt(i);
            arr[i] = c - '0';
            if (arr[i] == 0) {
                arr[i] = 11;
            }
        }

        Arrays.sort(arr);
        if ((arr[0] + 3 == arr[1] && arr[1] + 3 == arr[2]) || (arr[0] + 1 == arr[1] && arr[1] + 1 == arr[2])) {
            sb.append("Unlocked");
        } else {
            sb.append("Locked");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
