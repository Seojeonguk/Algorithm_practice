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
        st = new StringTokenizer(br.readLine());
        int totalRoom = Integer.parseInt(st.nextToken());
        int initialAttack = Integer.parseInt(st.nextToken());

        Room[] rooms = new Room[totalRoom];
        for (int i = 0; i < totalRoom; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            rooms[i] = new Room(t, a, h);
        }

        long minMaxHP = getMinMaxHP(initialAttack, rooms);
        sb.append(minMaxHP);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static long getMinMaxHP(int initialAttack, Room[] rooms) {
        long left = 1, right = Long.MAX_VALUE / 4;
        while (left <= right) {
            long maxHP = (left + right) / 2;
            long HP = maxHP;
            long attack = initialAttack;
            boolean isDied = false;

            for (int i = 0; i < rooms.length; i++) {
                if (rooms[i].t == 1) {
                    long monsterHP = rooms[i].h;
                    long monsterAttack = rooms[i].a;
                    long attackCnt = (monsterHP + attack - 1) / attack;
                    long monsterAttackCnt = attackCnt - 1;
                    HP -= monsterAttackCnt * monsterAttack;
                    if (HP <= 0) {
                        isDied = true;
                        break;
                    }
                } else {
                    attack += rooms[i].a;
                    HP = Math.min(HP + rooms[i].h, maxHP);
                }
            }

            if (isDied) {
                left = maxHP + 1;
            } else {
                right = maxHP - 1;
            }
        }
        return left;
    }

    static class Room {
        int t, a, h;

        Room(int t, int a, int h) {
            this.t = t;
            this.a = a;
            this.h = h;
        }
    }
}
