import hashlib
sha = hashlib.new('ripemd160')
sha.update(input().encode())
print(sha.hexdigest())
