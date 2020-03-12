t=int(input())
chk = [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
for tc in range(t):
        line = input().split()
        print("Case %d:"%(tc+1),end=" ")
        for h in line:
                print(chr(chk.index(h)+ord("A")),end='')
        print()
