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
        String str = br.readLine();
        TreeSet<String> ans = new TreeSet<>();
        solve(str, ans);

        ans.forEach(o -> {
            sb.append(o).append("\n");
        });

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void solve(String str, TreeSet<String> ans) {
        int[] bracketPairs = new int[str.length()];

        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> bracketStarts = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                s.add(i);
                bracketStarts.add(i);
            } else if (c == ')') {
                bracketPairs[s.pop()] = i;
            }
        }

        for (int i = 0; i < bracketStarts.size(); i++) {
            int bracketStart = bracketStarts.get(i);
            int bracketEnd = bracketPairs[bracketStart];

            String next = str.substring(0, bracketStart) + str.substring(bracketStart + 1, bracketEnd) + str.substring(bracketEnd + 1);
            if (ans.contains(next)) {
                continue;
            }
            ans.add(next);
            solve(next, ans);
        }
    }
}
