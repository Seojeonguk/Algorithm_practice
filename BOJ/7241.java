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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] selected = new int[3];
        for (int i = 0; i < 3; i++) {
            selected[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(selected);

        int x = Integer.parseInt(br.readLine());
        if (assemble(selected, 0, 1, 2) == x) {
            sb.append(1);
        } else if (assemble(selected, 0, 2, 1) == x) {
            sb.append(2);
        } else if (assemble(selected, 1, 0, 2) == x) {
            sb.append(3);
        } else if (assemble(selected, 1, 2, 0) == x) {
            sb.append(4);
        } else if (assemble(selected, 2, 0, 1) == x) {
            sb.append(5);
        } else if (assemble(selected, 2, 1, 0) == x) {
            sb.append(6);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int assemble(int[] arr, int a, int b, int c) {
        return arr[a] * 100 + arr[b] * 10 + arr[c];
    }
}
