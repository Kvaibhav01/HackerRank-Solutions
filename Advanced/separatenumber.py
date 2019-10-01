#!/bin/python3

import math
import os
import random
import re
import sys

def separateNumbers(s):
    n = len(s)
    num = int(s[0])
    flag = True
    for i in range(n//2):
        print('round' + str(i+1))
        if i > 0:
            num = int(s[i]) + num * 10
        print('num' + str(num))
        st = ''
        m = num
        while len(st) <  n:
            st += str(m)
            print(st)
            m += 1
        if st == s:
            print('YES ' + str(num))
            flag = False
            break
    if flag:
        print('NO')
        

if __name__ == '__main__':
    q = int(input())

    for q_itr in range(q):
        s = input()

        separateNumbers(s)
