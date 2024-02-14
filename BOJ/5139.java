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
            StringTokenizer seafloorMapInfo = new StringTokenizer(br.readLine());
            int seafloorMapHeight = Integer.parseInt(seafloorMapInfo.nextToken());
            int seafloorMapWidth = Integer.parseInt(seafloorMapInfo.nextToken());

            char[][] seafloorMaps = new char[seafloorMapHeight][seafloorMapWidth];
            for (int height = 0; height < seafloorMapHeight; height++) {
                seafloorMaps[height] = br.readLine().toCharArray();
            }

            sb.append("Data Set ").append(tc).append(":\n");
            for (int width = 0; width < seafloorMapWidth; width++) {
                boolean findOil = false;
                int drillDownCost = 0;
                for (int height = 0; height < seafloorMapHeight; height++) {
                    char c = seafloorMaps[height][width];
                    if (c == 'X') {
                        findOil = true;
                        break;
                    } else if (c == 'H') {
                        drillDownCost += 3;
                    } else if (c == 'S') {
                        drillDownCost++;
                    }
                }
                sb.append(findOil ? drillDownCost : "N").append(" ");
            }
            sb.append("\n\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
