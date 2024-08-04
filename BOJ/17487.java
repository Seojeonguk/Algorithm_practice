import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static final String LEFT_CHARACTERS = "qwertyasdfgzxcvb";

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            char[] inputStrings = br.readLine().toCharArray();

            int leftInputCnt = 0, rightInputCnt = 0;
            for (char c : inputStrings) {
                if (!Character.isAlphabetic(c)) {
                    continue;
                }
                
                char lowerC = Character.toLowerCase(c);
                if (LEFT_CHARACTERS.contains(String.valueOf(lowerC))) {
                    leftInputCnt++;
                } else {
                    rightInputCnt++;
                }
            }

            for (char c : inputStrings) {
                if (c == ' ' || Character.isUpperCase(c)) {
                    if (leftInputCnt <= rightInputCnt) {
                        leftInputCnt++;
                    } else {
                        rightInputCnt++;
                    }
                }
            }

            sb.append(leftInputCnt).append(" ").append(rightInputCnt);

            bw.write(sb.toString());
        }
    }
}
