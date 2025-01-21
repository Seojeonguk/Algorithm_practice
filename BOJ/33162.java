import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int commandCnt = Integer.parseInt(br.readLine());

            sb.append((commandCnt / 2) + (commandCnt % 2 == 1 ? 3 : 0));

            bw.write(sb.toString());
        }
    }
}
