#!/bin/python3

import math
import os
import random
import re
import sys

def timeInWords(h, m):
    hour = {1:'one', 2:'two', 3:'three', 4:'four', 5:'five', 6:'six', 7:'seven', 8:'eight', 9:'nine', 10:'ten', 11:'eleven', 12:'twelve'}

    minute = {2:'twenty', 3:'thirty', 10:'ten', 11:'eleven', 12:'twelve', 13:'thirteen', 14:'fourteen', 15:'fifteen', 16:'sixteen', 17:'seventeen', 18:'eighteen', 19:'nineteen'}

    if m == 0:
        return hour[h] + ' o\' clock'
    if m == 30:
        return 'half past ' + hour[h]
    if m < 30:
        if m == 1:
            return hour[m] + ' minute past ' + hour[h]
        if m > 1 and m < 11:
            return hour[m] + ' minutes past ' + hour[h]
        if m == 15:
            return 'quater past ' + hour[h]
        if m > 10 and m < 20:
            return minute[m] + ' minutes past ' + hour[h]
        if m == 20:
            return minute[2] + 'minutes past ' + hour[h]
        if m > 20:
            o = m % 10
            m //= 10
            return minute[m] + hour[o] + ' minutes past ' + hour[h]
    if m > 30:
        m = 60 - m
        h = (h % 12) + 1
        if m == 1:
            return hour[m] + ' minute to ' + hour[h]
        if m > 1 and m < 11:
            return hour[m] + ' minutes to ' + hour[h]
        if m == 15:
            return 'quater to ' + hour[h]
        if m > 10 and m < 20:
            return minute[m] + ' minutes to ' + hour[h]
        if m == 20:
            return minute[2] + ' minutes to ' + hour[h]
        if m > 20:
            o = m % 10
            m //= 10
            return minute[m] + hour[o] + ' minutes to ' + hour[h]
        

if __name__ == '__main__':

    h = int(input())


    m = int(input())

    result = timeInWords(h, m)

    print(result + '\n')
