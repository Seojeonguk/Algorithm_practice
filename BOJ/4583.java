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
            char[] word = br.readLine().toCharArray();
            if (word[0] == '#') {
                break;
            }

            String reveredWord = reverse(word);
            sb.append(reveredWord).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static String reverse(char[] word) {
        StringBuilder sb = new StringBuilder();
        for (int i = word.length - 1; i >= 0; i--) {
            if (!canReverse(word[i])) {
                return "INVALID";
            }
            if (word[i] == 'b') {
                sb.append('d');
            } else if (word[i] == 'd') {
                sb.append('b');
            } else if (word[i] == 'p') {
                sb.append('q');
            } else if (word[i] == 'q') {
                sb.append('p');
            } else {
                sb.append(word[i]);
            }
        }

        return sb.toString();
    }

    public static boolean canReverse(char c) {
        return (c == 'b' || c == 'd' || c == 'p' || c == 'q' || c == 'i' || c == 'o' || c == 'v' || c == 'w' || c == 'x');
    }
}
