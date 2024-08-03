import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            char[] factoryStatus = br.readLine().toCharArray();

            sb.append(minMovesToGoal(factoryStatus));

            bw.write(sb.toString());
        }
    }

    public static int minMovesToGoal(char[] factoryStatus) {
        int robotIdx = -1;
        int boxIdx = -1;
        int goalIdx = -1;

        for (int idx = 0; idx < factoryStatus.length; idx++) {
            char status = factoryStatus[idx];
            if (status == '@') {
                robotIdx = idx;
            } else if (status == '#') {
                boxIdx = idx;
            } else if (status == '!') {
                goalIdx = idx;
            }
        }

        if (boxIdx < robotIdx && boxIdx < goalIdx) {
            return -1;
        }

        if (boxIdx > robotIdx && boxIdx > goalIdx) {
            return -1;
        }

        return Math.abs(robotIdx - goalIdx) - 1;
    }
}
