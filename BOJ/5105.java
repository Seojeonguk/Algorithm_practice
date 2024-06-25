import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    static final int TOTAL_HOUSE = 20;
    static final String ILLEGAL = "illegal";
    static final String NONE = "none";

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            boolean[] visited = new boolean[TOTAL_HOUSE + 1];

            while (true) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String firstHouse = st.nextToken();
                if ("#".equals(firstHouse)) {
                    break;
                }

                if (isLegal(firstHouse, st, visited)) {
                    int notVisitedCnt = 0;
                    for (int i = 1; i <= TOTAL_HOUSE; i++) {
                        if (!visited[i]) {
                            sb.append(i).append(" ");
                            notVisitedCnt++;
                        }
                    }

                    if (notVisitedCnt == 0) {
                        sb.append(NONE);
                    }
                } else {
                    sb.append(ILLEGAL);
                }

                sb.append("\n");
            }

            bw.write(sb.toString());
        }
    }

    public static boolean isLegal(String firstHouse, StringTokenizer st, boolean[] visited) {
        Arrays.fill(visited, false);

        int visitedHouse = Integer.parseInt(firstHouse);
        visited[visitedHouse] = true;

        while (st.hasMoreElements()) {
            visitedHouse += move(st.nextToken());
            if (isOut(visitedHouse) || visited[visitedHouse]) {
                return false;
            }

            visited[visitedHouse] = true;
        }

        return true;
    }

    public static int move(String task) {
        char dir = task.charAt(0);
        int size = Integer.parseInt(task.substring(1));

        return (dir == 'U' ? size : -size);
    }

    public static boolean isOut(int x) {
        return (x < 1 || x > TOTAL_HOUSE);
    }
}
