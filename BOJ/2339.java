import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int stonePlateSize = Integer.parseInt(br.readLine());
        int[][] stonePlateStates = new int[stonePlateSize][stonePlateSize];
        int impurities = 0, jewelry = 0;
        for (int i = 0; i < stonePlateSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < stonePlateSize; j++) {
                stonePlateStates[i][j] = Integer.parseInt(st.nextToken());
                if (stonePlateStates[i][j] == 1) {
                    impurities++;
                } else if (stonePlateStates[i][j] == 2) {
                    jewelry++;
                }
            }
        }

        if (stonePlateSize == 1) {
            sb.append(stonePlateStates[0][0] == 2 ? 1 : -1);
        } else {
            int answer = solve(stonePlateStates, 0, 0, stonePlateSize, stonePlateSize, true) + solve(stonePlateStates, 0, 0, stonePlateSize, stonePlateSize, false);
            sb.append(answer == 0 ? -1 : answer);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solve(int[][] states, int sx, int sy, int ex, int ey, boolean isHorizon) {
        int ret = 0, impurities = 0, jewelry = 0;

        for (int i = sx; i < ex; i++) {
            for (int j = sy; j < ey; j++) {
                if (states[i][j] == 1) {
                    impurities++;
                    boolean isOnJewelry = false;
                    if (isHorizon) {
                        for (int k = sy; k < ey; k++) {
                            if (states[i][k] == 2) {
                                isOnJewelry = true;
                            }
                        }
                        if (!isOnJewelry) {
                            ret += solve(states, sx, sy, i, ey, !isHorizon) * solve(states, i + 1, sy, ex, ey, !isHorizon);
                        }
                    } else {
                        for (int k = sx; k < ex; k++) {
                            if (states[k][j] == 2) {
                                isOnJewelry = true;
                            }
                        }
                        if (!isOnJewelry) {
                            ret += solve(states, sx, sy, ex, j, !isHorizon) * solve(states, sx, j + 1, ex, ey, !isHorizon);
                        }
                    }
                } else if (states[i][j] == 2) {
                    jewelry++;
                }
            }
        }

        if (impurities == 0) {
            return jewelry == 1 ? 1 : 0;
        }
        return ret;
    }
}
