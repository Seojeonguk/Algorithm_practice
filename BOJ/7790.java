import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            String line = "";
            int appearedJoke = 0;
            while ((line = br.readLine()) != null) {
                char[] tmp = line.toCharArray();
                for (int i = 0; i < tmp.length - 3; i++) {
                    if (tmp[i] == 'j' && tmp[i + 1] == 'o' && tmp[i + 2] == 'k' && tmp[i + 3] == 'e') {
                        appearedJoke++;
                    }
                }
            }

            sb.append(appearedJoke);

            bw.write(sb.toString());
        }
    }
}
