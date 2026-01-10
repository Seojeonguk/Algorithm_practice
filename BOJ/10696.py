for tc in range(int(input())):
    funds, teams = map(int, input().split(" "))
    print(f'Case {tc+1}: {funds%teams}')