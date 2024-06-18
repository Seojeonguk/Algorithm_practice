import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int peopleCnt = Integer.parseInt(br.readLine());
            People[] people = new People[peopleCnt];
            for (int peopleNum = 0; peopleNum < peopleCnt; peopleNum++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                int score = Integer.parseInt(st.nextToken());

                people[peopleNum] = new People(name, score);
            }

            Arrays.sort(people, (o1, o2) -> {
                if (o1.score == o2.score) {
                    return o1.name.compareTo(o2.name);
                }
                return Integer.compare(o2.score, o1.score);
            });

            sb.append(people[0].name);

            bw.write(sb.toString());
        }
    }

    static class People {
        String name;
        int score;

        public People(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
}
