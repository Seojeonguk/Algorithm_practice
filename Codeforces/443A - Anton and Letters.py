letters = input()
letters = letters[1:-1]
letters = ", " + letters
letters = letters.split(', ')
print(len(set(letters))-1)
