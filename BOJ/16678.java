import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int nationalAssemblyCnt = Integer.parseInt(br.readLine());
            int[] honors = new int[nationalAssemblyCnt + 1];
            for (int i = 1; i <= nationalAssemblyCnt; i++) {
                honors[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(honors);

            long hiredHackers = 0;
            int targetHonor = 0;
            for (int i = 1; i <= nationalAssemblyCnt; i++) {
                if (honors[i - 1] == honors[i]) {
                    continue;
                }

                targetHonor++;
                hiredHackers += honors[i] - targetHonor;
                honors[i] = targetHonor;
            }

            sb.append(hiredHackers);

            bw.write(sb.toString());
        }
    }
}
