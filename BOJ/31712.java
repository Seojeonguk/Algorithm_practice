import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static final int TOTAL_MASCOT = 3;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Mascot[] mascots = new Mascot[TOTAL_MASCOT];
        for (int mascotNum = 0; mascotNum < TOTAL_MASCOT; mascotNum++) {
            StringTokenizer mascotInfo = new StringTokenizer(br.readLine());
            int delay = Integer.parseInt(mascotInfo.nextToken());
            int damage = Integer.parseInt(mascotInfo.nextToken());

            mascots[mascotNum] = new Mascot(delay, damage);
        }

        int pinkbinHP = Integer.parseInt(br.readLine());
        for (int time = 0; ; time++) {
            for (int mascotNum = 0; mascotNum < TOTAL_MASCOT; mascotNum++) {
                if (time % mascots[mascotNum].skillDelay == 0) {
                    pinkbinHP -= mascots[mascotNum].skillDamage;
                }
            }

            if (pinkbinHP <= 0) {
                sb.append(time);
                break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Mascot {
        int skillDelay;
        int skillDamage;

        Mascot(int skillDelay, int skillDamage) {
            this.skillDelay = skillDelay;
            this.skillDamage = skillDamage;
        }
    }
}
