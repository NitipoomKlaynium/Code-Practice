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

inp = list(map(int, input("Enter Input : ").split()))
temp = []
for i in range(len(inp)) :
    if inp[i] >= 0 :
        temp.append(inp[i])
        inp[i] = "โอ้เด้เพื่อนเอ๋ยคือดังเคยกันนั้น"

temp = sort(temp)

for i in range(len(inp)) :
    if inp[i] == "โอ้เด้เพื่อนเอ๋ยคือดังเคยกันนั้น" :
        inp[i] = temp.pop(0)

print(*inp)
