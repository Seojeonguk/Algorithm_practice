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

            int ampere = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int watt = Integer.parseInt(st.nextToken());
            int volt = Integer.parseInt(st.nextToken());

            sb.append(canWork(ampere, watt, volt));

            bw.write(sb.toString());
        }
    }

    public static int canWork(int ampere, int watt, int volt) {
        return (ampere * volt <= watt) ? 1 : 0;
    }
}
