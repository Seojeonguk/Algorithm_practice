import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int cityCnt = Integer.parseInt(st.nextToken());
            int roadCnt = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] roads = new ArrayList[cityCnt + 1];
            for (int cityNum = 1; cityNum <= cityCnt; cityNum++) {
                roads[cityNum] = new ArrayList<>();
            }

            for (int roadNum = 0; roadNum < roadCnt; roadNum++) {
                StringTokenizer roadInfo = new StringTokenizer(br.readLine());
                int aRoad = Integer.parseInt(roadInfo.nextToken());
                int bRoad = Integer.parseInt(roadInfo.nextToken());

                roads[aRoad].add(bRoad);
                roads[bRoad].add(aRoad);
            }

            int destroyCityCnt = Integer.parseInt(br.readLine());
            StringTokenizer destroyCityInfo = new StringTokenizer(br.readLine());
            int[] destroyCities = new int[destroyCityCnt];
            for (int idx = 0; idx < destroyCityCnt; idx++) {
                destroyCities[idx] = Integer.parseInt(destroyCityInfo.nextToken());
            }

            ArrayList<Integer> puttingBombCities = calBombCities(roads, destroyCities);
            if (puttingBombCities.size() == 0) {
                sb.append(-1);
            } else {
                sb.append(puttingBombCities.size()).append("\n");
                for (int bombCity : puttingBombCities) {
                    sb.append(bombCity).append(" ");
                }
            }

            bw.write(sb.toString());
        }
    }

    public static ArrayList<Integer> calBombCities(ArrayList<Integer>[] roads, int[] destroyCities) {
        ArrayList<Integer> bombCities = new ArrayList<>();
        HashSet<Integer> checkedDestroyCities = new HashSet<>();

        HashSet<Integer> destroyCitiesSet = new HashSet<>();
        for (int destroyCity : destroyCities) {
            destroyCitiesSet.add(destroyCity);
        }

        for (int destroyCity : destroyCities) {
            boolean isBombCity = true;

            for (int connectedCity : roads[destroyCity]) {
                if (!destroyCitiesSet.contains(connectedCity)) {
                    isBombCity = false;
                    break;
                }
            }

            if (isBombCity) {
                bombCities.add(destroyCity);
                checkedDestroyCities.add(destroyCity);
                for (int connectedCity : roads[destroyCity]) {
                    checkedDestroyCities.add(connectedCity);
                }
            }
        }

        if (checkedDestroyCities.size() != destroyCitiesSet.size()) {
            bombCities.clear();
        }

        return bombCities;
    }
}
