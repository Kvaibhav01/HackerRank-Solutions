def rotate(A, target, index, n):
    while target != index+1:
        if index > 1:
            print(index, target)
            temp = A[index-2]
            for i in range(index-2, index):
                A[i] = A[i+1]
            A[index] = temp
            print(A)
            index -= 1
    
def search(A, key):
    for i in range(n):
        if A[i] == key:
            return i

def arrange(A, n):
    for i in range(1, n+1):
        index = search(A, i)
        rotate(A, i, index, n)
    return A

if __name__ == "__main__":
    t = int(input())

    for _ in range(t):
        n = int(input())
        A = list(map(int, input().split()))

    print(arrange(A, n))
        