import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int staffCnt = Integer.parseInt(br.readLine());
            int requiredSushi = 0;
            for (int i = 0; i < staffCnt; i++) {
                String wantedSushi = br.readLine();
                requiredSushi += wantedSushi.length();
            }

            sb.append(requiredSushi);

            bw.write(sb.toString());
        }
    }
}
