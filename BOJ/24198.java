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
        int muffin = Integer.parseInt(br.readLine());

        int alfMuffin = 0, beataMuffin = 0;
        boolean isAlfTurn = false;
        while (muffin > 0) {
            int half = muffin / 2;
            int eat = muffin - half;

            if (isAlfTurn) alfMuffin += eat;
            else beataMuffin += eat;

            isAlfTurn = !isAlfTurn;
            muffin = muffin - eat;
        }

        sb.append(alfMuffin).append(" ").append(beataMuffin);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
