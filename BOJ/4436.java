import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String strN = "";
        while ((strN = br.readLine()) != null) {
            long n = Long.parseLong(strN);

            boolean[] appeared = new boolean[10];
            int appearedCnt = 0;
            for (long i = 1; ; i++) {
                long kn = n * i;

                while (kn > 0) {
                    int remainder = (int) (kn % 10);
                    if (!appeared[remainder]) {
                        appeared[remainder] = true;
                        appearedCnt++;
                    }
                    kn /= 10L;
                }

                if (appearedCnt == 10) {
                    sb.append(i).append("\n");
                    break;
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
