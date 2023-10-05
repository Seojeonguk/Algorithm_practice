import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());

        char[][] map = new char[rowSize][colSize];
        int[][] monsterIdxMap = new int[rowSize][colSize];

        Player player = new Player();
        Base destination = new Base();
        ArrayList<Monster> monsters = new ArrayList<>();

        int monsterIdx = 0;
        for (int row = 0; row < rowSize; row++) {
            map[row] = br.readLine().toCharArray();
            for (int col = 0; col < colSize; col++) {
                if (map[row][col] == 'p') {
                    player.setPosition(row, col);
                    map[row][col] = '.';
                } else if (map[row][col] == 'm') {
                    monsters.add(new Monster(row, col));
                    monsterIdxMap[row][col] = monsterIdx++;
                } else if (map[row][col] == 'g') {
                    destination.setPosition(row, col);
                    map[row][col] = '.';
                }
            }
        }

        int monsterCnt = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < monsterCnt; i++) {
            int monsterHp = Integer.parseInt(st.nextToken());
            monsters.get(i).setHp(monsterHp);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < monsterCnt; i++) {
            int monsterDefense = Integer.parseInt(st.nextToken());
            monsters.get(i).setDefense(monsterDefense);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < monsterCnt; i++) {
            int monsterExp = Integer.parseInt(st.nextToken());
            monsters.get(i).setExp(monsterExp);
        }

        int commandCnt = Integer.parseInt(br.readLine());
        String[] commands = br.readLine().split(" ");
        boolean isClear = false;
        for (String command : commands) {
            if ("w".equals(command)) {
                player.act(1);
            } else if ("udlr".contains(command)) {
                int dir = getDir(command.charAt(0));
                int nextX = player.x + DIRS[dir][0] * player.speed;
                int nextY = player.y + DIRS[dir][1] * player.speed;

                if (!isOut(nextX, nextY, rowSize, colSize) && map[nextX][nextY] == '.') {
                    player.move(nextX, nextY);
                }
            }

            if (player.isOverdose) {
                continue;
            }

            if ("c".equals(command)) {
                isClear = player.isArriveDestination(destination);
            } else if (command.charAt(0) == 'd' && command.length() == 2) {
                int changedSpeed = (command.charAt(1) == 'u' ? 1 : -1);
                player.eatMedicine(changedSpeed);
            } else if (command.length() == 2) {
                int dir = getDir(command.charAt(1));

                player.act(3);

                int gainExp = 0;
                for (int i = 1; i <= player.range; i++) {
                    int attackX = player.x + DIRS[dir][0] * i;
                    int attackY = player.y + DIRS[dir][1] * i;

                    if (isOut(attackX, attackY, rowSize, colSize) || map[attackX][attackY] == '*') {
                        break;
                    }

                    if (map[attackX][attackY] == 'm') {
                        int monsterNum = monsterIdxMap[attackX][attackY];
                        Monster monster = monsters.get(monsterNum);
                        player.attack(monster);
                        if (!monster.isAlive) {
                            gainExp += monster.exp;
                            map[attackX][attackY] = '.';
                        }
                    }
                }

                player.addExp(gainExp);
            }

            if (isClear) {
                break;
            }
        }
        map[destination.x][destination.y] = 'g';
        map[player.x][player.y] = 'p';

        sb.append(player.level).append(" ").append(player.exp).append("\n");
        sb.append(player.action).append("\n");
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                sb.append(map[row][col]);
            }
            sb.append("\n");
        }

        for (Monster monster : monsters) {
            if (monster.isAlive) {
                sb.append(monster.hp).append(" ");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isOut(int x, int y, int n, int m) {
        return x < 0 || y < 0 || x > n - 1 || y > m - 1;
    }

    public static int getDir(char c) {
        int dir = -1;
        if (c == 'u') dir = 0;
        else if (c == 'd') dir = 1;
        else if (c == 'l') dir = 2;
        else if (c == 'r') dir = 3;
        return dir;
    }

    static class Base {
        int x;
        int y;

        public void setPosition(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Player extends Base {
        int level;
        int damage;
        int range;
        int speed;
        int levelUpExp;
        int exp;
        int action;
        boolean isOverdose;
        int overdoseAction;
        int eatMedicineCnt;

        Player() {
            this.level = 1;
            this.damage = 5;
            this.range = 1;
            this.speed = 1;
            this.levelUpExp = 10;
            this.exp = 0;
            this.action = 0;
            this.isOverdose = false;
            this.overdoseAction = 0;
            this.eatMedicineCnt = 0;
        }

        public void act(int changedAction) {
            this.action += changedAction;
            if (this.isOverdose) {
                this.overdoseAction += changedAction;
                if (this.overdoseAction >= 10) {
                    this.overdoseAction = 0;
                    this.isOverdose = false;
                }
            }
        }

        public boolean isArriveDestination(Base destination) {
            return this.x == destination.x && this.y == destination.y;
        }

        public void eatMedicine(int changedSpeed) {
            this.act(2);

            this.speed += changedSpeed;
            if (this.speed < 0) {
                this.speed = 0;
            }

            this.eatMedicineCnt += 1;
            if (eatMedicineCnt % 5 == 0) {
                this.isOverdose = true;
            }
        }

        public void move(int nextX, int nextY) {
            this.setPosition(nextX, nextY);
            this.act(1);
        }

        public int attack(Monster monster) {
            int exp = 0;
            if (this.damage < monster.defense) {
                return 0;
            }

            monster.setHp(monster.hp - (this.damage - monster.defense));
            if (!monster.isAlive) {
                exp = monster.exp;
            }
            return exp;
        }

        public void addExp(int exp) {
            this.exp += exp;
            while (this.levelUpExp <= this.exp) {
                this.damage += this.level;
                this.range += 1;
                this.level += 1;
                this.exp -= this.levelUpExp;
                this.levelUpExp += 10;
            }
        }
    }

    static class Monster extends Base {
        int defense;
        int hp;
        int exp;
        boolean isAlive;

        Monster(int x, int y) {
            this.x = x;
            this.y = y;
            this.isAlive = true;
        }

        public void setHp(int hp) {
            this.hp = hp;
            if (this.hp <= 0) {
                this.isAlive = false;
            }
        }

        public void setExp(int exp) {
            this.exp = exp;
        }

        public void setDefense(int defense) {
            this.defense = defense;
        }
    }
}
