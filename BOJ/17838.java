import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int testCase = Integer.parseInt(br.readLine());
            for (int tc = 0; tc < testCase; tc++) {
                char[] commands = br.readLine().toCharArray();

                sb.append(isLikeCommands(commands) ? 1 : 0).append("\n");
            }

            bw.write(sb.toString());
        }
    }

    public static boolean isLikeCommands(char[] commands) {
        if (commands.length != 7) {
            return false;
        }

        HashSet<Character> s = new HashSet<>();
        for (char c : commands) {
            s.add(c);
        }

        if (s.size() != 2) {
            return false;
        }

        if (commands[0] != commands[1] || commands[1] != commands[4]) {
            return false;
        }

        if (commands[2] != commands[3] || commands[3] != commands[5] || commands[5] != commands[6]) {
            return false;
        }

        return commands[0] != commands[2];
    }
}
