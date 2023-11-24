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

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int puddleCnt = Integer.parseInt(st.nextToken());
        int boardLength = Integer.parseInt(st.nextToken());

        Puddle[] puddles = new Puddle[puddleCnt];
        for (int i = 0; i < puddleCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            puddles[i] = new Puddle(start, end - 1);
        }

        Arrays.sort(puddles, Comparator.comparingInt(Puddle::getStart).thenComparing(Puddle::getEnd));

        int requiredMinBoard = 0;
        int curStartBoard = -1, curEndBoard = -1;
        for (int i = 0; i < puddleCnt; i++) {
            int puddleStart = puddles[i].start;
            int puddleEnd = puddles[i].end;

            if (curEndBoard >= puddleEnd) {
                continue;
            }

            if (curEndBoard < puddleStart) {
                curStartBoard = puddleStart;
                curEndBoard = curStartBoard + boardLength - 1;
                requiredMinBoard++;
            }

            while (curEndBoard < puddleEnd) {
                curStartBoard = curEndBoard + 1;
                curEndBoard = curStartBoard + boardLength - 1;
                requiredMinBoard++;
            }
        }

        sb.append(requiredMinBoard);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Puddle {
        int start, end;

        Puddle(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
}
