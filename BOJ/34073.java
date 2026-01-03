import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        Problem problem = new Problem();
        problem.init();
        problem.solve();
        problem.printAns();
    }

    public static class Problem {

        private final String DORO_WORD = "DORO";

        private int wordCnt;
        private String sentence;

        private StringBuilder realSaying;

        public void init() throws IOException {
            realSaying = new StringBuilder();

            wordCnt = Integer.parseInt(br.readLine());
            sentence = br.readLine();
        }

        public void solve() throws IOException {
            String[] words = sentence.split(" ");

            for (String word : words) {
                realSaying.append(word).append(DORO_WORD).append(" ");
            }
        }

        public void printAns() throws IOException {
            bw.write(realSaying.toString());
            bw.flush();
        }
    }
}
