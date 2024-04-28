import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            String polynomial = br.readLine();
            String result = calIntegralResult(polynomial);
            if (!result.isEmpty()) {
                result += "+";
            }
            result += "W";

            sb.append(result);

            bw.write(sb.toString());
        }
    }

    public static String calIntegralResult(String polynomial) {
        String res = "";
        if (!polynomial.contains("x")) {
            int constant = Integer.parseInt(polynomial);
            if (constant != 0) {
                res += result(constant, false, false);
            }

            return res;
        }

        String[] split = polynomial.split("x");
        int coefficient = Integer.parseInt(split[0]) / 2;
        res += result(coefficient, false, true);

        if (split.length == 2) {
            int constant = Integer.parseInt(split[1]);
            if (constant != 0) {
                res += result(constant, true, false);
            }
        }

        return res;
    }

    public static String result(int value, boolean isFirst, boolean isCoefficient) {
        String ret = "";
        if (value < 0) {
            ret += "-";
        } else if (isFirst) {
            ret += "+";
        }

        ret += (Math.abs(value) == 1 ? "" : Math.abs(value));
        ret += (isCoefficient ? "xx" : "x");

        return ret;
    }
}
