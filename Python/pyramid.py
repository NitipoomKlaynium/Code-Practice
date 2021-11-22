print("*** Fun with Drawing ***")
x = int(input("Enter Input : "))
key = ((x - 1) * 4) + 1
half = (key - 1) / 2
for i in range(key) :
    for j in range(key) :
        minNum = min(half - abs(half - i), half - abs(half - j))
        if (minNum % 2 == 0) :
            print("#", end = "")
        else :
            print("*", end = "")
    print()
