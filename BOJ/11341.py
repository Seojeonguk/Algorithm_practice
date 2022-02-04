n=int(input())

vowel = "aeiouy"

for _ in range(n):
        latin = input().split()

        for text in latin:
                if text[0] in vowel:
                        print(text+"yay",end=' ')
                else:
                        y=0
                        for idx,x in enumerate(text):
                                if x in vowel:
                                        y=idx
                                        break
                        print(text[y:] + text[:y] + "ay",end=' ')
        print()
