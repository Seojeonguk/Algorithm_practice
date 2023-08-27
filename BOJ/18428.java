import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) throws Exception {
        int hallwaySize = Integer.parseInt(br.readLine());
        char[][] hallways = new char[hallwaySize][hallwaySize];

        ArrayList<Place> teachers = new ArrayList<>();
        ArrayList<Place> emptys = new ArrayList<>();
        for (int row = 0; row < hallwaySize; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < hallwaySize; col++) {
                hallways[row][col] = st.nextToken().charAt(0);
                if (hallways[row][col] == 'T') {
                    teachers.add(new Place(row, col));
                } else if (hallways[row][col] == 'X') {
                    emptys.add(new Place(row, col));
                }
            }
        }

        boolean canHideAllStudent = false;
        Loop1:
        for (int i = 0; i < emptys.size(); i++) {
            for (int j = i + 1; j < emptys.size(); j++) {
                for (int k = j + 1; k < emptys.size(); k++) {
                    hallways[emptys.get(i).getX()][emptys.get(i).getY()] = '.';
                    hallways[emptys.get(j).getX()][emptys.get(j).getY()] = '.';
                    hallways[emptys.get(k).getX()][emptys.get(k).getY()] = '.';

                    canHideAllStudent = verifyCanHideAllStudent(hallwaySize, hallways, teachers);
                    if (canHideAllStudent) {
                        break Loop1;
                    }

                    hallways[emptys.get(i).getX()][emptys.get(i).getY()] = 'X';
                    hallways[emptys.get(j).getX()][emptys.get(j).getY()] = 'X';
                    hallways[emptys.get(k).getX()][emptys.get(k).getY()] = 'X';
                }
            }
        }
        sb.append(canHideAllStudent ? "YES" : "NO");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean verifyCanHideAllStudent(int hallwaySize, char[][] hallways, ArrayList<Place> teachers) {
        for (Place teacher : teachers) {
            for (int dir = 0; dir < 4; dir++) {
                int teacherX = teacher.getX();
                int teacherY = teacher.getY();
                while (!isOut(hallwaySize, teacherX, teacherY) && hallways[teacherX][teacherY] != '.') {
                    if (hallways[teacherX][teacherY] == 'S') {
                        return false;
                    }
                    teacherX += dirs[dir][0];
                    teacherY += dirs[dir][1];
                }
            }
        }

        return true;
    }

    public static boolean isOut(int mapSize, int x, int y) {
        return x < 0 || y < 0 || x > mapSize - 1 || y > mapSize - 1;
    }

    static class Place {
        private int x;
        private int y;

        Place(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }
    }
}
