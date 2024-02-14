import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= testCase; tc++) {
            StringTokenizer hospitalInfo = new StringTokenizer(br.readLine());
            int patientCnt = Integer.parseInt(hospitalInfo.nextToken());
            int consideringMachineCnt = Integer.parseInt(hospitalInfo.nextToken());
            
            int[][] machines = new int[consideringMachineCnt + 1][4];
            for (int machineNum = 1; machineNum <= consideringMachineCnt; machineNum++) {
                StringTokenizer machineInfo = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    machines[machineNum][j] = Integer.parseInt(machineInfo.nextToken());
                }
            }

            int[] neededMachineCounts = new int[consideringMachineCnt + 1];
            for (int patientNum = 1; patientNum <= patientCnt; patientNum++) {
                int neededMachineNum = Integer.parseInt(br.readLine());
                neededMachineCounts[neededMachineNum]++;
            }

            sb.append("Data Set ").append(tc).append(":\n");
            for (int machineNum = 1; machineNum <= consideringMachineCnt; machineNum++) {
                int usePatientCnt = Math.min(neededMachineCounts[machineNum], machines[machineNum][2]);

                int totalExpenditure = machines[machineNum][0] + machines[machineNum][1] * usePatientCnt;
                int totalRevenue = machines[machineNum][3] * usePatientCnt;

                if (totalRevenue > totalExpenditure) {
                    sb.append(machineNum).append("\n");
                }
            }

            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
