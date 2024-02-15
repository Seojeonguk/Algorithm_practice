import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= testCase; tc++) {
            StringTokenizer info = new StringTokenizer(br.readLine());
            int materialCnt = Integer.parseInt(info.nextToken());
            int oblongCnt = Integer.parseInt(info.nextToken());

            int[] densities = new int[materialCnt + 1];
            for (int materialNum = 1; materialNum <= materialCnt; materialNum++) {
                densities[materialNum] = Integer.parseInt(br.readLine());
            }

            int totalOblongWeight = 0;
            for (int buildingNum = 1; buildingNum <= oblongCnt; buildingNum++) {
                StringTokenizer oblongInfo = new StringTokenizer(br.readLine());
                int oblongHeight = Integer.parseInt(oblongInfo.nextToken());
                int oblongWidth = Integer.parseInt(oblongInfo.nextToken());
                int oblongDepth = Integer.parseInt(oblongInfo.nextToken());
                int materialIndex = Integer.parseInt(oblongInfo.nextToken());

                totalOblongWeight += oblongHeight * oblongWidth * oblongDepth * densities[materialIndex];
            }

            sb.append(String.format("Data Set %d:\n%d\n", tc, totalOblongWeight));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
