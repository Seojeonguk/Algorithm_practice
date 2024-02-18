import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static final int[] SOLVED_PROBLEM_COUNTS = {-1, 12, 11, 11, 10, 9, 9, 9, 8, 7, 6, 6};
    static final int[] PROBLEM_PENALTY_SUMS = {-1, 1600, 894, 1327, 1311, 1004, 1178, 1357, 837, 1055, 556, 773};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());

        sb.append(SOLVED_PROBLEM_COUNTS[n]).append(" ").append(PROBLEM_PENALTY_SUMS[n]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
