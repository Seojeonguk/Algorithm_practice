import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int CHARGING_BATTERY_USAGE = 100;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int connectedAirPodCnt = Integer.parseInt(br.readLine());
            int[] connectedPhoneNums = new int[connectedAirPodCnt];

            StringTokenizer connectedPhoneTokens = new StringTokenizer(br.readLine());
            for (int i = 0; i < connectedAirPodCnt; i++) {
                connectedPhoneNums[i] = Integer.parseInt(connectedPhoneTokens.nextToken());
            }

            sb.append(getCurrentBatteryConsumption(connectedPhoneNums));

            bw.write(sb.toString());
        }
    }

    public static int getCurrentBatteryConsumption(int[] connectedPhoneNums) {
        int currentBatteryConsumption = 0;

        int batteryConsumption = 0;
        for (int i = 0; i < connectedPhoneNums.length; i++) {
            if (i > 0 && connectedPhoneNums[i - 1] == connectedPhoneNums[i] && batteryConsumption > 0) {
                batteryConsumption *= 2;
            } else {
                batteryConsumption = 2;
            }

            currentBatteryConsumption += batteryConsumption;
            if (currentBatteryConsumption >= CHARGING_BATTERY_USAGE) {
                batteryConsumption = 0;
                currentBatteryConsumption = 0;
            }
        }

        return currentBatteryConsumption;
    }
}
