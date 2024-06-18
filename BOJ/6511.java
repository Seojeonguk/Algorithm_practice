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

            while (true) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());
                int rightBottom = Integer.parseInt(st.nextToken());

                if (row == 0 && col == 0) {
                    break;
                }

                int painting = (getRemain(row) * getRemain(col)) / 2;
                if (row % 2 == 0 && col % 2 == 0 && rightBottom == 1) {
                    painting++;
                }
                sb.append(painting).append("\n");
            }

            bw.write(sb.toString());
        }
    }

    public static int getRemain(int x) {
        return x - 7;
    }

}
