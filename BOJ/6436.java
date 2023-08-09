import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int COMPRESS_SIZE = 1860000;

    public static void main(String[] args) throws Exception {
        for (int cases = 1; ; cases++) {
            int SHARFileSize = Integer.parseInt(br.readLine());
            if (SHARFileSize == 0) {
                break;
            }
            int compressedFileSize = SHARFileSize / 2 + (SHARFileSize % 2 == 1 ? 1 : 0);
            int encodedFileSize = compressedFileSize + compressedFileSize / 2 + (compressedFileSize % 2 == 1 ? 1 : 0);
            int neededFloppyCnt = (encodedFileSize + COMPRESS_SIZE - 1) / COMPRESS_SIZE;

            sb.append("File #").append(cases).append("\n");
            sb.append("John needs ").append(neededFloppyCnt).append(" floppies.\n\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
