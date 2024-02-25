import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final int[][] DIRS = {{10, 0}, {0, -10}, {-10, 0}, {0, 10}};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String command = "";
        while ((command = br.readLine()) != null) {
            int x = 300, y = 420, dir = 0;

            sb.append(x).append(" ").append(y).append(" moveto\n");

            x += DIRS[dir][0];
            y += DIRS[dir][1];
            sb.append(String.format("%d %d lineto\n", x, y));

            for (int idx = 0; idx < command.length(); idx++) {
                char c = command.charAt(idx);
                dir = (dir + (c == 'A' ? 1 : 3)) % 4;
                x += DIRS[dir][0];
                y += DIRS[dir][1];

                sb.append(String.format("%d %d lineto\n", x, y));
            }
            sb.append("stroke").append("\n").append("showpage").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
