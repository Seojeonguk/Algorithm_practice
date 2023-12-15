import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            sb.append(0).append(" ").append(0).append(" ").append(0);
        } else if (n == 1) {
            sb.append(0).append(" ").append(0).append(" ").append(1);
        } else if (n == 2) {
            sb.append(0).append(" ").append(1).append(" ").append(1);
        } else if (n == 3) {
            sb.append(1).append(" ").append(1).append(" ").append(1);
        } else if (n == 4) {
            sb.append(0);
        } else if (n == 5) {
            sb.append(0);
        } else if (n == 6) {
            sb.append(-1).append(" ").append(-1).append(" ").append(2);
        } else if (n == 7) {
            sb.append(0).append(" ").append(-1).append(" ").append(2);
        } else if (n == 8) {
            sb.append(0).append(" ").append(0).append(" ").append(2);
        } else if (n == 9) {
            sb.append(0).append(" ").append(1).append(" ").append(2);
        } else if (n == 10) {
            sb.append(1).append(" ").append(1).append(" ").append(2);
        } else if (n == 11) {
            sb.append(-2).append(" ").append(-2).append(" ").append(3);
        } else if (n == 12) {
            sb.append(7).append(" ").append(10).append(" ").append(-11);
        } else if (n == 13) {
            sb.append(0);
        } else if (n == 14) {
            sb.append(0);
        } else if (n == 15) {
            sb.append(-1).append(" ").append(2).append(" ").append(2);
        } else if (n == 16) {
            sb.append(-511).append(" ").append(-1609).append(" ").append(1626);
        } else if (n == 17) {
            sb.append(1).append(" ").append(2).append(" ").append(2);
        } else if (n == 18) {
            sb.append(-1).append(" ").append(-2).append(" ").append(3);
        } else if (n == 19) {
            sb.append(0).append(" ").append(-2).append(" ").append(3);
        } else if (n == 20) {
            sb.append(1).append(" ").append(-2).append(" ").append(3);
        } else if (n == 21) {
            sb.append(-11).append(" ").append(-14).append(" ").append(16);
        } else if (n == 22) {
            sb.append(0);
        } else if (n == 23) {
            sb.append(0);
        } else if (n == 24) {
            sb.append(-2901096694L).append(" ").append(-15550555555L).append(" ").append(15584139827L);
        } else if (n == 25) {
            sb.append(-1).append(" ").append(-1).append(" ").append(3);
        } else if (n == 26) {
            sb.append(0).append(" ").append(-1).append(" ").append(3);
        } else if (n == 27) {
            sb.append(0).append(" ").append(0).append(" ").append(3);
        } else if (n == 28) {
            sb.append(0).append(" ").append(1).append(" ").append(3);
        } else if (n == 29) {
            sb.append(1).append(" ").append(1).append(" ").append(3);
        } else if (n == 30) {
            sb.append(-283059965).append(" ").append(-2218888517L).append(" ").append(2220422932L);
        } else if (n == 31) {
            sb.append(0);
        } else if (n == 32) {
            sb.append(0);
        } else if (n == 33) {
            sb.append(8866128975287528L).append(" ").append(-8778405442862239L).append(" ").append(-2736111468807040L);
        } else if (n == 34) {
            sb.append(-1).append(" ").append(2).append(" ").append(3);
        } else if (n == 35) {
            sb.append(0).append(" ").append(2).append(" ").append(3);
        } else if (n == 36) {
            sb.append(1).append(" ").append(2).append(" ").append(3);
        } else if (n == 37) {
            sb.append(0).append(" ").append(-3).append(" ").append(4);
        } else if (n == 38) {
            sb.append(1).append(" ").append(-3).append(" ").append(4);
        } else if (n == 39) {
            sb.append(117367).append(" ").append(134476).append(" ").append(-159380);
        } else if (n == 40) {
            sb.append(0);
        } else if (n == 41) {
            sb.append(0);
        } else if (n == 42) {
            sb.append(-80538738812075974L).append(" ").append(80435758145817515L).append(" ").append(12602123297335631L);
        } else if (n == 43) {
            sb.append(2).append(" ").append(2).append(" ").append(3);
        } else if (n == 44) {
            sb.append(-5).append(" ").append(-7).append(" ").append(8);
        } else if (n == 45) {
            sb.append(2).append(" ").append(-3).append(" ").append(4);
        } else if (n == 46) {
            sb.append(-2).append(" ").append(3).append(" ").append(3);
        } else if (n == 47) {
            sb.append(6).append(" ").append(7).append(" ").append(-8);
        } else if (n == 48) {
            sb.append(-23).append(" ").append(-26).append(" ").append(31);
        } else if (n == 49) {
            sb.append(0);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
