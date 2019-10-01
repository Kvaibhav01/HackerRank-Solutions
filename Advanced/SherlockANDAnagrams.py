def is_angram(s1, s2):
    l1 = list(s1)
    l2 = list(s2)
    for i in l1:
        if i in l2:
            l2.remove(i)
        else:
            return False
    return True

def sub_string(s):
    n = len(s)
    count = 0
    for i in range(n):
        for j in range(i+1, n+1):
            x = i + 1
            y = j + 1
            while y != n+1:
                if is_angram(s[i:j], s[x:y]):
                    #print(s[i:j], s[x:y])
                    count += 1
                x += 1
                y += 1
    return count

s = input()

print(sub_string(s))
