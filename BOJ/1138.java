import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int personCnt = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Person[] persons = new Person[personCnt];
        for (int idx = 0; idx < personCnt; idx++) {
            int frontPersons = Integer.parseInt(st.nextToken());
            persons[idx] = new Person(frontPersons, idx + 1);
        }
        Arrays.sort(persons, Comparator.comparing(Person::getFrontPersons).thenComparing(Person::getReverseHeight));

        ArrayList<Integer> heights = new ArrayList<>();
        for (Person person : persons) {
            if (person.frontPersons == 0) {
                heights.add(0, person.height);
                continue;
            }
            for (int idx = 0, frontPerson = 0; idx < heights.size(); idx++) {
                if (heights.get(idx) > person.height) {
                    frontPerson++;
                    if (frontPerson >= person.frontPersons) {
                        heights.add(idx + 1, person.height);
                        break;
                    }
                }
            }
        }

        for (int height : heights) {
            sb.append(height).append(" ");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Person {
        int frontPersons;
        int height;

        Person(int frontPersons, int height) {
            this.frontPersons = frontPersons;
            this.height = height;
        }

        public int getFrontPersons() {
            return frontPersons;
        }

        public int getReverseHeight() {
            return -height;
        }
    }
}
