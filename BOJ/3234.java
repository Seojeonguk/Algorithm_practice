import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int lukaX = Integer.parseInt(st.nextToken());
        int lukaY = Integer.parseInt(st.nextToken());

        int moveCnt = Integer.parseInt(br.readLine());
        char[] moveDirs = br.readLine().toCharArray();

        int taskMakersX = 0, taskMakersY = 0;

        if (Math.abs(taskMakersX - lukaX) <= 1 && Math.abs(taskMakersY - lukaY) <= 1) {
            sb.append(0).append("\n");
        }

        for (int i = 0; i < moveCnt; i++) {
            int dir = getDir(moveDirs[i]);
            taskMakersX += DIRECTIONS[dir][0];
            taskMakersY += DIRECTIONS[dir][1];

            if (Math.abs(taskMakersX - lukaX) <= 1 && Math.abs(taskMakersY - lukaY) <= 1) {
                sb.append(i + 1).append("\n");
            }
        }

        if (sb.length() == 0) {
            sb.append(-1);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getDir(char c) {
        int dir = -1;
        if (c == 'I') {
            dir = 0;
        } else if (c == 'S') {
            dir = 1;
        } else if (c == 'Z') {
            dir = 2;
        } else if (c == 'J') {
            dir = 3;
        }
        return dir;
    }
}
