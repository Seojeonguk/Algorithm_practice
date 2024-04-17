import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    static final int MAX_X = 100000;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            ArrayList<Integer>[] yIndex = new ArrayList[MAX_X + 1];

            int testCase = Integer.parseInt(br.readLine());
            for (int tc = 1; tc <= testCase; tc++) {
                for (int i = 0; i <= MAX_X; i++) {
                    yIndex[i] = new ArrayList<>();
                }

                TreeSet<Integer> xIndex = new TreeSet<>();
                int cafeCnt = Integer.parseInt(br.readLine());


                for (int i = 0; i < cafeCnt; i++) {
                    StringTokenizer cafeCoordinates = new StringTokenizer(br.readLine());
                    int x = Integer.parseInt(cafeCoordinates.nextToken());
                    int y = Integer.parseInt(cafeCoordinates.nextToken());

                    xIndex.add(x);
                    yIndex[x].add(y);
                }

                int[][] cafes = new int[cafeCnt][2];
                int idx = 0, lastY = 0;
                for (int x : xIndex) {
                    int min = yIndex[x].stream().min(Integer::compare).get();
                    if (min == lastY) {
                        Collections.sort(yIndex[x]);
                    } else {
                        Collections.sort(yIndex[x], Collections.reverseOrder());
                    }

                    for (int y : yIndex[x]) {
                        cafes[idx][0] = x;
                        cafes[idx][1] = y;

                        idx++;
                        lastY = y;
                    }
                }

                StringTokenizer queryInfo = new StringTokenizer(br.readLine());
                int queryCnt = Integer.parseInt(queryInfo.nextToken());
                for (int i = 0; i < queryCnt; i++) {
                    int cafeNum = Integer.parseInt(queryInfo.nextToken());
                    sb.append(cafes[cafeNum - 1][0]).append(" ").append(cafes[cafeNum - 1][1]).append("\n");
                }
            }

            bw.write(sb.toString());
        }
    }
}
