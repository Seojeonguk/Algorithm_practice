import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final int NOT_FOUND_RESULT = -1;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int alphabetOnWheelCnt = Integer.parseInt(br.readLine());
            char[] alphabetsOnWheel = br.readLine().toCharArray();

            int makeWordLength = Integer.parseInt(br.readLine());
            char[] makeWords = br.readLine().toCharArray();

            sb.append(calMinRequiredRotation(alphabetsOnWheel, makeWords));

            bw.write(sb.toString());
        }
    }

    public static int calMinRequiredRotation(char[] alphabets, char[] makeWords) {
        int minRequiredRotation = 0;

        int idx = alphabets.length - 1;
        for (int i = 0; i < makeWords.length; i++) {
            boolean isFound = false;
            
            for (int j = 1; j <= alphabets.length; j++) {
                int next = (idx + j) % alphabets.length;

                if (alphabets[next] == makeWords[i]) {
                    minRequiredRotation += j;
                    idx = next;
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                return NOT_FOUND_RESULT;
            }
        }

        return minRequiredRotation;
    }
}
