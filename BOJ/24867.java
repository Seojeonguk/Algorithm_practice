import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int MACHINE_CNT = 2;

    public static void main(String[] args) throws Exception {
        long workTime = Long.parseLong(br.readLine());

        Machine[] machines = new Machine[MACHINE_CNT];
        for (int i = 0; i < MACHINE_CNT; i++) {
            machines[i] = new Machine(br.readLine());
        }

        long firstMachineTime = calTotalProduction(machines, 0, workTime);
        long secondMachineTime = calTotalProduction(machines, 1, workTime);

        sb.append(Math.max(firstMachineTime, secondMachineTime));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static long calTotalProduction(Machine[] machines, int firstStartMachineNum, long workTime) {
        long production = 0;

        long firstMachineRunningTime = workTime - machines[firstStartMachineNum].turnOnTime;
        if (firstMachineRunningTime > 0) {
            production += firstMachineRunningTime * machines[firstStartMachineNum].productionPerMinute;
        }

        long secondMachineRunningTime = workTime - machines[firstStartMachineNum].turnOnTime - machines[1 - firstStartMachineNum].turnOnTime;
        if (secondMachineRunningTime > 0) {
            production += secondMachineRunningTime * machines[1 - firstStartMachineNum].productionPerMinute;
        }

        return production;
    }

    static class Machine {
        long turnOnTime;
        long productionPerMinute;

        Machine(String str) {
            String[] strSplit = str.split(" ");
            this.turnOnTime = Long.parseLong(strSplit[0]);
            this.productionPerMinute = Long.parseLong(strSplit[1]);
        }
    }
}
