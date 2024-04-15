import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static final char WOLF = 'W';
    static final char SHEEP = 'S';

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int islandCnt = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] childs = new ArrayList[islandCnt + 1];
        for (int islandNum = 1; islandNum <= islandCnt; islandNum++) {
            childs[islandNum] = new ArrayList();
        }

        Island[] islands = new Island[islandCnt + 1];
        islands[1] = new Island(SHEEP, 0);
        for (int islandNum = 2; islandNum <= islandCnt; islandNum++) {
            StringTokenizer islandInfo = new StringTokenizer(br.readLine());
            char type = islandInfo.nextToken().charAt(0);
            int animalCnt = Integer.parseInt(islandInfo.nextToken());
            int parentIslandNum = Integer.parseInt(islandInfo.nextToken());

            islands[islandNum] = new Island(type, animalCnt);
            childs[parentIslandNum].add(islandNum);
        }

        long rescueableSheeps = calRescueableSheeps(childs, islands, 1);
        sb.append(rescueableSheeps);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static long calRescueableSheeps(ArrayList<Integer>[] childs, Island[] islands, int currentIslandNum) {
        if (childs[currentIslandNum].isEmpty()) {
            return islands[currentIslandNum].type == SHEEP ? islands[currentIslandNum].animalCnt : 0;
        }

        long childRescueableSheeps = 0;
        for (Integer nextIslandNum : childs[currentIslandNum]) {
            childRescueableSheeps += calRescueableSheeps(childs, islands, nextIslandNum);
        }

        long currentRescueableSheeps = childRescueableSheeps + (islands[currentIslandNum].type == WOLF ? -1 : 1) * islands[currentIslandNum].animalCnt;
        if (currentRescueableSheeps < 0) {
            currentRescueableSheeps = 0;
        }

        return currentRescueableSheeps;
    }

    static class Island {
        char type;
        int animalCnt;

        Island(char type, int animalCnt) {
            this.type = type;
            this.animalCnt = animalCnt;
        }
    }
}
