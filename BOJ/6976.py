for _ in range(int(input())):
    originalValue = int(input())
    value = originalValue

    while len(str(value)) > 2:
        print(value)
        lastDigit = value % 10
        value = value // 10 - lastDigit
        
    print(value)

    if value == 11: print(f'The number {originalValue} is divisible by 11.')
    else: print(f'The number {originalValue} is not divisible by 11.')
    print()
