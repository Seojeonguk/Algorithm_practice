import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int length = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            char[] arr = new char[length];
            Arrays.fill(arr, 'A');

            if (26 * length < value || length > value) {
                sb.append("!");
            } else {
                value -= length;
                for (int i = length - 1; i >= 0; i--) {
                    if (value >= 26) {
                        value -= 25;
                        arr[i] += 25;
                    } else {
                        arr[i] += value;
                        break;
                    }
                }
                sb.append(arr);
            }

            bw.write(sb.toString());
        }
    }
}
