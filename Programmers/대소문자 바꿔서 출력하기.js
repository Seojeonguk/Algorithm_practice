import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        char[] str = a.toCharArray();
        for(char c : str) {
            System.out.print(Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c));
        }
    }
}