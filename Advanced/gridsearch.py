def scan(G, g, r_s, r_e, c_s, c_e):
    x, y = 0, 0
    for i in range(r_s, r_e):
        for j in range(c_s, c_e):
            if g[x][y] != G[i][j]:
                return False
            y += 1
        x += 1
        y = 0
    return True

def gridSearch(G, g, R, C, r, c):
    r_start = 0
    r_end = r
    c_start = 0
    c_end = c
    
    t = 0
    while t < (R-r+1) * (C-c+1):
        if scan(G, g, r_start, r_end, c_start, c_end):
            return 'YES'
        t += 1
        c_start += 1
        c_end += 1
        if c_end > C:
            c_start = 0
            c_end = c
            r_start += 1
            r_end += 1
        
    return 'NO'

if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        R, C = map(int, input().split())
        G = []
        for _ in range(R):
            G_item = input()
            G.append(G_item)
        r, c = map(int, input().split())
        g = []
        for _ in range(r):
            g_item = input()
            g.append(g_item)
        print(gridSearch(G, g, R, C, r, c)) 
    