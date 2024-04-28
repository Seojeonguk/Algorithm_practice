import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer lectureInfo = new StringTokenizer(br.readLine());
            int lectureCnt = Integer.parseInt(lectureInfo.nextToken());
            int buildingPairCnt = Integer.parseInt(lectureInfo.nextToken());

            int[] parent = new int[lectureCnt + 1];
            for (int buildingNum = 1; buildingNum <= lectureCnt; buildingNum++) {
                parent[buildingNum] = buildingNum;
            }

            for (int i = 0; i < buildingPairCnt; i++) {
                StringTokenizer buildingPairInfo = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(buildingPairInfo.nextToken());
                int b = Integer.parseInt(buildingPairInfo.nextToken());

                merge(parent, a, b);
            }

            int[] lectureCodes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int minExitBuildingCnt = 0;
            for (int i = 1; i < lectureCnt; i++) {
                if (!isSameParent(parent, lectureCodes[i - 1], lectureCodes[i])) {
                    minExitBuildingCnt++;
                }
            }

            sb.append(minExitBuildingCnt);

            bw.write(sb.toString());
        }
    }

    public static int find(int[] p, int x) {
        if (x == p[x]) {
            return x;
        }
        return p[x] = find(p, p[x]);
    }

    public static void merge(int[] p, int a, int b) {
        a = find(p, a);
        b = find(p, b);

        p[a] = b;
    }

    public static boolean isSameParent(int[] p, int a, int b) {
        a = find(p, a);
        b = find(p, b);

        return a == b;
    }
}
