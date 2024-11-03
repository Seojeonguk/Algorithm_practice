import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int foodCnt = Integer.parseInt(br.readLine());
            char[] foods = br.readLine().toCharArray();

            sb.append(getAns(foods));

            bw.write(sb.toString());
        }
    }

    public static int getAns(char[] foods) {
        for (int i = 0; i < foods.length - 1; i++) {
            int leftBread = 0;
            int leftOnion = 0;

            for (int j = 0; j <= i; j++) {
                if (foods[j] == 'L') {
                    leftBread++;
                } else if (foods[j] == 'O') {
                    leftOnion++;
                }
            }

            int rightBread = 0;
            int rightOnion = 0;
            for (int j = i + 1; j < foods.length; j++) {
                if (foods[j] == 'L') {
                    rightBread++;
                } else if (foods[j] == 'O') {
                    rightOnion++;
                }
            }

            if (leftBread != rightBread && leftOnion != rightOnion) {
                return i + 1;
            }
        }

        return -1;
    }
}
