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
        for (int tc = 0; tc < testCase; tc++) {
            char[] companyName = br.readLine().toCharArray();

            int[] keypadNums = convertKeypadNums(companyName);
            boolean isPalindrome = validatePalindrome(keypadNums);
            sb.append(isPalindrome ? "YES" : "NO").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int[] convertKeypadNums(char[] companyName) {
        int[] keypads = new int[companyName.length];
        for (int i = 0; i < companyName.length; i++) {
            char upperC = Character.toUpperCase(companyName[i]);
            keypads[i] = convertKeypad(upperC);
        }

        return keypads;
    }

    public static int convertKeypad(char c) {
        int keypad = -1;
        if (c == 'A' || c == 'B' || c == 'C') {
            keypad = 2;
        } else if (c == 'D' || c == 'E' || c == 'F') {
            keypad = 3;
        } else if (c == 'G' || c == 'H' || c == 'I') {
            keypad = 4;
        } else if (c == 'J' || c == 'K' || c == 'L') {
            keypad = 5;
        } else if (c == 'M' || c == 'N' || c == 'O') {
            keypad = 6;
        } else if (c == 'P' || c == 'Q' || c == 'R' || c == 'S') {
            keypad = 7;
        } else if (c == 'T' || c == 'U' || c == 'V') {
            keypad = 8;
        } else if (c == 'W' || c == 'X' || c == 'Y' || c == 'Z') {
            keypad = 9;
        }

        return keypad;
    }

    public static boolean validatePalindrome(int[] keypads) {
        for (int i = 0; i < keypads.length / 2; i++) {
            if (keypads[i] != keypads[keypads.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
