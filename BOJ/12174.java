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
            for (int tc = 1; tc <= testCase; tc++) {
                int byteSize = Integer.parseInt(br.readLine());
                String str = br.readLine();

                sb.append(String.format("Case #%d: %s\n", tc, translate(byteSize, str)));
            }

            bw.write(sb.toString());
        }
    }

    public static String translate(int byteSize, String str) {
        str = str.replaceAll("I", "1");
        str = str.replaceAll("O", "0");

        StringBuilder translation = new StringBuilder();
        for (int idx = 0; idx < byteSize; idx++) {
            String subStr = str.substring(idx * 8, (idx + 1) * 8);
            translation.append((char) (Integer.parseInt(subStr, 2)));
        }

        return translation.toString();
    }
}
