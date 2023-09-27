import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static TreeMap<String, Integer> GRADES = new TreeMap<>(Comparator.reverseOrder()) {{
        put("F", 0);
        put("D0", 100);
        put("D+", 150);
        put("C0", 200);
        put("C+", 250);
        put("B0", 300);
        put("B+", 350);
        put("A0", 400);
        put("A+", 450);
    }};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int subjectCnt = Integer.parseInt(st.nextToken());
        String[] s = st.nextToken().split("\\.");
        int minAverageGrade = Integer.parseInt(s[0]) * 100 + Integer.parseInt(s[1]);
        int sumGrade = 0, sumCredit = 0;

        for (int i = 0; i < subjectCnt - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int credit = Integer.parseInt(st.nextToken());
            String grade = st.nextToken();

            sumGrade += GRADES.get(grade) * credit;
            sumCredit += credit;
        }

        int lastCredit = Integer.parseInt(br.readLine());
        sumCredit += lastCredit;

        String ans = "";
        Iterator<String> it = GRADES.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            int totalGrade = sumGrade + GRADES.get(key) * lastCredit;
            int grade = totalGrade / sumCredit;

            if (grade > minAverageGrade) {
                ans = key;
                break;
            }
        }

        sb.append("".equals(ans) ? "impossible" : ans);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
