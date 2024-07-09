import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            Exam exam = new Exam();
            exam.setStudentCnt(br.readLine());
            exam.setScores(br.readLine());
            exam.setRestInfo(br.readLine());

            sb.append(exam.getRelativeA()).append(" ").append(exam.getAbsoluteA());

            bw.write(sb.toString());
        }
    }

    static class Exam {
        int studentCnt;
        int[] scores;
        int AGradeRatio;
        int AMinScore;

        private StringTokenizer nextLine(String nextLine) {
            return new StringTokenizer(nextLine);
        }

        public void setStudentCnt(String nextLine) {
            this.studentCnt = Integer.parseInt(this.nextLine(nextLine).nextToken());
            this.scores = new int[studentCnt];
        }

        public void setScores(String nextLine) {
            StringTokenizer st = this.nextLine(nextLine);
            for (int i = 0; i < this.studentCnt; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
            }
        }

        public void setRestInfo(String nextLine) {
            StringTokenizer st = this.nextLine(nextLine);
            this.AGradeRatio = Integer.parseInt(st.nextToken());
            this.AMinScore = Integer.parseInt(st.nextToken());
        }

        public int getRelativeA() {
            return this.studentCnt * this.AGradeRatio / 100;
        }

        public int getAbsoluteA() {
            int absoluteA = 0;
            for (int i = 0; i < this.studentCnt; i++) {
                if (this.scores[i] >= this.AMinScore) {
                    absoluteA++;
                }
            }

            return absoluteA;
        }
    }
}
