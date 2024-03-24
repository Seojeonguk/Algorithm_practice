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
        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());

        char[][] tables = new char[rowSize][colSize];
        for (int row = 0; row < rowSize; row++) {
            tables[row] = br.readLine().toCharArray();
        }

        int l = 0, r = rowSize;
        while (l <= r) {
            int mid = (l + r) / 2;

            if (existSameString(tables, rowSize, colSize, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        sb.append(l);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean existSameString(char[][] tables, int r, int c, int mid) {
        for (int i = 0; i < c; i++) {
            for (int j = i + 1; j < c; j++) {
                if (isSame(tables, r, mid, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isSame(char[][] tables, int r, int mid, int a, int b) {
        for (int x = mid + 1; x < r; x++) {
            if (tables[x][a] != tables[x][b]) {
                return false;
            }
        }

        return true;
    }
}
