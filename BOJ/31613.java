import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int x = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        sb.append(calManipulationCnt(x, n));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calManipulationCnt(int x, int n) {
        int manipulationCnt = 0;

        while (x < n) {
            int r = x % 3;
            if (r == 0) {
                x++;
            } else if (r == 1) {
                x *= 2;
            } else if (r == 2) {
                x *= 3;
            }
            manipulationCnt++;
        }

        return manipulationCnt;
    }
}
