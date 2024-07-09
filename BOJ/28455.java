import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    static final int UNION_CHARACTER_LIMIT = 42;
    static final int[] STAT_INCREMENT_LEVELS = {0, 60, 100, 140, 200, 250};

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int hasCharacterCnt = Integer.parseInt(br.readLine());
            Integer[] levels = new Integer[hasCharacterCnt];
            for (int i = 0; i < hasCharacterCnt; i++) {
                levels[i] = Integer.parseInt(br.readLine());
            }

            Union union = getUnion(levels);
            sb.append(union.sumLevel).append(" ").append(union.incrementStat);

            bw.write(sb.toString());
        }
    }

    public static Union getUnion(Integer[] levels) {
        Union union = new Union();

        Arrays.sort(levels, Collections.reverseOrder());
        int unionCharacter = Math.min(UNION_CHARACTER_LIMIT, levels.length);
        for (int idx = 0; idx < unionCharacter; idx++) {
            union.addCharacter(levels[idx]);
        }

        return union;
    }

    public static class Union {
        int sumLevel;
        int incrementStat;

        public Union() {
            this.sumLevel = 0;
            this.incrementStat = 0;
        }

        public void addCharacter(int level) {
            this.addLevel(level);
            this.addStat(level);
        }

        private void addLevel(int level) {
            this.sumLevel += level;
        }

        private void addStat(int level) {
            int incrementStat = 0;
            for (int i = 0; i < STAT_INCREMENT_LEVELS.length; i++) {
                if (STAT_INCREMENT_LEVELS[i] <= level) {
                    incrementStat = i;
                }
            }

            this.incrementStat += incrementStat;
        }
    }
}
