import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int totalPerson = Integer.parseInt(br.readLine());
        char[][] interestedEvents = new char[totalPerson][5];
        for (int i = 0; i < totalPerson; i++) {
            interestedEvents[i] = br.readLine().toCharArray();
        }

        int[] days = new int[5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < totalPerson; j++) {
                if (interestedEvents[j][i] == 'Y') {
                    days[i]++;
                }
            }
        }

        ArrayList<Integer> possibleDays = new ArrayList<>();
        int max = Arrays.stream(days).max().getAsInt();
        for (int i = 0; i < 5; i++) {
            if (days[i] == max) {
                possibleDays.add(i + 1);
            }
        }

        for (int i = 0; i < possibleDays.size(); i++) {
            sb.append(possibleDays.get(i));
            if (i != possibleDays.size() - 1) {
                sb.append(",");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
