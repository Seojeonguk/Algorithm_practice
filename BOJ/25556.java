import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int arrLength = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            sb.append(validateClean(arr) ? "YES" : "NO");

            bw.write(sb.toString());
        }
    }

    public static boolean validateClean(int[] arr) {
        Stack<Integer>[] stacks = new Stack[4];
        for (int i = 0; i < 4; i++) {
            stacks[i] = new Stack<>();
        }

        for (int idx = 0; idx < arr.length; idx++) {
            boolean isPush = false;
            for (int i = 0; i < 4; i++) {
                if (stacks[i].empty()) {
                    stacks[i].push(arr[idx]);
                    isPush = true;
                    break;
                }
                
                if (stacks[i].peek() < arr[idx]) {
                    stacks[i].push(arr[idx]);
                    isPush = true;
                    break;
                }
            }

            if (!isPush) {
                return false;
            }
        }

        return true;
    }
}
