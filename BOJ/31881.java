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
            int totalComputer = Integer.parseInt(st.nextToken());
            int queryCnt = Integer.parseInt(st.nextToken());

            boolean[] isVirus = new boolean[totalComputer + 1];
            int virusComputerCnt = 0;
            for (int queryNum = 0; queryNum < queryCnt; queryNum++) {
                StringTokenizer queries = new StringTokenizer(br.readLine());
                int command = Integer.parseInt(queries.nextToken());
                if (command == 1) {
                    int virusComputerNum = Integer.parseInt(queries.nextToken());
                    if (!isVirus[virusComputerNum]) {
                        virusComputerCnt++;
                    }
                    isVirus[virusComputerNum] = true;
                } else if (command == 2) {
                    int virusComputerNum = Integer.parseInt(queries.nextToken());
                    if (isVirus[virusComputerNum]) {
                        virusComputerCnt--;
                    }
                    isVirus[virusComputerNum] = false;
                } else if (command == 3) {
                    sb.append(totalComputer - virusComputerCnt).append("\n");
                }
            }

            bw.write(sb.toString());
        }
    }
}
