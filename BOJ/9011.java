import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < testCase; tc++) {
            int rSize = Integer.parseInt(br.readLine());
            int[] r = new int[rSize];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < rSize; i++) {
                r[i] = Integer.parseInt(st.nextToken());
            }

            Deque<Integer> s = calS(r);
            if (s.isEmpty()) {
                sb.append("IMPOSSIBLE");
            } else {
                for (int value : s) {
                    sb.append(value).append(" ");
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static Deque<Integer> calS(int[] arr) {
        Deque<Integer> s = new ArrayDeque<>();

        ArrayList<Integer> possibleValue = new ArrayList<>();
        for (int i = 1; i <= arr.length; i++) {
            possibleValue.add(i);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] >= possibleValue.size()) {
                s.clear();
                break;
            }
            s.addFirst(possibleValue.get(arr[i]));
            possibleValue.remove(arr[i]);
        }

        return s;
    }
}
