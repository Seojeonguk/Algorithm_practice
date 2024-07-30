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
            int bearCnt = Integer.parseInt(st.nextToken());
            int diff = Integer.parseInt(st.nextToken());

            StringTokenizer bearWantedIndexesToken = new StringTokenizer(br.readLine());
            int[] bearWantedIndexes = new int[bearCnt];
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < bearCnt; i++) {
                bearWantedIndexes[i] = Integer.parseInt(bearWantedIndexesToken.nextToken());
                int pos = -1;

                for (int j = 0; j < arr.size(); j++) {
                    int l = arr.get(j) + diff;
                    int r = (j + 1 < arr.size() ? arr.get(j + 1) - diff : Integer.MAX_VALUE);

                    if (l <= r && bearWantedIndexes[i] <= r) {
                        int res = Math.max(l, bearWantedIndexes[i]);
                        if (pos == -1 || pos > res) {
                            pos = res;
                        }
                    }
                }

                if (pos == -1 || bearWantedIndexes[i] <= arr.get(0) - diff) {
                    pos = bearWantedIndexes[i];
                }

                sb.append(pos).append(" ");
                arr.add(pos);
                Collections.sort(arr);
            }
            bw.write(sb.toString());
        }
    }
}
