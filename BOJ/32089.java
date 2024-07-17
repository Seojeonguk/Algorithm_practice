import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            while (true) {
                int reportDays = Integer.parseInt(br.readLine());
                if (reportDays == 0) {
                    break;
                }

                int[] newMembers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                long maxMembers = calMaxMembers(newMembers);

                sb.append(maxMembers).append("\n");
            }

            bw.write(sb.toString());
        }
    }

    public static long calMaxMembers(int[] members) {
        long maxMembers = 0;
        for (int i = 0; i < members.length; i++) {
            long clubMembers = 0;
            for (int j = i, count = 0; j >= 0 && count < 3; j--, count++) {
                clubMembers += members[j];
            }

            maxMembers = Math.max(maxMembers, clubMembers);
        }

        return maxMembers;
    }
}
