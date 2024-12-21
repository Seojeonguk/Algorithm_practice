import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    final static String[] SOLVED_PROBLEM_CODE = {
            "ABCDEFGHJLM",
            "ACEFGHILM",
            "ACEFGHILM",
            "ABCEFGHLM",
            "ACEFGHLM",
            "ACEFGHLM",
            "ACEFGHLM",
            "ACEFGHLM",
            "ACEFGHLM",
            "ABCFGHLM",
    };

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int rank = Integer.parseInt(br.readLine());

            sb.append(SOLVED_PROBLEM_CODE[rank - 1].length()).append("\n");

            for (char c : SOLVED_PROBLEM_CODE[rank - 1].toCharArray()) {
                sb.append(c).append(" ");
            }

            bw.write(sb.toString());
        }
    }
}
