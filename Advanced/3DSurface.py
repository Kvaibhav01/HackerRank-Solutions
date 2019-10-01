def peak_height(A):
    max = 0
    for i in range(R):
        for j in range(C):
            if max < A[i][j]:
                max = A[i][j]
    return max

def tsa(A):
    cube = 0
    for i in range(R):
        for j in range(C):
            cube += A[i][j]
    return 6 * cube * pow(1, 2)

def map_level(A, lv):
    X = [[0 for x in range(C)] for x in range(R)]
    ones = 0
    for i in range(R):
        for j in range(C):
            x = A[i][j]
            if x >= lv:
                X[i][j] = 1
            else:
                X[i][j] = 0
    if lv > 1:
        ones = sum(x.count(1) for x in X)
    print(ones)
    return X, ones

def surface_area(A):
    hidden_surface = 0
    upside_down = 0
    total_suface_area = tsa(A)
    level = peak_height(A)
    for lv in range(1, level+1):
        L = []
        L, flat = map_level(A, lv)
        upside_down += flat
        for i in range(R):
            for j in range(C):
                h = L[i][j]
                if h == 1:
                    if j-1 > -1:
                        h1 = L[i][j-1]
                        if h1 == 1:
                            hidden_surface += 1
                    if i+1 < R:
                        h2 = L[i+1][j]
                        if h2 == 1:
                            hidden_surface += 1
                    if j+1 < C:
                        h3 = L[i][j+1]
                        if h3 == 1:
                            hidden_surface += 1
                    if i-1 > -1:
                        h4 = L[i-1][j]
                        if h4 == 1:
                            hidden_surface += 1
    print(total_suface_area)
    print(hidden_surface)  
    visible_surface = total_suface_area - hidden_surface - (2 * upside_down)
    return visible_surface

RC = input().split()

R = int(RC[0])
C = int(RC[1])

A = []
for _ in range(R):
        A.append(list(map(int, input().rstrip().split())))
    
print(surface_area(A))    