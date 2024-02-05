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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int firstRingOutsideRadius = Integer.parseInt(st.nextToken());
        int firstRingInsideRadius = Integer.parseInt(st.nextToken());

        int secondRingOutsideRadius = Integer.parseInt(st.nextToken());
        int secondRingInsideRadius = Integer.parseInt(st.nextToken());

        int plateRadius = Integer.parseInt(st.nextToken());

        boolean canMakeTwoRings = validateTwoRings(firstRingOutsideRadius, firstRingInsideRadius, secondRingOutsideRadius, secondRingInsideRadius, plateRadius);
        sb.append(canMakeTwoRings ? "Yes" : "No");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean validateTwoRings(int firstRingOutsideRadius, int firstRingInsideRadius, int secondRingOutsideRadius, int secondRingInsideRadius, int plateRadius) {
        if (Math.max(firstRingOutsideRadius, secondRingOutsideRadius) > plateRadius) {
            return false;
        }

        if (firstRingOutsideRadius + secondRingOutsideRadius <= plateRadius) {
            return true;
        }

        int[][] rings = new int[2][2];
        if (firstRingOutsideRadius > secondRingOutsideRadius) {
            rings[0][0] = firstRingOutsideRadius;
            rings[0][1] = firstRingInsideRadius;

            rings[1][0] = secondRingOutsideRadius;
            rings[1][1] = secondRingInsideRadius;
        } else {
            rings[0][0] = secondRingOutsideRadius;
            rings[0][1] = secondRingInsideRadius;

            rings[1][0] = firstRingOutsideRadius;
            rings[1][1] = firstRingInsideRadius;
        }

        return (rings[0][1] >= rings[1][0]);
    }
}
