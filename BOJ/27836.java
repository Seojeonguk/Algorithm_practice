import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= testCase; tc++) {
            br.readLine();
            StringTokenizer studentInfo = new StringTokenizer(br.readLine());
            int csStudentCnt = Integer.parseInt(studentInfo.nextToken());
            int eStudentCnt = Integer.parseInt(studentInfo.nextToken());

            int[] csStudentIQs = new int[csStudentCnt];
            long csStudentIQSum = 0;
            StringTokenizer computerScienceStudentIQInfo = new StringTokenizer(br.readLine());
            for (int studentNum = 0; studentNum < csStudentCnt; studentNum++) {
                csStudentIQs[studentNum] = Integer.parseInt(computerScienceStudentIQInfo.nextToken());
                csStudentIQSum += csStudentIQs[studentNum];
            }

            int[] eStudentIQs = new int[eStudentCnt];
            long eStudentIQSum = 0;
            StringTokenizer economicStudentIQInfo = new StringTokenizer(br.readLine());
            for (int studentNum = 0; studentNum < eStudentCnt; studentNum++) {
                eStudentIQs[studentNum] = Integer.parseInt(economicStudentIQInfo.nextToken());
                eStudentIQSum += eStudentIQs[studentNum];
            }

            int profitablePersonCnt = 0;
            for (int i = 0; i < csStudentCnt; i++) {
                if ((long) csStudentIQs[i] * csStudentCnt < csStudentIQSum && (long) csStudentIQs[i] * eStudentCnt > eStudentIQSum) {
                    profitablePersonCnt++;
                }
            }

            sb.append(profitablePersonCnt).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
