import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static final int[] STROKES = {3, 2, 1, 2, 4, 3, 1, 3, 1, 1, 3, 1, 3, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer lengths = new StringTokenizer(br.readLine());
        int aLength = Integer.parseInt(lengths.nextToken());
        int bLength = Integer.parseInt(lengths.nextToken());

        StringTokenizer names = new StringTokenizer(br.readLine());
        char[] aName = names.nextToken().toCharArray();
        char[] bName = names.nextToken().toCharArray();

        ArrayList<Integer> current = new ArrayList<>();
        int maxLength = Math.max(aLength, bLength);
        for (int idx = 0; idx < maxLength; idx++) {
            if (idx < aLength) {
                current.add(STROKES[aName[idx] - 'A']);
            }
            if (idx < bLength) {
                current.add(STROKES[bName[idx] - 'A']);
            }
        }

        while (current.size() > 2) {
            ArrayList<Integer> next = new ArrayList<>();
            for (int i = 1; i < current.size(); i++) {
                int a = current.get(i - 1);
                int b = current.get(i);

                next.add((a + b) % 10);
            }

            current = next;
        }

        int compatibility = current.get(0) * 10 + current.get(1);
        sb.append(compatibility).append("%");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
