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
            String equation = br.readLine();
            String[] equationSplits = equation.split("[+=]");
            int[] reverseEquation = reverse(equationSplits);

            sb.append(reverseEquation[0] + reverseEquation[1] == reverseEquation[2] ? "True" : "False").append("\n");
            if ("0+0=0".equals(equation)) {
                break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int[] reverse(String[] equations) {
        int[] arr = new int[equations.length];
        for (int i = 0; i < equations.length; i++) {
            arr[i] = Integer.parseInt(new StringBuilder(equations[i]).reverse().toString());
        }

        return arr;
    }
}
