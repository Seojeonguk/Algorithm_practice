import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= testCase; tc++) {
            StringTokenizer texts = new StringTokenizer(br.readLine());
            char[] keyword = texts.nextToken().toCharArray();
            char[] plainText = texts.nextToken().toCharArray();

            int[] shifts = new int[keyword.length];
            for (int idx = 0; idx < keyword.length; idx++) {
                shifts[idx] = keyword[idx] - 'A';
            }

            StringBuilder cipherText = new StringBuilder();

            for (int idx = 0; idx < plainText.length; idx++) {
                int shiftIdx = idx % keyword.length;

                char a = (char) ((plainText[idx] - 'A' + shifts[shiftIdx]) % 26 + 'A');
                cipherText.append(a);
            }
            sb.append("Ciphertext: ").append(cipherText.toString()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
