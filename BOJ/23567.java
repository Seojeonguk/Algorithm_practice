import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int pointCnt = Integer.parseInt(st.nextToken());
            int colorCnt = Integer.parseInt(st.nextToken());

            int[] colors = new int[pointCnt];
            int[] pColors = new int[colorCnt + 1];
            int pColorCnt = 0;
            for (int pointNum = 0; pointNum < pointCnt; pointNum++) {
                colors[pointNum] = Integer.parseInt(br.readLine());
                if (pColors[colors[pointNum]] == 0) {
                    pColorCnt++;
                }

                pColors[colors[pointNum]]++;
            }

            int left = 0;
            int[] qColors = new int[colorCnt + 1];
            int qColorCnt = 0;
            int minDoubleRainbowSize = Integer.MAX_VALUE;

            for (int right = 0; right < pointCnt; right++) {
                int rightColor = colors[right];
                if (qColors[rightColor] == 0) {
                    qColorCnt++;
                }

                qColors[rightColor]++;
                pColors[rightColor]--;

                if (pColors[rightColor] == 0) {
                    pColorCnt--;
                }

                while (qColorCnt == colorCnt) {
                    if (pColorCnt == colorCnt) {
                        minDoubleRainbowSize = Math.min(minDoubleRainbowSize, right - left + 1);
                    }

                    int leftColor = colors[left++];
                    qColors[leftColor]--;
                    if (qColors[leftColor] == 0) {
                        qColorCnt--;
                    }

                    if (pColors[leftColor] == 0) {
                        pColorCnt++;
                    }
                    pColors[leftColor]++;
                }
            }

            sb.append(minDoubleRainbowSize == Integer.MAX_VALUE ? 0 : minDoubleRainbowSize);

            bw.write(sb.toString());
        }
    }
}
