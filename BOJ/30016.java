import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int subjectCnt = Integer.parseInt(st.nextToken());
        int maxPossibleStudyTime = Integer.parseInt(st.nextToken());

        int[][] subjectScores = new int[subjectCnt + 1][maxPossibleStudyTime + 1];
        for (int subject = 1; subject <= subjectCnt; subject++) {
            st = new StringTokenizer(br.readLine());
            for (int time = 0; time <= maxPossibleStudyTime; time++) {
                subjectScores[subject][time] = Integer.parseInt(st.nextToken());
            }
        }
        int[] tiredScores = new int[maxPossibleStudyTime + 1];
        st = new StringTokenizer(br.readLine());
        for (int time = 0; time <= maxPossibleStudyTime; time++) {
            tiredScores[time] = Integer.parseInt(st.nextToken());
        }

        int[][] maxScores = new int[subjectCnt + 1][maxPossibleStudyTime + 1];
        int[][] subjectStudyTimes = new int[subjectCnt + 1][maxPossibleStudyTime + 1];
        for (int subject = 1; subject <= subjectCnt; subject++) {
            for (int totalTime = 0; totalTime <= maxPossibleStudyTime; totalTime++) {
                for (int subjectTime = 0; totalTime >= subjectTime; subjectTime++) {
                    int thisTime = maxScores[subject - 1][totalTime - subjectTime] + subjectScores[subject][subjectTime];
                    if (maxScores[subject][totalTime] < thisTime) {
                        maxScores[subject][totalTime] = thisTime;
                        subjectStudyTimes[subject][totalTime] = subjectTime;
                    }
                }
            }
        }

        int maxScore = Integer.MIN_VALUE;
        int totalStudyTime = 0;
        for (int i = 0; i <= maxPossibleStudyTime; i++) {
            int score = maxScores[subjectCnt][i] - tiredScores[i];
            if (maxScore < score) {
                maxScore = score;
                totalStudyTime = i;
            }
        }
        sb.append(maxScore).append("\n");

        Stack<Integer> studyTimes = new Stack<>();
        for (int subject = subjectCnt; subject > 0; subject--) {
            studyTimes.add(subjectStudyTimes[subject][totalStudyTime]);
            totalStudyTime -= subjectStudyTimes[subject][totalStudyTime];
        }

        while (!studyTimes.isEmpty()) {
            sb.append(studyTimes.pop()).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
