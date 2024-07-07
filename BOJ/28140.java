import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int queries = Integer.parseInt(st.nextToken());

            char[] str = br.readLine().toCharArray();
            ArrayList<Integer> RIndexes = new ArrayList<>();
            ArrayList<Integer> BIndexes = new ArrayList<>();

            for (int idx = 0; idx < str.length; idx++) {
                if (str[idx] == 'R') {
                    RIndexes.add(idx);
                } else if (str[idx] == 'B') {
                    BIndexes.add(idx);
                }
            }

            while (queries-- > 0) {
                StringTokenizer range = new StringTokenizer(br.readLine());
                int left = Integer.parseInt(range.nextToken());
                int right = Integer.parseInt(range.nextToken());

                int[] answers = getAnswer(RIndexes, BIndexes, left, right);
                for (int answer : answers) {
                    sb.append(answer).append(" ");
                }
                sb.append("\n");
            }

            bw.write(sb.toString());
        }
    }

    public static int[] getAnswer(ArrayList<Integer> RIndexes, ArrayList<Integer> BIndexes, int left, int right) {
        if (RIndexes.size() < 2 || BIndexes.size() < 2) {
            return new int[]{-1};
        }

        int[] ans = new int[4];

        int Ridx = Collections.binarySearch(RIndexes, left);
        int Bidx = Collections.binarySearch(BIndexes, right);

        if (Ridx < 0) {
            Ridx = -(Ridx + 1);
        }

        if (Bidx < 0) {
            Bidx = -(Bidx + 1);
        }

        if (Bidx == BIndexes.size()) {
            Bidx--;
        }

        if (BIndexes.get(Bidx) > right) {
            Bidx--;
        }

        if (Ridx >= RIndexes.size() - 1 || Bidx < 1) {
            return new int[]{-1};
        }

        ans[0] = RIndexes.get(Ridx);
        ans[1] = RIndexes.get(Ridx + 1);
        ans[2] = BIndexes.get(Bidx - 1);
        ans[3] = BIndexes.get(Bidx);

        if (!validate(ans, left, right)) {
            return new int[]{-1};
        }

        return ans;
    }

    public static boolean validate(int[] ans, int l, int r) {
        for (int idx : ans) {
            if (!isIn(idx, l, r)) {
                return false;
            }
        }

        return checkOrder(ans);
    }

    public static boolean isIn(int idx, int l, int r) {
        return (l <= idx && idx <= r);
    }

    public static boolean checkOrder(int[] ans) {
        return (ans[0] < ans[1] && ans[1] < ans[2] && ans[2] < ans[3]);
    }
}
