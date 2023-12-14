import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            int[] firstTriangles = new int[3];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) {
                firstTriangles[i] = Integer.parseInt(st.nextToken());
            }

            int[] secondTriangles = new int[3];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) {
                secondTriangles[i] = Integer.parseInt(st.nextToken());
            }

            boolean isRightFirstTriangle = isRightTriangle(firstTriangles);
            boolean isRightSecondTriangle = isRightTriangle(secondTriangles);
            boolean isSameLength = isSameLength(firstTriangles, secondTriangles);

            sb.append(isRightFirstTriangle && isRightSecondTriangle && isSameLength ? "YES" : "NO").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isRightTriangle(int[] triangles) {
        Arrays.sort(triangles);

        return (triangles[0] * triangles[0] + triangles[1] * triangles[1] == triangles[2] * triangles[2]);
    }

    public static boolean isSameLength(int[] t1, int[] t2) {
        for (int i = 0; i < t1.length; i++) {
            if (t1[i] != t2[i]) {
                return false;
            }
        }
        return true;
    }
}
