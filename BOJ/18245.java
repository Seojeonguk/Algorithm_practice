import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            for (int added = 2; ; added++) {
                String sentence = br.readLine();
                if ("Was it a cat I saw?".equals(sentence)) {
                    break;
                }

                char[] sentenceChars = sentence.toCharArray();
                for (int idx = 0; idx < sentenceChars.length; idx += added) {
                    sb.append(sentenceChars[idx]);
                }
                sb.append("\n");
            }

            bw.write(sb.toString());
        }
    }
}
