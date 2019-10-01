def rotate(r_s, r_e, c_s, c_e, matrix):
    
    #first column
    temp1 = matrix[r_e-1][c_s]
    for i in range(r_e-1, r_s, -1):
        j = c_s
        matrix[i][j] = matrix[i-1][j]
    
    #last row
    temp2 = matrix[r_e-1][c_e-1]
    for j in range(c_e-1, c_s, -1):
        i = r_e - 1
        matrix[i][j] = matrix[i][j-1]
    matrix[i][j] = temp1

    #last col
    temp1 = matrix[r_s][c_e-1]
    for i in range(r_s, r_e-1):
        j = c_e - 1
        matrix[i][j] = matrix[i+1][j]
    matrix[i][j] = temp2

    #first row
    for j in range(c_s, c_e-1):
        i = r_s
        matrix[i][j] = matrix[i][j+1]
    matrix[i][j] = temp1

if __name__ == "__main__":

    m, n , r = map(int, input().split())

    matrix = []

    for _ in range(m):
        matrix.append(list(map(int, input().rstrip().split())))

    r_start = 0
    r_end = m
    c_start = 0
    c_end = n

    while r_start < r_end and c_start < c_end:
        times = 2 * (r_end-r_start) + 2 * (c_end-c_start) - 4
        #print(times)
        rotation = r % times
        #print(r)
        for _ in range(rotation):
            rotate(r_start, r_end, c_start, c_end, matrix)
        
        r_start += 1
        r_end -= 1
        c_start += 1
        c_end -= 1

    print()
    for i in range(m):
            for j in range(n):
                print(matrix[i][j], end=" ")
            print() 