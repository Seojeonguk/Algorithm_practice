import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String firstX = br.readLine();
            if ("END".equals(firstX)) {
                break;
            }

            int smallestValue = calSmallestValue(firstX);
            sb.append(smallestValue).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calSmallestValue(String str) {
        if (str.length() < 2) {
            return ("1".equals(str) ? 1 : 2);
        }

        int prev = str.length();
        int smallestValue = 1;
        while (true) {
            smallestValue++;
            int cur = String.valueOf(prev).length();
            if (prev == cur) {
                break;
            }
            prev = cur;
        }

        return smallestValue;
    }
}
