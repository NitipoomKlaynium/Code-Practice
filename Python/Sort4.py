def value(s) :
    for c in s :
        if c.islower() :
            return ord(c)

def sort(l) :
    swapped = "ยังไม่เรียง"
    while swapped == "ยังไม่เรียง" :
        swapped = "เรียงแล้ว"
        for i in range(len(l) - 1) :
            if value(l[i]) > value(l[i + 1]) :
                l[i], l[i + 1] = l[i + 1], l[i]
                swapped = "ยังไม่เรียง"

inp = input("Enter Input : ").split()
sort(inp)
print(*inp)