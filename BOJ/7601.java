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

            for (int scenarioNum = 1; ; scenarioNum++) {
                StringTokenizer scenarioToken = new StringTokenizer(br.readLine());
                int outfit = Integer.parseInt(scenarioToken.nextToken());
                int days = Integer.parseInt(scenarioToken.nextToken());
                if (outfit == 0 && days == 0) {
                    break;
                }

                sb.append("Scenario").append(" ").append(scenarioNum).append("\n");

                int removedLeftOutfit = Integer.parseInt(br.readLine());
                int removedRightOutfit = Integer.parseInt(br.readLine());

                for (int day = 1; day <= days; day++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    int left = Integer.parseInt(st.nextToken());
                    int right = Integer.parseInt(st.nextToken());

                    int leftSelectedNum = left;
                    if (removedLeftOutfit > 0 && removedLeftOutfit <= left) {
                        leftSelectedNum++;
                    }

                    int rightSelectedNum = outfit + 1 - right;
                    if (removedRightOutfit > 0 && removedRightOutfit <= right) {
                        rightSelectedNum--;
                    }

                    sb.append("Day").append(" ").append(day).append(" ").append(leftSelectedNum == rightSelectedNum ? "ALERT" : "OK").append("\n");
                }
            }

            bw.write(sb.toString());
        }
    }
}
