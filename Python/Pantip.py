def pantip(k, n, arr, path):
    if n == 0 :
        global count
        count = 0
    if n == 1 :
        if sum(path) == k :
            print(' '.join(list(map(str, path))))
            count += 1
    if arr != [] :
        newPath = list(path)
        newPath.append(arr[0])
        pantip(k, 1, arr[1:], list(newPath))
        if len(arr) >= 2 :
            pantip(k, 2, arr[1:], path)
    return count

inp = input('Enter Input (Money, Product) : ').split('/')
arr = [int(i) for i in inp[1].split()]
pattern = pantip(int(inp[0]), 0, arr, [])
print("Krisada can purchase Product: {0} with: {1} Baht | {2} Pattern".format(arr, inp[0], pattern))