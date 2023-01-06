from datetime import *
today = datetime.strptime(input(), '%B %d, %Y %H:%M')
thisYear = datetime(today.year,1,1)
print((today-thisYear)/(datetime(today.year+1,1,1)-thisYear)*100)