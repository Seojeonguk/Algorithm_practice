import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int arrSize = Integer.parseInt(br.readLine());
            long x = Long.parseLong(br.readLine().replaceAll(" ", ""));
            long y = Long.parseLong(br.readLine().replaceAll(" ", ""));

            sb.append(Math.min(x, y));

            bw.write(sb.toString());
        }
    }
}
