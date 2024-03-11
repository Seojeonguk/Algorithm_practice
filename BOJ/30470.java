import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        TreeMap<Integer, Integer> treeLengths = new TreeMap<>();

        int queryCnt = Integer.parseInt(br.readLine());
        for (int queryNum = 0; queryNum < queryCnt; queryNum++) {
            StringTokenizer queryInfo = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(queryInfo.nextToken());
            int x = Integer.parseInt(queryInfo.nextToken());

            if (query == 1) {
                treeLengths.put(x, 1);
            } else if (query == 2) {
                if (treeLengths.isEmpty()) {
                    continue;
                }
                int treeLength = Math.max(treeLengths.lastEntry().getKey() - x, 0);

                if (treeLength == 0) {
                    treeLengths.clear();
                } else {
                    int changedTreeCnt = 0;
                    while (!treeLengths.isEmpty() && treeLengths.lastKey() > treeLength) {
                        changedTreeCnt += treeLengths.pollLastEntry().getValue();
                    }
                    if (treeLengths.containsKey(treeLength)) {
                        changedTreeCnt += treeLengths.get(treeLength);
                    }
                    treeLengths.put(treeLength, changedTreeCnt);
                }
            }
        }

        long sumTotalTree = 0;
        while (!treeLengths.isEmpty()) {
            Map.Entry<Integer, Integer> tree = treeLengths.pollLastEntry();
            sumTotalTree += (long) tree.getKey() * tree.getValue();
        }
        sb.append(sumTotalTree);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
