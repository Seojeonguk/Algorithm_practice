import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            char[] contents = br.readLine().toCharArray();
            int spaceBar = Integer.parseInt(br.readLine());
            int[] keyboards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            sb.append(getTitle(contents, spaceBar, keyboards));

            bw.write(sb.toString());
        }
    }

    public static String getTitle(char[] contents, int spaceBar, int[] keyboards) {
        StringBuilder title = new StringBuilder();

        for (int idx = 0; idx < contents.length; idx++) {
            if (idx > 0 && contents[idx - 1] == contents[idx]) {
                continue;
            }
            
            if (idx == 0 || contents[idx - 1] == ' ') {
                title.append(Character.toUpperCase(contents[idx]));

                int keyboardIdx = toIdx(contents[idx]);
                keyboards[keyboardIdx]--;
                if (keyboards[keyboardIdx] < 0) {
                    return "-1";
                }
            }

            if (contents[idx] == ' ') {
                spaceBar--;
                if (spaceBar < 0) {
                    return "-1";
                }
            } else {
                int keyboardIdx = toIdx(contents[idx]);
                keyboards[keyboardIdx]--;
                if (keyboards[keyboardIdx] < 0) {
                    return "-1";
                }
            }
        }

        return title.toString();
    }

    public static int toIdx(char c) {
        return Character.toLowerCase(c) - 'a';
    }
}
