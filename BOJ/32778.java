import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            String stationInfo = br.readLine();

            int openIdx = stationInfo.indexOf('(');
            int closeIdx = stationInfo.indexOf(')');

            if (openIdx == -1 && closeIdx == -1) {
                sb.append(stationInfo).append("\n-");
            } else {
                sb.append(stationInfo, 0, openIdx - 1)
                        .append("\n")
                        .append(stationInfo, openIdx + 1, closeIdx);
            }

            bw.write(sb.toString());
        }
    }
}
