import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int participantCnt = Integer.parseInt(br.readLine());
        int GahuiSupport = Integer.parseInt(br.readLine());
        List<Integer> votes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        votes.add(GahuiSupport);

        Collections.sort(votes, Comparator.reverseOrder());

        int rank = votes.indexOf(GahuiSupport) + 1;
        sb.append(rank);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
