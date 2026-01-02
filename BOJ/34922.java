import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        Problem problem = new Problem();
        problem.init();
        problem.solve();
        problem.printAns();
    }

    public static class Problem {

        private final double PI = 3.14159;

        private int classWidth;
        private int classHeight;
        private int sight;
        private double invisibleArea;

        public void init() throws IOException {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                classWidth = Integer.parseInt(st.nextToken());
                classHeight = Integer.parseInt(st.nextToken());
                sight = Integer.parseInt(br.readLine());
            }
        }

        public void solve() {
            int classArea = classWidth * classHeight;
            double visibleArea = PI * sight * sight / 4.0;

            invisibleArea = classArea - visibleArea;
        }

        public void printAns() throws IOException {
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
                bw.write(String.format("%.3f", invisibleArea));
                bw.flush();
            }
        }
    }
}


