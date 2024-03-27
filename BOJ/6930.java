import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int x = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int modularInverse = calModularInverse(x, m);
        if (modularInverse == -1) {
            sb.append("No such integer exists.");
        } else {
            sb.append(modularInverse);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calModularInverse(int x, int m) {
        HashSet<Integer> remainders = new HashSet<>();
        for (int multiple = 1; ; multiple++) {
            int remainder = (x * multiple) % m;
            if (remainders.contains(remainder)) {
                break;
            }
            if (remainder == 1) {
                return multiple;
            }
            remainders.add(remainder);
        }

        return -1;
    }
}
