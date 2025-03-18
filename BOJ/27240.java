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
            int totalStation = Integer.parseInt(st.nextToken());
            int region = Integer.parseInt(st.nextToken());
            int city = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int startStation = Integer.parseInt(st.nextToken());
            int endStation = Integer.parseInt(st.nextToken());

            if (startStation > endStation) {
                int temp = startStation;
                startStation = endStation;
                endStation = temp;
            }

            if (region < startStation && startStation < city && region < endStation && endStation < city) {
                sb.append("City");
            } else if (endStation <= region || startStation >= city) {
                sb.append("Outside");
            } else {
                sb.append("Full");
            }

            bw.write(sb.toString());
        }
    }
}
