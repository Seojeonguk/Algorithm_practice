import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final double PI = 3.14159265358979323d;

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());

            int candyCnt = Integer.parseInt(st.nextToken());
            int boxCnt = Integer.parseInt(st.nextToken());

            Box[] boxes = new Box[boxCnt];
            for (int i = 0; i < boxCnt; i++) {
                st = new StringTokenizer(br.readLine());
                int height = Integer.parseInt(st.nextToken());
                int width = Integer.parseInt(st.nextToken());

                boxes[i] = new Box(height, width);
            }

            Arrays.sort(boxes, Comparator.comparingInt(Box::getArea).reversed());
            for (int i = 0; i < boxCnt; i++) {
                candyCnt -= boxes[i].getArea();
                if (candyCnt <= 0) {
                    sb.append(i + 1).append("\n");
                    break;
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Box {
        int height, width;

        Box(int height, int width) {
            this.height = height;
            this.width = width;
        }

        public int getArea() {
            return height * width;
        }
    }
}
