def staircase(n, x = 1):
    if n == 0 and x == 1 :
        print("Not Draw!")
        return
    if n > 0 :
        print('_' * (n - 1), '#' * x, sep = '')
        staircase(n - 1, x + 1)
    if n < 0 :
        staircase(n + 1, x + 1)        
        print('_' * (abs(n + 1)), '#' * x, sep = '')
staircase(int(input("Enter Input : ")))