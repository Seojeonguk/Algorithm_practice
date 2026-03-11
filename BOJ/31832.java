import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            char[] teamName = br.readLine().toCharArray();

            if (teamName.length > 10) {
                continue;
            }

            int upperCnt = 0;
            int lowerCnt = 0;
            int numberCnt = 0;
            for (char c : teamName) {
                if (Character.isAlphabetic(c)) {
                    if ((Character.isUpperCase(c))) {
                        upperCnt++;
                    } else {
                        lowerCnt++;
                    }
                } else if (Character.isDigit(c)) {
                    numberCnt++;
                }
            }

            if (numberCnt == teamName.length) {
                continue;
            }

            if (upperCnt > lowerCnt) {
                continue;
            }

            sb.append(teamName);
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
