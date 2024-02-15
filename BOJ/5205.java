import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= testCase; tc++) {
            int colorCnt = Integer.parseInt(br.readLine());

            Color[] colors = new Color[colorCnt + 1];
            for (int colorNum = 1; colorNum <= colorCnt; colorNum++) {
                StringTokenizer colorInfo = new StringTokenizer(br.readLine());
                colors[colorNum] = new Color(colorInfo);
            }

            int maxContrast = 0;
            ArrayList<int[]> maxContrastIndexes = new ArrayList<>();
            for (int firstColorNum = 1; firstColorNum <= colorCnt; firstColorNum++) {
                for (int secondColorNum = firstColorNum + 1; secondColorNum <= colorCnt; secondColorNum++) {
                    int contrast = calContrast(colors[firstColorNum], colors[secondColorNum]);
                    if (maxContrast < contrast) {
                        maxContrast = contrast;
                        maxContrastIndexes.clear();
                        maxContrastIndexes.add(new int[]{firstColorNum, secondColorNum});
                    } else if (maxContrast == contrast) {
                        maxContrastIndexes.add(new int[]{firstColorNum, secondColorNum});
                    }
                }
            }

            sb.append("Data Set ").append(tc).append(":\n");
            for (int i = 0; i < maxContrastIndexes.size(); i++) {
                sb.append(maxContrastIndexes.get(i)[0]).append(" ").append(maxContrastIndexes.get(i)[1]).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calContrast(Color a, Color b) {
        int rDiff = Math.abs(a.r - b.r);
        int gDiff = Math.abs(a.g - b.g);
        int bDiff = Math.abs(a.b - b.b);

        return rDiff * rDiff + gDiff * gDiff + bDiff * bDiff;
    }

    static class Color {
        int r, g, b;

        Color(StringTokenizer info) {
            this.r = Integer.parseInt(info.nextToken());
            this.g = Integer.parseInt(info.nextToken());
            this.b = Integer.parseInt(info.nextToken());
        }
    }
}
