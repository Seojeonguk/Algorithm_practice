import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int testCase = Integer.parseInt(br.readLine());
            for (int tc = 0; tc < testCase; tc++) {
                char[] str = br.readLine().toCharArray();

                for (int idx = 0; idx < str.length; idx++) {
                    if (Character.isUpperCase(str[idx]) && idx > 0) {
                        sb.append("_");
                    }
                    sb.append(Character.toLowerCase(str[idx]));
                }

                sb.append("\n");
            }

            bw.write(sb.toString());
        }
    }
}
