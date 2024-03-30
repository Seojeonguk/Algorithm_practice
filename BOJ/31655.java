import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] dates = br.readLine().split("/");
        boolean[] canBeMonths = new boolean[2];

        for (int i = 0; i < 2; i++) {
            canBeMonths[i] = (Integer.parseInt(dates[i]) <= 12);
        }

        if (canBeMonths[0] && canBeMonths[1]) {
            sb.append("either");
        } else if (canBeMonths[0]) {
            sb.append("US");
        } else {
            sb.append("EU");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
