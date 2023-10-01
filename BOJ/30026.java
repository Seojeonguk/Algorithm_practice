import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int cityCnt = Integer.parseInt(br.readLine());
        int[] magicDoors = new int[cityCnt + 1];
        int[] groupNums = new int[cityCnt + 1];
        int[] idx = new int[cityCnt + 1];
        for (int city = 1; city <= cityCnt; city++) {
            groupNums[city] = city;
        }

        st = new StringTokenizer(br.readLine());
        for (int city = 1; city <= cityCnt; city++) {
            magicDoors[city] = Integer.parseInt(st.nextToken());
            idx[magicDoors[city]] = city;
            merge(city, magicDoors[city], groupNums);
        }

        ArrayList<int[]> unionList = new ArrayList<>();
        for (int city = 1; city < cityCnt; city++) {
            int curCityGroupNum = find(city, groupNums);
            int nextCityGroupNum = find(city + 1, groupNums);

            if (curCityGroupNum == nextCityGroupNum) {
                continue;
            }
            merge(curCityGroupNum, nextCityGroupNum, groupNums);
            unionList.add(new int[]{idx[city], idx[city + 1]});
            int temp = idx[city];
            idx[city] = idx[city + 1];
            idx[city + 1] = temp;
        }

        sb.append(unionList.size()).append(" ").append(unionList.size()).append("\n");
        for (int[] unions : unionList) {
            sb.append(unions[0]).append(" ").append(unions[1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int find(int x, int[] p) {
        if (p[x] == x) {
            return x;
        }
        return p[x] = find(p[x], p);
    }

    public static void merge(int a, int b, int[] p) {
        a = find(a, p);
        b = find(b, p);

        if (a == b) {
            return;
        }
        p[a] = b;
    }
}
