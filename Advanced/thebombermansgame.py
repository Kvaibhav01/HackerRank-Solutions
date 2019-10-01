import sys

def printgrid(grid):
    for i in range(r):
        for j in range(c):
            print(grid[i][j], end='')
        print()

def boom(grid, location):
    print(location)
    for i, j in location:
        grid[i][j] = '.'
        if i-1 >= 0:
            grid[i-1][j] = '.'
        if i+1 < r:
            grid[i+1][j] = '.'
        if j-1 >= 0:
            grid[i][j-1] = '.'
        if j+1 < c:
            grid[i][j+1] = '.'

def plantBomb(grid):
    for i in range(r):
        for j in range(c):
            grid[i][j] = 'O'

def bomberMan(grid, n):
    if n == 1:
        return grid
    if n == 2:
        plantBomb(grid)
        return grid
    cycle = sys.maxsize
    for t in range(2, n+1):
        if t % 5 == 2 or t % 5 == 4:
            location = []
            for i in range(r):
                for j in range(c):
                    if grid[i][j] == 'O':
                        location.append((i,j))
            plantBomb(grid)
            printgrid(grid)
            print()
        elif t % 5 == 1 or t % 5 == 3:
            boom(grid, location) 
            printgrid(grid)                
            print()
        # if grid == initial:
        #     cycle = n % t
        # print(cycle)
        # if cycle == 0:
        #     break
        # cycle -= 1

if __name__ == "__main__":
                
    r, c, n = map(int, input().split())

    grid = []

    for _ in range(r):
        item = input()
        temp = []
        for x in item:
            temp.append(x)
        grid.append(temp)
    
    initial = grid.copy()

    if __name__ == "__main__":
        bomberMan(grid, n)