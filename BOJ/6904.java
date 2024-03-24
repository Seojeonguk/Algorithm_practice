import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            int smallestPerimeter = Integer.MAX_VALUE;
            int smallestPerimeterLength = 0;

            for (int length = 1; length * length <= n; length++) {
                if (n % length > 0) {
                    continue;
                }
                int anotherLength = n / length;
                int perimeter = (length + anotherLength) * 2;
                if (smallestPerimeter > perimeter) {
                    smallestPerimeter = perimeter;
                    smallestPerimeterLength = length;
                }
            }

            sb.append(String.format("Minimum perimeter is %d with dimensions %d x %d\n", smallestPerimeter, smallestPerimeterLength, n / smallestPerimeterLength));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
