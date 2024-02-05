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
            char[] encryptedKey = br.readLine().toCharArray();
            if (encryptedKey[0] == '0') {
                break;
            }
            char[] plainText = br.readLine().toCharArray();

            int[] shiftedDistance = calShiftedDistance(encryptedKey);
            int shiftedIndex = 0;
            for (int i = 0; i < plainText.length; i++) {
                char c = (char) ((plainText[i] - 'A' + shiftedDistance[shiftedIndex]) % 26 + 'A');
                sb.append(c);
                shiftedIndex = (shiftedIndex + 1) % encryptedKey.length;
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int[] calShiftedDistance(char[] key) {
        int[] shiftedDistance = new int[key.length];
        for (int i = 0; i < key.length; i++) {
            shiftedDistance[i] = key[i] - 'A' + 1;
        }
        return shiftedDistance;
    }
}
