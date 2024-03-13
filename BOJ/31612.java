import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int length = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();

        int totalStroke = 0;
        for (int idx = 0; idx < length; idx++) {
            totalStroke += (str[idx] == 'o' ? 1 : 2);
        }

        sb.append(totalStroke);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
