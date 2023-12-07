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
        int titleCnt = Integer.parseInt(st.nextToken());
        int characterCnt = Integer.parseInt(st.nextToken());

        ArrayList<Title> titles = new ArrayList<>();
        HashSet<Integer> upperLimitPowers = new HashSet<>();
        for (int i = 0; i < titleCnt; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int upperLimitPower = Integer.parseInt(st.nextToken());
            if (upperLimitPowers.contains(upperLimitPower)) {
                continue;
            }
            upperLimitPowers.add(upperLimitPower);
            titles.add(new Title(name, upperLimitPower));
        }

        while (characterCnt-- > 0) {
            int power = Integer.parseInt(br.readLine());
            int idx = Collections.binarySearch(titles, new Title("", power));
            if (idx < 0) {
                idx = -(idx + 1);
            }
            sb.append(titles.get(idx).name).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Title implements Comparable<Title> {
        String name;
        int upperLimitPower;


        Title(String name, int upperLimitPower) {
            this.name = name;
            this.upperLimitPower = upperLimitPower;
        }

        public int getUpperLimitPower() {
            return upperLimitPower;
        }

        @Override
        public int compareTo(Title o) {
            return Integer.compare(this.upperLimitPower, o.upperLimitPower);
        }
    }
}
