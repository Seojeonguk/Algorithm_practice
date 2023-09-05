import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int PICTURE_ROW_SIZE = 5;
    final static int PICTURE_COL_SIZE = 7;

    public static void main(String[] args) throws Exception {
        int pictureCnt = Integer.parseInt(br.readLine());
        char[][][] pictures = new char[pictureCnt][PICTURE_ROW_SIZE][PICTURE_COL_SIZE];

        for (int picture = 0; picture < pictureCnt; picture++) {
            for (int row = 0; row < PICTURE_ROW_SIZE; row++) {
                pictures[picture][row] = br.readLine().toCharArray();
            }
        }

        int minDiffSpace = PICTURE_ROW_SIZE * PICTURE_COL_SIZE + 1;
        int similarPicA = 0, similarPicB = 0;
        for (int aPic = 0; aPic < pictureCnt; aPic++) {
            for (int bPic = aPic + 1; bPic < pictureCnt; bPic++) {
                int diffSpace = 0;
                for (int row = 0; row < PICTURE_ROW_SIZE; row++) {
                    for (int col = 0; col < PICTURE_COL_SIZE; col++) {
                        diffSpace += (pictures[aPic][row][col] == pictures[bPic][row][col] ? 0 : 1);
                    }
                }
                if (minDiffSpace > diffSpace) {
                    minDiffSpace = diffSpace;
                    similarPicA = aPic;
                    similarPicB = bPic;
                }
            }
        }

        sb.append(similarPicA + 1).append(" ").append(similarPicB + 1);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
