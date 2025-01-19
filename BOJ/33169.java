import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int thousand = Integer.parseInt(br.readLine());
            int tenThousand = Integer.parseInt(br.readLine());

            sb.append(thousand * 1000 + tenThousand * 10000);

            bw.write(sb.toString());
        }
    }
}
