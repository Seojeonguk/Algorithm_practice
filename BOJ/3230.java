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
        int firstRoundPersons = Integer.parseInt(st.nextToken());
        int secondRoundPersons = Integer.parseInt(st.nextToken());

        ArrayList<Integer> firstRanks = new ArrayList<>();
        for (int i = 1; i <= firstRoundPersons; i++) {
            int currentRank = Integer.parseInt(br.readLine());
            firstRanks.add(currentRank - 1, i);
        }

        ArrayList<Integer> secondRanks = new ArrayList<>();
        for (int i = 0; i < secondRoundPersons; i++) {
            int currentRank = Integer.parseInt(br.readLine());
            int currentNum = firstRanks.get(secondRoundPersons - 1 - i);
            secondRanks.add(currentRank - 1, currentNum);
        }

        for (int i = 0; i < 3; i++) {
            sb.append(secondRanks.get(i)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
