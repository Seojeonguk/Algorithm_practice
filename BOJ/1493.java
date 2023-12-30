import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int boxLength = Integer.parseInt(st.nextToken());
        int boxWidth = Integer.parseInt(st.nextToken());
        int boxHeight = Integer.parseInt(st.nextToken());

        int totalCube = Integer.parseInt(br.readLine());
        Cube[] cubes = new Cube[totalCube];
        for (int i = 0; i < totalCube; i++) {
            st = new StringTokenizer(br.readLine());
            int power = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());

            cubes[i] = new Cube((1 << power), cnt);
        }

        Arrays.sort(cubes, Comparator.comparingInt(o -> o.length));

        long minCube = calRequiredMinCube(boxLength, boxWidth, boxHeight, cubes);
        sb.append(minCube);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static long calRequiredMinCube(int boxLength, int boxWidth, int boxHeight, Cube[] cubes) {
        long requiredMinCube = 0;
        long currentUsedCube = 0;

        for (int i = cubes.length - 1; i >= 0; i--) {
            currentUsedCube <<= 3;

            long possibleUseCube = (long) (boxLength >> i) * (boxWidth >> i) * (boxHeight >> i) - currentUsedCube;
            long addUsedCube = Math.min(cubes[i].cnt, possibleUseCube);

            currentUsedCube += addUsedCube;
            requiredMinCube += addUsedCube;
        }

        return (long) boxLength * boxWidth * boxHeight == currentUsedCube ? requiredMinCube : -1;
    }

    static class Cube {
        int length, cnt;

        Cube(int length, int cnt) {
            this.length = length;
            this.cnt = cnt;
        }
    }
}
