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

            int railTime = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int firstMovedTime = Integer.parseInt(st.nextToken());
            int flightTime = Integer.parseInt(st.nextToken());
            int secondMovedTime = Integer.parseInt(st.nextToken());

            if (railTime <= firstMovedTime + flightTime + secondMovedTime || railTime <= 240) {
                sb.append("high speed rail");
            } else {
                sb.append("flight");
            }

            bw.write(sb.toString());
        }
    }
}
