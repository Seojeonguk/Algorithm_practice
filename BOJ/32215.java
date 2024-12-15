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
            int numComputers = Integer.parseInt(st.nextToken());
            int numEditorsPerComputer = Integer.parseInt(st.nextToken());
            int numCompletedComputers = Integer.parseInt(st.nextToken());

            sb.append((numCompletedComputers + 1) * numEditorsPerComputer);

            bw.write(sb.toString());
        }
    }
}
