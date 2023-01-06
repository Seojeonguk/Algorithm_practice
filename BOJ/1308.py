from datetime import datetime

t = datetime(*map(int, input().split()))
d = datetime(*map(int, input().split()))
m = d-t

print(f"D-{m.days}" if m.days < 365243 else "gg")