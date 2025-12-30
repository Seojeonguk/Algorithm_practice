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

        private int measureCnt;
        private double bpm;
        private int shiftingCnt;

        private double playTime;
        private int lastMeasure;

        private int[] shiftingMeasures;
        private double[] shiftingBpms;

        public Problem() {
            playTime = 0;
            lastMeasure = 1;
        }

        public void init() throws IOException {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                measureCnt = Integer.parseInt(st.nextToken());
                bpm = Double.parseDouble(st.nextToken());
                shiftingCnt = Integer.parseInt(st.nextToken());

                shiftingMeasures = new int[shiftingCnt];
                shiftingBpms = new double[shiftingCnt];

                for (int i = 0; i < shiftingCnt; i++) {
                    StringTokenizer shiftingToken = new StringTokenizer(br.readLine());
                    shiftingMeasures[i] = Integer.parseInt(shiftingToken.nextToken());
                    shiftingBpms[i] = Double.parseDouble(shiftingToken.nextToken());
                }
            }
        }

        public void solve() {
            for (int i = 0; i < shiftingCnt; i++) {
                int currentMeasure = shiftingMeasures[i] - lastMeasure;

                playTime += 60.0 / bpm * currentMeasure * 4;

                lastMeasure = shiftingMeasures[i];
                bpm = shiftingBpms[i];
            }

            int currentMeasure = measureCnt - lastMeasure + 1;
            playTime += 60.0 / bpm * currentMeasure * 4;
        }

        public void printAns() throws IOException {
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
                bw.write(String.format("%.12f", playTime));
                bw.flush();
            }
        }
    }
}


