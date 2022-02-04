import hashlib
sha = hashlib.new('sha')
sha.update(input().encode())
print(sha.hexdigest())
