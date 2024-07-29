import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int rowSize = Integer.parseInt(st.nextToken());
            int colSize = Integer.parseInt(st.nextToken());

            int[][] stones = new int[rowSize][colSize];
            for (int row = 0; row < rowSize; row++) {
                StringTokenizer rows = new StringTokenizer(br.readLine());
                for (int col = 0; col < colSize; col++) {
                    stones[row][col] = Integer.parseInt(rows.nextToken());
                }
            }

            sb.append(calMaxKillOpponentStoneByTwo(rowSize, colSize, stones));

            bw.write(sb.toString());
        }
    }

    public static int calMaxKillOpponentStoneByTwo(int rowSize, int colSize, int[][] stones) {
        int[][] groups = new int[rowSize][colSize];
        for (int row = 0; row < rowSize; row++) {
            Arrays.fill(groups[row], -1);
        }

        ArrayList<Integer> stonesGroups = new ArrayList<>();
        ArrayList<Integer> emptyPlaces = new ArrayList<>();

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (groups[row][col] == -1 && stones[row][col] == 2) {
                    int groupCnt = calRequiredStoneToKill(rowSize, colSize, stones, row, col, groups, stonesGroups.size());
                    stonesGroups.add(groupCnt);
                }

                if (stones[row][col] == 0) {
                    emptyPlaces.add(row * colSize + col);
                }
            }
        }

        int[] requiredStonesToKill = new int[stonesGroups.size()];
        int maxKillOpponentStone = 0;

        int emptyPlaceCnt = emptyPlaces.size();
        for (int firstIdx = 0; firstIdx < emptyPlaceCnt; firstIdx++) {
            for (int secondIdx = firstIdx + 1; secondIdx < emptyPlaceCnt; secondIdx++) {
                int firstPlace = emptyPlaces.get(firstIdx);
                int secondPlace = emptyPlaces.get(secondIdx);

                stones[firstPlace / colSize][firstPlace % colSize] = stones[secondPlace / colSize][secondPlace % colSize] = 1;

                Arrays.fill(requiredStonesToKill, 0);

                for (int row = 0; row < rowSize; row++) {
                    for (int col = 0; col < colSize; col++) {
                        if (stones[row][col] != 0) {
                            continue;
                        }

                        Set<Integer> s = new HashSet<>();
                        for (int[] direction : DIRECTIONS) {
                            int nx = row + direction[0];
                            int ny = col + direction[1];

                            if (isOut(rowSize, colSize, nx, ny) || groups[nx][ny] < 0) {
                                continue;
                            }

                            int group = groups[nx][ny];
                            if (s.contains(group)) {
                                continue;
                            }

                            requiredStonesToKill[group]++;
                            s.add(group);
                        }
                    }
                }

                int killOpponentStone = 0;
                for (int i = 0; i < requiredStonesToKill.length; i++) {
                    if (requiredStonesToKill[i] == 0) {
                        killOpponentStone += stonesGroups.get(i);
                    }
                }

                maxKillOpponentStone = Math.max(maxKillOpponentStone, killOpponentStone);

                stones[firstPlace / colSize][firstPlace % colSize] = stones[secondPlace / colSize][secondPlace % colSize] = 0;
            }
        }

        return maxKillOpponentStone;
    }

    public static int calRequiredStoneToKill(int rowSize, int colSize, int[][] stones, int sx, int sy, int[][] groups, int groupNum) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy});

        groups[sx][sy] = groupNum;
        int groupCnt = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            groupCnt++;

            for (int[] direction : DIRECTIONS) {
                int nx = cur[0] + direction[0];
                int ny = cur[1] + direction[1];

                if (isOut(rowSize, colSize, nx, ny) || groups[nx][ny] != -1 || stones[nx][ny] != 2) {
                    continue;
                }

                groups[nx][ny] = groupNum;
                q.add(new int[]{nx, ny});
            }
        }

        return groupCnt;
    }

    public static boolean isOut(int rowSize, int colSize, int x, int y) {
        return (x < 0 || y < 0 || x > rowSize - 1 || y > colSize - 1);
    }
}
