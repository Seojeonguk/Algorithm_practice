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
            int cansOfChips = Integer.parseInt(st.nextToken());
            int chipsInEachCan = Integer.parseInt(st.nextToken());

            sb.append(chipsInEachCan + 1).append(" ").append(cansOfChips * chipsInEachCan + 1);

            bw.write(sb.toString());
        }
    }
}
