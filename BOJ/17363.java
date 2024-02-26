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

        StringTokenizer picInfo = new StringTokenizer(br.readLine());
        int rowSize = Integer.parseInt(picInfo.nextToken());
        int colSize = Integer.parseInt(picInfo.nextToken());

        char[][] pictures = new char[rowSize][colSize];

        for (int row = 0; row < rowSize; row++) {
            pictures[row] = br.readLine().toCharArray();
        }

        for (int col = colSize - 1; col >= 0; col--) {
            for (int row = 0; row < rowSize; row++) {
                sb.append(convert(pictures[row][col]));
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static char convert(char c) {
        char ret = 0;
        if (c == '.') {
            ret = '.';
        } else if (c == 'O') {
            ret = 'O';
        } else if (c == '-') {
            ret = '|';
        } else if (c == '|') {
            ret = '-';
        } else if (c == '/') {
            ret = '\\';
        } else if (c == '\\') {
            ret = '/';
        } else if (c == '^') {
            ret = '<';
        } else if (c == '<') {
            ret = 'v';
        } else if (c == 'v') {
            ret = '>';
        } else if (c == '>') {
            ret = '^';
        }

        return ret;
    }
}
