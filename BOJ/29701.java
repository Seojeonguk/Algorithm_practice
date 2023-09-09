import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static Map<String, String> MORSE_CODE = Map.ofEntries(
            new AbstractMap.SimpleEntry<>(".-", "A"),
            new AbstractMap.SimpleEntry<>("-...", "B"),
            new AbstractMap.SimpleEntry<>("-.-.", "C"),
            new AbstractMap.SimpleEntry<>("-..", "D"),
            new AbstractMap.SimpleEntry<>(".", "E"),
            new AbstractMap.SimpleEntry<>("..-.", "F"),
            new AbstractMap.SimpleEntry<>("--.", "G"),
            new AbstractMap.SimpleEntry<>("....", "H"),
            new AbstractMap.SimpleEntry<>("..", "I"),
            new AbstractMap.SimpleEntry<>(".---", "J"),
            new AbstractMap.SimpleEntry<>("-.-", "K"),
            new AbstractMap.SimpleEntry<>(".-..", "L"),
            new AbstractMap.SimpleEntry<>("--", "M"),
            new AbstractMap.SimpleEntry<>("-.", "N"),
            new AbstractMap.SimpleEntry<>("---", "O"),
            new AbstractMap.SimpleEntry<>(".--.", "P"),
            new AbstractMap.SimpleEntry<>("--.-", "Q"),
            new AbstractMap.SimpleEntry<>(".-.", "R"),
            new AbstractMap.SimpleEntry<>("...", "S"),
            new AbstractMap.SimpleEntry<>("-", "T"),
            new AbstractMap.SimpleEntry<>("..-", "U"),
            new AbstractMap.SimpleEntry<>("...-", "V"),
            new AbstractMap.SimpleEntry<>(".--", "W"),
            new AbstractMap.SimpleEntry<>("-..-", "X"),
            new AbstractMap.SimpleEntry<>("-.--", "Y"),
            new AbstractMap.SimpleEntry<>("--..", "Z"),
            new AbstractMap.SimpleEntry<>(".----", "1"),
            new AbstractMap.SimpleEntry<>("..---", "2"),
            new AbstractMap.SimpleEntry<>("...--", "3"),
            new AbstractMap.SimpleEntry<>("....-", "4"),
            new AbstractMap.SimpleEntry<>(".....", "5"),
            new AbstractMap.SimpleEntry<>("-....", "6"),
            new AbstractMap.SimpleEntry<>("--...", "7"),
            new AbstractMap.SimpleEntry<>("---..", "8"),
            new AbstractMap.SimpleEntry<>("----.", "9"),
            new AbstractMap.SimpleEntry<>("-----", "0"),
            new AbstractMap.SimpleEntry<>("--..--", ","),
            new AbstractMap.SimpleEntry<>(".-.-.-", "."),
            new AbstractMap.SimpleEntry<>("..--..", "?"),
            new AbstractMap.SimpleEntry<>("---...", ":"),
            new AbstractMap.SimpleEntry<>("-....-", "-"),
            new AbstractMap.SimpleEntry<>(".--.-.", "@")
    );

    public static void main(String[] args) throws Exception {
        int morseLength = Integer.parseInt(br.readLine());
        String[] morseCodes = br.readLine().split(" ");
        for (String morse : morseCodes) {
            sb.append(MORSE_CODE.get(morse));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
