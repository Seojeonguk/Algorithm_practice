import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int addedCnt, totalSpiciness;
    static String addedPepper;

    public static void main(String[] args) throws Exception {
        Map<String, Integer> peppers = Map.of(
                "Poblano", 1500,
                "Mirasol", 6000,
                "Serrano", 15500,
                "Cayenne", 40000,
                "Thai", 75000,
                "Habanero", 125000
        );

        addedCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < addedCnt; i++) {
            addedPepper = br.readLine();
            totalSpiciness += peppers.get(addedPepper);
        }
        sb.append(totalSpiciness);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
