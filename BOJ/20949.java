import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        Problem problem = new Problem();
        problem.init();
        problem.solve();
        problem.printAns();
    }

    public static class Problem {

        private int monitorCnt;
        private Monitor[] monitors;

        public void init() throws IOException {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                monitorCnt = Integer.parseInt(br.readLine());
                monitors = new Monitor[monitorCnt];

                for (int i = 0; i < monitorCnt; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    int width = Integer.parseInt(st.nextToken());
                    int height = Integer.parseInt(st.nextToken());

                    monitors[i] = new Monitor(i + 1, width, height);
                }
            }
        }

        public void solve() {
            Arrays.sort(monitors, (o1, o2) -> {
                int o1PPI = o1.calPPI();
                int o2PPI = o2.calPPI();
                if (o1PPI == o2PPI) {
                    return Integer.compare(o1.no, o2.no);
                }
                return Integer.compare(o2PPI, o1PPI);
            });
        }

        public void printAns() throws IOException {
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < monitorCnt; i++) {
                    sb.append(monitors[i].no).append("\n");
                }
                bw.write(sb.toString());
                bw.flush();
            }
        }
    }

    public static class Monitor {
        private int no;
        private int width;
        private int height;

        public Monitor(int no, int width, int height) {
            this.no = no;
            this.width = width;
            this.height = height;
        }

        public int calPPI() {
            return pow(width) + pow(height);
        }

        public int pow(int x) {
            return x * x;
        }
    }
}


