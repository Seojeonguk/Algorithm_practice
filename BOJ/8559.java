import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            String str = br.readLine();
            sb.append(getPotaga(str));

            bw.write(sb.toString());
        }
    }

    public static int getPotaga(String str) {
        if ("0".equals(str)) {
            return 1;
        }

        while (str.length() < 2) {
            str = "0" + str;
        }

        int n = (str.charAt(str.length() - 2) - '0') * 10 + (str.charAt(str.length() - 1) - '0');

        if (n % 4 == 0) {
            return 6;
        } else if (n % 4 == 1) {
            return 2;
        } else if (n % 4 == 2) {
            return 4;
        } else {
            return 8;
        }
    }
}
