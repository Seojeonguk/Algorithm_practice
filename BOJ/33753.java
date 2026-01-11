import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int defaultCost = Integer.parseInt(st.nextToken());
        int minutes = Integer.parseInt(st.nextToken());
        int additionalCost = Integer.parseInt(st.nextToken());

        int parkingTime = Integer.parseInt(br.readLine());

        int parkingCost = defaultCost;
        if (30 < parkingTime) {
            parkingCost += ((parkingTime - 30 + minutes - 1) / minutes) * additionalCost;
        }

        sb.append(parkingCost);

        bw.write(sb.toString());
        bw.flush();
    }
}
