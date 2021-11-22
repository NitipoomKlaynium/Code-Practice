def sort(l, n = -1) :
    if n == -1 :
        n = len(l)
    if n == 0 :
        return l
    if len(l) == 1 :
        return l
    if l[0] > l[1] :
        l[0] = l[1] + l[0]
        l[1] = l[0] - l[1]
        l[0] = l[0] - l[1]
    l = [l[0]] + sort(l[1:], 1)
    return sort(l, n - 1)

x = list(map(int, input("Enter Input : ").split()))
print(sort(x))
