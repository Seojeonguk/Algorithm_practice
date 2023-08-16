import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] modes = {0, 1, 1, 2, 2, 3};

    public static void main(String[] args) throws Exception {
        List<Prize> prizes = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int prizeNumber = Integer.parseInt(st.nextToken());
            int prizeMoney = Integer.parseInt(st.nextToken());
            Prize prize = new Prize(prizeNumber, prizeMoney, modes[i]);
            prizes.add(prize);
        }

        while (true) {
            int lottoNumber = Integer.parseInt(br.readLine());

            if (lottoNumber == -1) {
                break;
            }

            int totalPrizeMoney = 0;
            for (int i = 0; i < 6; i++) {
                int transformPrizeNum = prizes.get(i).getPrizeNumber();
                int transformLottoNum = transformNumber(lottoNumber, modes[i]);

                if (transformPrizeNum == transformLottoNum) {
                    totalPrizeMoney += prizes.get(i).getPrizeMoney();
                }
            }
            sb.append(totalPrizeMoney).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Prize {
        private int prizeNumber;
        private int prizeMoney;
        private int mode;

        Prize(int prizeNumber, int prizeMoney, int mode) {
            this.prizeNumber = prizeNumber;
            this.prizeMoney = prizeMoney;
            this.mode = mode;
        }

        public int getPrizeNumber() {
            return this.prizeNumber;
        }

        public int getPrizeMoney() {
            return this.prizeMoney;
        }
    }

    public static int transformNumber(int number, int mode) {
        if (mode == 0) return number;
        else if (mode == 1) return number / 1000;
        else if (mode == 2) return number % 1000;
        return number % 100;
    }
}
