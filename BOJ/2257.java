import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.Stack;

public class Main {

    static final Map<Character, Integer> CHEMICAL = Map.of(
            'H', 1,
            'C', 12,
            'O', 16
    );

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            char[] chemicalFormula = br.readLine().toCharArray();
            Stack<Integer> stack = new Stack<>();

            for (char c : chemicalFormula) {
                if (c == '(') {
                    stack.push(-1);
                } else if (c == ')') {
                    int sum = 0;
                    while (!stack.isEmpty()) {
                        int top = stack.pop();
                        if (top == -1) {
                            break;
                        }
                        sum += top;
                    }
                    stack.push(sum);
                } else if (Character.isDigit(c)) {
                    if (!stack.isEmpty()) {
                        int top = stack.pop();
                        int multiple = c - '0';

                        stack.push(top * multiple);
                    }
                } else {
                    stack.push(CHEMICAL.get(c));
                }
            }

            int sum = 0;
            while (!stack.isEmpty()) {
                sum += stack.pop();
            }

            sb.append(sum);

            bw.write(sb.toString());
        }
    }
}
