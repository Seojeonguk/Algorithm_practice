import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] keyword = br.readLine().toCharArray();
        int[] shifted = new int[keyword.length];
        for (int idx = 0; idx < keyword.length; idx++) {
            shifted[idx] = keyword[idx] - 'A';
        }

        char[] message = br.readLine().toCharArray();
        int shiftIdx = 0;
        for (int idx = 0; idx < message.length; idx++) {
            char c = message[idx];
            if (!Character.isUpperCase(c)) {
                continue;
            }
            char encodedC = (char) ((c - 'A' + shifted[shiftIdx]) % 26 + 'A');
            sb.append(encodedC);

            shiftIdx = (shiftIdx + 1) % shifted.length;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
