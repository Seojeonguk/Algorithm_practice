import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int people = Integer.parseInt(br.readLine());
        while (people-- > 0) {
            st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            double BMI = 1.0f * weight / ((0.01f * height) * (0.01f * height));

            int grade = 0;
            if (height <= 140) {
                grade = 6;
            } else if (height < 146) {
                grade = 5;
            } else if (height < 159) {
                grade = 4;
            } else if (height < 161) {
                if (16.0f <= BMI && BMI < 35.0f) {
                    grade = 3;
                } else {
                    grade = 4;
                }
            } else if (height < 204) {
                if (BMI < 16.0f || BMI >= 35.0f) {
                    grade = 4;
                } else if (BMI < 18.5f || BMI >= 30.0f) {
                    grade = 3;
                } else if (BMI < 20.f || BMI >= 25.0f) {
                    grade = 2;
                } else {
                    grade = 1;
                }
            } else {
                grade = 4;
            }
            sb.append(grade).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
