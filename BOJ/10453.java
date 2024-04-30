import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int testCase = Integer.parseInt(br.readLine());
            for (int tc = 0; tc < testCase; tc++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                int ans = getAns(a, b);

                sb.append(ans).append("\n");
            }

            bw.write(sb.toString());
        }
    }

    private static int getAns(String a, String b) {
        int length = a.length();
        ArrayList<Integer> bIdxInA = new ArrayList<>();
        ArrayList<Integer> bIdxInB = new ArrayList<>();
        for (int idx = 0; idx < length; idx++) {
            if (a.charAt(idx) == 'b') {
                bIdxInA.add(idx);
            }
            if (b.charAt(idx) == 'b') {
                bIdxInB.add(idx);
            }
        }

        int arrLength = bIdxInA.size();
        int ans = 0;
        for (int i = 0; i < arrLength; i++) {
            ans += Math.abs(bIdxInA.get(i) - bIdxInB.get(i));
        }
        return ans;
    }
}
