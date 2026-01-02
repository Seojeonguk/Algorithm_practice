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

        private int maxNum;
        private char result;

        public void init() throws IOException {
            maxNum = Integer.parseInt(br.readLine());
        }

        public void solve() throws IOException {
            while(true) {
                bw.write("? 1\n");
                bw.flush();

                result = br.readLine().charAt(0);
                if (result == 'Y') {
                    break;
                }
            }
        }

        public void printAns() throws IOException {
            bw.write("! 1\n");
            bw.flush();
        }
    }
}
