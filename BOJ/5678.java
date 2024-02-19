import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int totalGameRound = Integer.parseInt(br.readLine());
            if (totalGameRound == 0) {
                break;
            }

            int[] monsterFreedByMark = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] monsterFreedByLeti = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int markScore = Arrays.stream(monsterFreedByMark).sum();
            int letiScore = Arrays.stream(monsterFreedByLeti).sum();

            for (int i = 2; i < totalGameRound; i++) {
                boolean isAppearedReleasedThreeTimesByMark = (monsterFreedByMark[i - 2] == monsterFreedByMark[i - 1] && monsterFreedByMark[i - 1] == monsterFreedByMark[i]);
                boolean isAppearedReleasedThreeTimesByLeti = (monsterFreedByLeti[i - 2] == monsterFreedByLeti[i - 1] && monsterFreedByLeti[i - 1] == monsterFreedByLeti[i]);

                if (isAppearedReleasedThreeTimesByMark || isAppearedReleasedThreeTimesByLeti) {
                    if (isAppearedReleasedThreeTimesByMark && !isAppearedReleasedThreeTimesByLeti) {
                        markScore += 30;
                    } else if (!isAppearedReleasedThreeTimesByMark && isAppearedReleasedThreeTimesByLeti) {
                        letiScore += 30;
                    }
                    break;
                }
            }

            if (markScore > letiScore) {
                sb.append("M\n");
            } else if (markScore < letiScore) {
                sb.append("L\n");
            } else {
                sb.append("T\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
