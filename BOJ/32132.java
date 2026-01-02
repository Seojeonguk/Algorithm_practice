import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Problem problem = new Problem();
        problem.init();
        problem.solve();
        problem.printAns();
    }

    public static class Problem {

        private int boardLength;
        private String boardContent;

        public void init() throws IOException {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                boardLength = Integer.parseInt(br.readLine());
                boardContent = br.readLine();
            }
        }

        public void solve() {
            while (true) {
                if (boardContent.contains("PS4")) {
                    boardContent = boardContent.replace("PS4", "PS");
                    continue;
                }

                if (boardContent.contains("PS5")) {
                    boardContent = boardContent.replace("PS5", "PS");
                    continue;
                }

                break;
            }
        }

        public void printAns() throws IOException {
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
                bw.write(boardContent);
                bw.flush();
            }
        }
    }
}
