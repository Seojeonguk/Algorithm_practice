import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int TOTAL_SEMINAR = 7;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            Seminar[] seminars = new Seminar[TOTAL_SEMINAR];
            for (int seminarNum = 0; seminarNum < TOTAL_SEMINAR; seminarNum++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                int student = Integer.parseInt(st.nextToken());
                seminars[seminarNum] = new Seminar(name, student);
            }

            Arrays.sort(seminars, (o1, o2) -> Integer.compare(o2.student, o1.student));

            sb.append(seminars[0].name);

            bw.write(sb.toString());
        }
    }

    static class Seminar {
        String name;
        int student;

        public Seminar(String name, int student) {
            this.name = name;
            this.student = student;
        }
    }
}
