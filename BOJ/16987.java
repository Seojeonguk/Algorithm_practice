import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int eggCnt = Integer.parseInt(br.readLine());

        Egg[] eggs = new Egg[eggCnt];
        for (int i = 0; i < eggCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int durability = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(durability, weight);
        }
        int maxBrokenEgg = hitEgg(0, eggs);
        sb.append(maxBrokenEgg);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int hitEgg(int cur, Egg[] eggs) {
        if (cur == eggs.length) {
            int brokenEgg = 0;
            for (int idx = 0; idx < eggs.length; idx++) {
                if (eggs[idx].getDurability() <= 0) {
                    brokenEgg++;
                }
            }
            return brokenEgg;
        }
        if (eggs[cur].getDurability() <= 0) {
            return hitEgg(cur + 1, eggs);
        }
        int maxBrokenEgg = 0;

        boolean canHitAnyEgg = false;
        for (int idx = 0; idx < eggs.length; idx++) {
            if (idx == cur || eggs[idx].durability <= 0) {
                continue;
            }
            canHitAnyEgg = true;
            eggs[cur].addDurability(-eggs[idx].getWeight());
            eggs[idx].addDurability(-eggs[cur].getWeight());

            maxBrokenEgg = Math.max(maxBrokenEgg, hitEgg(cur + 1, eggs));

            eggs[cur].addDurability(eggs[idx].getWeight());
            eggs[idx].addDurability(eggs[cur].getWeight());
        }
        if (!canHitAnyEgg) {
            return hitEgg(cur + 1, eggs);
        }

        return maxBrokenEgg;
    }

    static class Egg {
        private int durability;
        private int weight;

        Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }

        public int getDurability() {
            return this.durability;
        }

        public int getWeight() {
            return this.weight;
        }

        public void addDurability(int value) {
            this.durability += value;
        }
    }
}
