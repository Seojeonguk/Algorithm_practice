import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int BASEBALL_MAX_INNING = 9;

    public static void main(String[] args) throws Exception {
        int studentNum = Integer.parseInt(br.readLine());
        int[][] studentSeats = new int[studentNum][BASEBALL_MAX_INNING];
        HashMap<Integer, Integer> appearedThreeDigits = new HashMap<>();
        for (int i = 0; i < studentNum; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < BASEBALL_MAX_INNING; j++) {
                studentSeats[i][j] = Integer.parseInt(st.nextToken());
            }
            int threeDigit = convertThreeDigit(studentSeats[i]);
            int appearedCnt = 0;
            if (appearedThreeDigits.containsKey(threeDigit)) {
                appearedCnt = appearedThreeDigits.get(threeDigit);
            }
            appearedThreeDigits.put(threeDigit, appearedCnt + 1);
        }


        int[] ans = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        int[] teacherSeats = new int[BASEBALL_MAX_INNING];
        solve(teacherSeats, 0, ans, appearedThreeDigits);

        sb.append(ans[0]).append(" ").append(ans[1]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void solve(int[] teachersSeats, int seatCnt, int[] ans, HashMap<Integer, Integer> appearedThreeDigits) {
        if (seatCnt == BASEBALL_MAX_INNING) {
            int canEndStudent = 0;
            for (int a = 1; a <= 3; a++) {
                if (teachersSeats[0] == a) continue;
                for (int b = 1; b <= 3; b++) {
                    if (teachersSeats[1] == b) continue;
                    for (int c = 1; c <= 3; c++) {
                        if (teachersSeats[2] == c) continue;
                        for (int d = 1; d <= 3; d++) {
                            if (teachersSeats[3] == d) continue;
                            for (int e = 1; e <= 3; e++) {
                                if (teachersSeats[4] == e) continue;
                                for (int f = 1; f <= 3; f++) {
                                    if (teachersSeats[5] == f) continue;
                                    for (int g = 1; g <= 3; g++) {
                                        if (teachersSeats[6] == g) continue;
                                        for (int h = 1; h <= 3; h++) {
                                            if (teachersSeats[7] == h) continue;
                                            for (int i = 1; i <= 3; i++) {
                                                if (teachersSeats[8] == i) continue;
                                                int threeDigit = convertThreeDigit(new int[]{a, b, c, d, e, f, g, h, i});
                                                canEndStudent += appearedThreeDigits.getOrDefault(threeDigit, 0);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            
            ans[0] = Math.min(ans[0], canEndStudent);
            ans[1] = Math.max(ans[1], canEndStudent);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            teachersSeats[seatCnt] = i;
            solve(teachersSeats, seatCnt + 1, ans, appearedThreeDigits);
        }
    }

    public static int convertThreeDigit(int[] innings) {
        int threeDigit = 0;
        for (int seat : innings) {
            threeDigit *= 3;
            threeDigit += seat - 1;
        }

        return threeDigit;
    }
}
