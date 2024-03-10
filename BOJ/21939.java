import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static final int MAX_PROBLEM_NUM = 100000;
    static final String ADD = "add";
    static final String SOLVED = "solved";
    static final String RECOMMEND = "recommend";

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] latestProblemDifficulties = new int[MAX_PROBLEM_NUM + 1];

        int currentProblemCnt = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> hardestProblems = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Integer.compare(o2[0], o1[0]);
            }
            return Integer.compare(o2[1], o1[1]);
        });
        PriorityQueue<int[]> easiestProblems = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o1[1], o2[1]);
        });

        for (int problem = 0; problem < currentProblemCnt; problem++) {
            StringTokenizer problemInfo = new StringTokenizer(br.readLine());
            int problemNum = Integer.parseInt(problemInfo.nextToken());
            int problemDifficulty = Integer.parseInt(problemInfo.nextToken());

            hardestProblems.add(new int[]{problemNum, problemDifficulty});
            easiestProblems.add(new int[]{problemNum, problemDifficulty});
            latestProblemDifficulties[problemNum] = problemDifficulty;
        }

        int queryCnt = Integer.parseInt(br.readLine());
        for (int queryNum = 0; queryNum < queryCnt; queryNum++) {
            StringTokenizer queryInfo = new StringTokenizer(br.readLine());
            String command = queryInfo.nextToken();
            if (RECOMMEND.equals(command)) {
                int direction = Integer.parseInt(queryInfo.nextToken());

                int recommendProblem = GetRecommendProblem(direction == 1 ? hardestProblems : easiestProblems, latestProblemDifficulties);
                sb.append(recommendProblem).append("\n");
            } else if (ADD.equals(command)) {
                int problemNum = Integer.parseInt(queryInfo.nextToken());
                int problemDifficulty = Integer.parseInt(queryInfo.nextToken());

                hardestProblems.add(new int[]{problemNum, problemDifficulty});
                easiestProblems.add(new int[]{problemNum, problemDifficulty});
                latestProblemDifficulties[problemNum] = problemDifficulty;
            } else if (SOLVED.equals(command)) {
                int problemNum = Integer.parseInt(queryInfo.nextToken());

                latestProblemDifficulties[problemNum] = 0;
            }
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int GetRecommendProblem(PriorityQueue<int[]> pq, int[] latestProblemDifficulties) {
        int recommendProblem = -1;
        while (!pq.isEmpty()) {
            int problemNum = pq.peek()[0];
            int problemDifficulty = pq.peek()[1];

            if (latestProblemDifficulties[problemNum] != problemDifficulty) {
                pq.poll();
                continue;
            }

            recommendProblem = problemNum;
            break;
        }

        return recommendProblem;
    }
}
