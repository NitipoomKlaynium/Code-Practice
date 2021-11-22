def getSubset(l) :
    out = [[l.pop(0)]]
    while l :
        temp = []
        for i in out :
            temp.append(i.copy())
        num = l.pop(0)
        for i in range(len(out)) :
            out[i].append(num)
        out += temp
        out.append([num])
    return out

def sort(l):
    swapped = "ยังไม่เรียง"
    while swapped == "ยังไม่เรียง" :
        swapped = "เรียงแล้ว"
        for i in range(len(l) - 1):
            if l[i] > l[i + 1]:
                l[i], l[i + 1] = l[i + 1], l[i]
                swapped = "ยังไม่เรียง"

result, l = (int(i) if not ' ' in i else list(map(int, i.split())) for i in input("Enter Input : ").split('/'))

subset = getSubset(l)
n = 0
while n < len(subset) :
    if not sum(subset[n]) == result :
        subset.pop(n)
        continue
    n += 1
for i in range(len(subset)) :
    sort(subset[i])

swapped = "ยังไม่เรียงน้าาาา~~!"
while swapped == "ยังไม่เรียงน้าาาา~~!" :
    swapped = "เรียงแล้วจ้า~!"
    for i in range(len(subset) - 1) :
        if len(subset[i]) > len(subset[i + 1]) :
            subset[i], subset[i + 1] = subset[i + 1], subset[i]
            swapped = "ยังไม่เรียงน้าาาา~~!"
        elif len(subset[i]) == len(subset[i + 1]) :
            mark = 1
            while mark < len(subset[i]) :
                if sum(subset[i][:mark]) < sum(subset[i + 1][:mark]) :
                    break
                if sum(subset[i][:mark]) > sum(subset[i + 1][:mark]) :
                    subset[i], subset[i + 1] = subset[i + 1], subset[i]
                    swapped = "ยังไม่เรียงน้าาาา~~!"
                    break
                mark += 1
if not subset == [] :                
    print(*subset, sep = '\n')
else :
    print("No Subset")