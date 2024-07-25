import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int rowSize = Integer.parseInt(br.readLine());
            int colSize = Integer.parseInt(br.readLine());

            int satisfiedCaseCnt = calSatisfiedCaseCnt(rowSize, colSize);
            sb.append(satisfiedCaseCnt);

            bw.write(sb.toString());
        }
    }

    public static int calSatisfiedCaseCnt(int rowSize, int colSize) {
        if (rowSize == 1 || colSize == 1) {
            return 0;
        }

        return (rowSize - 1) * 2 * (colSize - 1);
    }
}
