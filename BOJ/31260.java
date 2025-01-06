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
            long meter = Long.parseLong(st.nextToken());
            long centimeter = Long.parseLong(st.nextToken());

            long diffCentimeter = Long.parseLong(br.readLine());

            long totalCentimeter = meter * 100 + centimeter;

            long shorterCentimeter = (totalCentimeter - diffCentimeter * 2L) / 4;
            long longerCentimeter = shorterCentimeter + diffCentimeter;

            sb.append(longerCentimeter / 100).append(" ").append(longerCentimeter % 100).append("\n")
                    .append(shorterCentimeter / 100).append(" ").append(shorterCentimeter % 100);

            bw.write(sb.toString());
        }
    }
}
