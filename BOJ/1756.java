import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        int ovenDepth = Integer.parseInt(st.nextToken());
        int pizzaCnt = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] ovenDiameters = new int[ovenDepth + 1];
        for (int i = 1; i <= ovenDepth; i++) {
            ovenDiameters[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] pizzaDiameters = new int[pizzaCnt];
        for (int i = 0; i < pizzaCnt; i++) {
            pizzaDiameters[i] = Integer.parseInt(st.nextToken());
        }

        int lastPizzaLocation = getLastPizzaLocation(ovenDiameters, pizzaDiameters);


        sb.append(lastPizzaLocation);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getLastPizzaLocation(int[] ovenDiameters, int[] pizzaDiameters) {
        if (ovenDiameters.length < pizzaDiameters.length) {
            return 0;
        }

        int[] minOvenDiameters = new int[ovenDiameters.length];
        minOvenDiameters[0] = Integer.MAX_VALUE;
        for (int i = 1; i < ovenDiameters.length; i++) {
            minOvenDiameters[i] = Math.min(minOvenDiameters[i - 1], ovenDiameters[i]);
        }

        int lastPizza = ovenDiameters.length;
        for (int pizzaDiameter : pizzaDiameters) {
            int idx = binarySearch(minOvenDiameters, 1, lastPizza, pizzaDiameter);
            lastPizza = idx - 1;
        }

        return lastPizza;
    }

    public static int binarySearch(int[] minOvenDiameters, int start, int end, int key) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (minOvenDiameters[mid] >= key) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }
}
