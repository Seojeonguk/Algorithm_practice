import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static final boolean[] CAN_HIGHER_RANK = {false, false, true, false, false, false, true, true, true, false, false};
    static final String CAN_HIGHER_TEAM = "Think before submission";
    static final String CANNOT_HIGHER_TEAM = "Solve harder problems";

    public static void main(String[] args) throws Exception {
        int searchingRank = Integer.parseInt(br.readLine());

        sb.append(CAN_HIGHER_RANK[searchingRank] ? CAN_HIGHER_TEAM : CANNOT_HIGHER_TEAM);

        bw.write(sb.toString());
        bw.flush();
    }
}
