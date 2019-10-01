#!/bin/python3

import math
import os
import random
import re
import sys
from collections import defaultdict

def add(s, i, j):
    st = ''
    for k in s:
        if i == k or j == k:
            st += k
    return st

def remove(s, r):
    st = ''
    for i in s:
        if i not in r:
            st += i
    return st

def validate(s):
    for i in range(len(s)-1):
        if s[i] == s[i+1]:
            return False
    return True

def alternate(s):
    d = defaultdict(int)
    r = []
    for i in s:
        d[i] += 1
    
    for i in range(len(s)-1):
        if s[i] == s[i+1]:
            if s[i] not in r:
                r.append(s[i])
    print('original dictionary')
    print(d)
    print('Need to remove like aa bb ..')
    print(r)
    s = remove(s, r)
    print('After remove string s')
    print(s)
    for k in r:
        del d[k]
    print('After remove changes in dictionary')
    print(d)
    l = list(d)
    print('After remove {} -> [] L')
    print(l)
    m = []
    for i in range(len(l)-1):
        for j in range(i+1, len(l)):
            temp = ''
            #print(s[i], s[j])
            temp += add(s, l[i], l[j])
            #print(temp)
            if validate(temp):
                m.append(len(temp))
    if len(m) == 0:
        return 0
    print(m)
    return max(m)


if __name__ == '__main__':

    l = int(input().strip())

    s = input()

    result = alternate(s)

    print(str(result) + '\n')