import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int sumHead = Integer.parseInt(st.nextToken());
        int sumLeg = Integer.parseInt(st.nextToken());

        int cow = (sumLeg - sumHead * 2) / 2;
        int chicken = sumHead - cow;

        sb.append(chicken).append(" ").append(cow);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
