import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int modificationCnt = Integer.parseInt(br.readLine());
            for (int i = 0; i < modificationCnt; i++) {
                char[] modification = br.readLine().toCharArray();

                int value = getValue(modification);
                sb.append(value).append("\n");
            }

            bw.write(sb.toString());
        }
    }

    private static int getValue(char[] modification) {
        int value = 0;
        int reverse = 0;

        for (char c : modification) {
            if (c != '!') {
                if (c == '1') {
                    value = 1;
                }
                break;
            }
            reverse++;
        }

        if (value == 0 && modification[modification.length - 1] == '!') {
            value = 1;
        }

        if (reverse % 2 == 1) {
            value = 1 - value;
        }
        return value;
    }
}
