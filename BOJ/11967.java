import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static final int[] DX = {1, 0, -1, 0};
    static final int[] DY = {0, 1, 0, -1};

    static final int startRow = 0;
    static final int startCol = 0;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int keyCnt = Integer.parseInt(st.nextToken());

        int keySize = size * (size + 1) + 1;
        ArrayList<Integer>[] hasKeys = new ArrayList[keySize];
        for (int i = 0; i < keySize; i++) {
            hasKeys[i] = new ArrayList<>();
        }

        for (int i = 0; i < keyCnt; i++) {
            StringTokenizer keyInfo = new StringTokenizer(br.readLine());
            int keyX = Integer.parseInt(keyInfo.nextToken()) - 1;
            int keyY = Integer.parseInt(keyInfo.nextToken()) - 1;

            int turnOnX = Integer.parseInt(keyInfo.nextToken()) - 1;
            int turnOnY = Integer.parseInt(keyInfo.nextToken()) - 1;

            int keyXT = keyX * size + keyY;
            int turnOnXY = turnOnX * size + turnOnY;

            hasKeys[keyXT].add(turnOnXY);
        }

        int lightOnRoom = 1;
        boolean[][] isLightOn = new boolean[size + 1][size + 1];
        isLightOn[startRow][startCol] = true;
        while (true) {
            ArrayList<Integer> foundNewKeys = new ArrayList<>();


            boolean[][] isVisit = new boolean[size + 1][size + 1];
            isVisit[startRow][startCol] = true;

            Queue<Integer> q = new LinkedList<>();
            q.add(0);
            while (!q.isEmpty()) {
                int cur = q.poll();
                int curRow = cur / size;
                int curCol = cur % size;

                if (!hasKeys[cur].isEmpty()) {
                    foundNewKeys.addAll(hasKeys[cur]);
                    hasKeys[cur] = new ArrayList<>();
                }

                for (int i = 0; i < 4; i++) {
                    int nextRow = curRow + DX[i];
                    int nextCol = curCol + DY[i];

                    if (nextRow < startRow || nextCol < startCol || nextRow > size || nextCol > size || isVisit[nextRow][nextCol] || !isLightOn[nextRow][nextCol]) {
                        continue;
                    }

                    isVisit[nextRow][nextCol] = true;
                    q.add(nextRow * size + nextCol);
                }
            }

            if (foundNewKeys.isEmpty()) {
                break;
            }

            for (Integer foundNewKey : foundNewKeys) {
                int row = foundNewKey / size;
                int col = foundNewKey % size;

                if (!isLightOn[row][col]) {
                    lightOnRoom++;
                    isLightOn[row][col] = true;
                }
            }
        }

        sb.append(lightOnRoom);

        bw.write(sb.toString());
        bw.flush();
    }
}
