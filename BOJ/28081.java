import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int pizzaWidth = Integer.parseInt(st.nextToken());
            int pizzaHeight = Integer.parseInt(st.nextToken());
            long staffEdibleMaxSize = Long.parseLong(st.nextToken());

            int[] horizontalCuts = writeCutInfo(br, pizzaHeight);
            int[] verticalCuts = writeCutInfo(br, pizzaWidth);

            sb.append(calDividePizzaPiece(staffEdibleMaxSize, horizontalCuts, verticalCuts));

            bw.write(sb.toString());
        }
    }

    public static int[] writeCutInfo(BufferedReader br, int last) throws IOException {
        int cuttingCnt = Integer.parseInt(br.readLine());
        int[] cutting = new int[cuttingCnt + 2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= cuttingCnt; i++) {
            cutting[i] = Integer.parseInt(st.nextToken());
        }
        cutting[cuttingCnt + 1] = last;
        return cutting;
    }

    public static long calDividePizzaPiece(long maxSize, int[] horizontalCuts, int[] verticalCuts) {
        int[] diffHorizontalCuts = new int[horizontalCuts.length - 1];
        for (int i = 0; i < horizontalCuts.length - 1; i++) {
            diffHorizontalCuts[i] = Math.abs(horizontalCuts[i] - horizontalCuts[i + 1]);
        }

        int[] diffVerticalCuts = new int[verticalCuts.length - 1];
        for (int i = 0; i < verticalCuts.length - 1; i++) {
            diffVerticalCuts[i] = Math.abs(verticalCuts[i] - verticalCuts[i + 1]);
        }

        Arrays.sort(diffHorizontalCuts);
        Arrays.sort(diffVerticalCuts);

        long dividePizzaPiece = 0;

        int diffVerticalIdx = diffVerticalCuts.length - 1;
        for (int diffHorizontalCut : diffHorizontalCuts) {
            while (diffVerticalIdx >= 0 && (long) diffHorizontalCut * diffVerticalCuts[diffVerticalIdx] > maxSize) {
                diffVerticalIdx--;
            }

            dividePizzaPiece += diffVerticalIdx + 1;
        }

        return dividePizzaPiece;
    }
}
