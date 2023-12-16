import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        String[] matrix = new String[8];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 8; j++) {
                matrix[j] = br.readLine();
            }

            if ("..#####..".equals(matrix[0])) {
                sb.append(0);
            } else if ("....##...".equals(matrix[0])) {
                sb.append(1);
            } else if (".#######.".equals(matrix[0])) {
                if ("########.".equals(matrix[3])) {
                    sb.append(6);
                } else if (".########".equals(matrix[3])) {
                    sb.append(9);
                } else {
                    if ("##.......".equals(matrix[4])) {
                        sb.append(2);
                    } else if (".......##".equals(matrix[4])) {
                        sb.append(3);
                    } else {
                        sb.append(8);
                    }
                }
            } else if ("##.......".equals(matrix[0])) {
                sb.append(4);
            } else if (".########".equals(matrix[0])) {
                if (".##......".equals(matrix[1])) {
                    sb.append(5);
                } else {
                    sb.append(7);
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
