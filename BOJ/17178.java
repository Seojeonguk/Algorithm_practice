import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class Main {

    static final int PERSON_PER_LINE = 5;

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int lineCnt = Integer.parseInt(br.readLine());

            Person[][] persons = new Person[lineCnt][PERSON_PER_LINE];
            for (int line = 0; line < lineCnt; line++) {
                String[] lines = br.readLine().split(" ");

                for (int lineNum = 0; lineNum < PERSON_PER_LINE; lineNum++) {
                    persons[line][lineNum] = new Person(lines[lineNum]);
                }
            }

            sb.append(isEnterSafely(persons) ? "GOOD" : "BAD");

            bw.write(sb.toString());
        }
    }

    public static boolean isEnterSafely(Person[][] persons) {
        PriorityQueue<Person> sortedPersons = new PriorityQueue<>((o1, o2) -> {
            if (o1.c == o2.c) {
                return Integer.compare(o1.num, o2.num);
            }
            return Character.compare(o1.c, o2.c);
        });

        for (Person[] line : persons) {
            sortedPersons.addAll(Arrays.asList(line));
        }

        Stack<Person> waitingPersons = new Stack<>();
        for (Person[] line : persons) {
            for (Person person : line) {
                if (!sortedPersons.peek().equals(person)) {
                    waitingPersons.add(person);
                } else {
                    sortedPersons.poll();
                }

                while (!waitingPersons.empty()) {
                    if (waitingPersons.peek().equals(sortedPersons.peek())) {
                        waitingPersons.pop();
                        sortedPersons.poll();
                    } else {
                        break;
                    }
                }
            }
        }

        return waitingPersons.empty();
    }

    static class Person {
        char c;
        int num;

        Person(String s) {
            String[] split = s.split("-");

            this.c = split[0].charAt(0);
            this.num = Integer.parseInt(split[1]);
        }

        public boolean equals(Person p) {
            return this.c == p.c && this.num == p.num;
        }
    }
}
