import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = "";
        while ((str = br.readLine()) != null) {
            char[] binary = Integer.toBinaryString(Integer.parseInt(str)).toCharArray();
            int zeroOneDiff = 0;
            for (int i = 0; i < binary.length; i++) {
                if (binary[i] == '0') {
                    zeroOneDiff++;
                } else {
                    zeroOneDiff--;
                }
            }

            if (zeroOneDiff > 0) {
                sb.append("left\n");
            } else if (zeroOneDiff < 0) {
                sb.append("right\n");
            } else {
                sb.append("straight\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
