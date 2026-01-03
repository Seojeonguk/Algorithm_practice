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

        public void init() throws IOException {
        }

        public void solve() throws IOException {
        }

        public void printAns() throws IOException {
            bw.write(String.valueOf(42));
            bw.flush();
        }
    }
}
