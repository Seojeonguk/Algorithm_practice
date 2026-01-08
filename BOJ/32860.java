import java.io.*;
import java.util.StringTokenizer;

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

        private final String HEADER_STR = "SN";

        private int year;
        private int foundOrder;

        private String name;

        public void init() throws IOException {
            StringTokenizer st = new StringTokenizer(br.readLine());
            year = Integer.parseInt(st.nextToken());
            foundOrder = Integer.parseInt(st.nextToken());
        }

        public void solve() throws IOException {
            StringBuilder sb = new StringBuilder();
            sb.append(HEADER_STR).append(" ").append(year);

            if (26 < foundOrder) {
                sb.append(convertNumToChar((foundOrder - 1) / 26)).append(convertNumToChar(foundOrder));
            } else {
                sb.append(String.valueOf(convertNumToChar(foundOrder)).toUpperCase());
            }

            name = sb.toString();
        }

        public char convertNumToChar(int num) {
            return (char) ('a' + ((num - 1) % 26));
        }

        public void printAns() throws IOException {
            bw.write(name);
            bw.flush();
        }
    }
}
