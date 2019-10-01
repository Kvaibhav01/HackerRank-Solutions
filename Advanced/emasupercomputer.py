#Combined area of two plus symbol 
def plus_area(plus):
    area = 1
    for p in plus:
        #overlapped centerd one is counted two times so -1
        area *= 2*p-1
    return area

#if any one of the cordinate (i, j) is repeated in two of plus then it is overlapped
def overlap(a, b, c, d, flag, edge):
    #if flag is true than append all the cordinate of first plus to a list edge[]
    if not flag:
        i = (a + b) // 2
        for j in range(c, d):
            edge.append(tuple((i, j)))
        j = (c + d) // 2
        for i in range(a,b):
            edge.append(tuple((i, j)))
        #return False bcoz it is the first plus in the grid, no need to check for overlap
        return False
    #otherwise for every other second plus, return true if overlap 
    else:
        i = (a + b) // 2
        for j in range(c, d):
            if tuple((i, j)) in edge:
                return True
        j = (c + d) // 2
        for i in range(a,b):
            if tuple((i, j)) in edge:
                return True
        return False

#inside a grid if plus symbol containing 'G's occur then return True              
def is_plus(grid, w, x, y, z):
    #check if not 'G' over horizontal line
    i = (w + x) // 2
    for j in range(y, z):
        if grid[i][j] != 'G':
            return False
    #check if not 'G' over vertical line
    j = (y + z) // 2
    for i in range(w, x):
        if grid[i][j] != 'G':
            return False
    return True

#scan the entire mxn grid using LxL square frame 
def scan(grid, L, r, c):
    maximum = 0
    edge = []
    plus = []
    for l in range(L, 0, -2):
        r_start = 0
        r_end = r_start + l
        c_start = 0
        c_end = c_start + l
        t = 0
        #(r-l+1) * (c-l+1) is number of sub-matrix of lxl present in rxc matrix
        while t < ((r-l+1) * (c-l+1)):
            if is_plus(grid, r_start, r_end, c_start, c_end):
                if not overlap(r_start, r_end, c_start, c_end, len(plus), edge):
                    plus.append(l)
                    
            if len(plus) == 2:
                maximum = max(maximum, plus_area(plus))
                plus.pop()
            
            t += 1
            c_start += 1
            c_end += 1
            if c_end > c:
                c_start = 0
                c_end = c_start + l
                r_start += 1
                r_end += 1
            if r_end > r:
                r_start = 0
                r_end = r_start + l
    return maximum

#set square frames of odd len side 
def two_pluses(grid, r, c):
    area = 1
    q = min(r, c)
    R = q if (q&1) else q-1
    for l in range(R, 0, -2):
        area = max(area, scan(grid, l, r, c))
    return area 

if __name__ == '__main__':
    nm = input().strip().split()

    n = int(nm[0])
    m = int(nm[1])

    grid = []
    for _ in range(n):
        s = input()
        grid.append(s)

    print(two_pluses(grid, n, m))

    '''
14 12
GGGGGGGGGGGG
GGGGGGGGGGGG
BGBGGGBGBGBG
BGBGGGBGBGBG
GGGGGGGGGGGG
GGGGGGGGGGGG
GGGGGGGGGGGG
GGGGGGGGGGGG
BGBGGGBGBGBG
BGBGGGBGBGBG
BGBGGGBGBGBG
BGBGGGBGBGBG
GGGGGGGGGGGG
GGGGGGGGGGGG
    '''
#189   