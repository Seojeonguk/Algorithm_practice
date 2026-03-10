import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
        int measureCnt = Integer.parseInt(br.readLine());

        double sumTemperature = 0;
        double[] temperatures = new double[measureCnt];
        for (int i = 0; i < measureCnt; i++) {
            temperatures[i] = Double.parseDouble(br.readLine());
            sumTemperature += temperatures[i];
        }

        double avgTemperature = sumTemperature / temperatures.length;
        int errorCnt = 0;
        for (int i = 0; i < measureCnt; i++) {
            if (Math.abs(avgTemperature - temperatures[i]) >= 10.0) {
                errorCnt++;
            }
        }

        sb.append(errorCnt);

        bw.write(sb.toString());
        bw.flush();
    }
}
