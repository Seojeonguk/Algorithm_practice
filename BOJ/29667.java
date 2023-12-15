import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String firstGame = br.readLine();
        int firstASchoolGoal = firstGame.charAt(0) - '0';
        int firstBSchoolGoal = firstGame.charAt(2) - '0';

        String secondGame = br.readLine();
        int secondASchoolGoal = secondGame.charAt(2) - '0';
        int secondBSchoolGoal = secondGame.charAt(0) - '0';

        sb.append(firstASchoolGoal >= secondBSchoolGoal && firstBSchoolGoal >= secondASchoolGoal ? "YES" : "NO");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
