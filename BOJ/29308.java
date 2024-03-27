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

        int soccerPlayerCnt = Integer.parseInt(br.readLine());
        int maxSalary = 0;
        String maxSalaryPlayerLastName = "";
        for (int playerNum = 1; playerNum <= soccerPlayerCnt; playerNum++) {
            StringTokenizer playerInfo = new StringTokenizer(br.readLine());
            int salary = Integer.parseInt(playerInfo.nextToken());
            String lastName = playerInfo.nextToken();
            String nation = playerInfo.nextToken();

            if (!"Russia".equals(nation)) {
                continue;
            }
            if (maxSalary < salary) {
                maxSalaryPlayerLastName = lastName;
                maxSalary = salary;
            }
        }

        sb.append(maxSalaryPlayerLastName);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
