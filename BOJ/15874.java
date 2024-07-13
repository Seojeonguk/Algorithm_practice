import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int shiftSize = Integer.parseInt(st.nextToken()) % 26;
            int strLength = Integer.parseInt(st.nextToken());

            char[] str = br.readLine().toCharArray();
            for (char c : str) {
                sb.append(shift(c, shiftSize));
            }

            bw.write(sb.toString());
        }
    }

    public static char shift(char c, int shiftSize) {
        if (!Character.isAlphabetic(c)) {
            return c;
        }

        char firstChar = (Character.isUpperCase(c) ? 'A' : 'a');
        return (char) ((c - firstChar + shiftSize) % 26 + firstChar);
    }
}
