import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int railTime = Integer.parseInt(br.readLine());
            int flightTime = Integer.parseInt(br.readLine());

            if (railTime <= flightTime) {
                sb.append("high speed rail");
            } else {
                sb.append("flight");
            }

            bw.write(sb.toString());
        }
    }
}
