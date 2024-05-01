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

            StringTokenizer st = new StringTokenizer(br.readLine());
            int pSize = Integer.parseInt(st.nextToken());
            int qSize = Integer.parseInt(st.nextToken());

            StringTokenizer yInfo = new StringTokenizer(br.readLine());
            int pY = Integer.parseInt(yInfo.nextToken());
            int qY = Integer.parseInt(yInfo.nextToken());

            StringTokenizer pXInfo = new StringTokenizer(br.readLine());
            int[] p = new int[pSize];
            for (int i = 0; i < pSize; i++) {
                p[i] = Integer.parseInt(pXInfo.nextToken());
            }

            StringTokenizer qXInfo = new StringTokenizer(br.readLine());
            int[] q = new int[qSize];
            for (int i = 0; i < qSize; i++) {
                q[i] = Integer.parseInt(qXInfo.nextToken());
            }

            Arrays.sort(q);

            int minDistance = Integer.MAX_VALUE;
            int minDistanceCnt = 0;
            for (int value : p) {
                int[] distanceInfo = calMinDistance(q, value);
                if (minDistance > distanceInfo[0]) {
                    minDistance = distanceInfo[0];
                    minDistanceCnt = distanceInfo[1];
                } else if (minDistance == distanceInfo[0]) {
                    minDistanceCnt += distanceInfo[1];
                }
            }

            sb.append(minDistance + Math.abs(pY - qY)).append(" ").append(minDistanceCnt);

            bw.write(sb.toString());
        }
    }

    public static int[] calMinDistance(int[] arr, int value) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int distance = Math.abs(arr[left] - value);
        int distanceCnt = 1;
        if (left > 0) {
            int prevAbs = Math.abs(arr[left - 1] - value);
            if (prevAbs == distance) {
                distanceCnt++;
            } else if (prevAbs < distance) {
                distance = prevAbs;
            }
        }

        if (right < arr.length - 1) {
            int nextAbs = Math.abs(arr[left + 1] - value);
            if (nextAbs == distance) {
                distanceCnt++;
            } else if (nextAbs < distance) {
                distance = nextAbs;
                distanceCnt = 1;
            }
        }

        return new int[]{distance, distanceCnt};
    }
}
