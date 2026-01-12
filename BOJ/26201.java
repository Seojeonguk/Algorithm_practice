import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int length = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();

        int x = 0;
        int maxMonotoneChunks = 0;
        for (int idx = 0; idx < length; idx++) {
            if (str[idx] == 'a') {
                x += 1;
            } else {
                if (1 < x) {
                    maxMonotoneChunks += x;
                }

                x = 0;
            }
        }

        if (1 < x) {
            maxMonotoneChunks += x;
        }

        sb.append(maxMonotoneChunks);

        bw.write(sb.toString());
        bw.flush();
    }
}
