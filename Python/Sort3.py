def insertionSort(l, out = []) :
    if l == [] :
        return out
    if out == [] :
        out.append(l.pop(0))
    if not "เราจะทำตามสัญญา" in out :
        out.insert(0, "เราจะทำตามสัญญา")
    index = out.index("เราจะทำตามสัญญา")
    if index + 1 == len(out) :
        num = l.pop(0)
        out.pop()
        out.append(num)
        print("insert", num, "at index", index, ":", out, [l, ''][l == []])
        return insertionSort(l, out)
    if l[0] <= out[index + 1] :
        num = l.pop(0)
        out.pop(index)
        out.insert(index, num)
        print("insert", num, "at index", index, ":", out, [l, ''][l == []])
        return insertionSort(l, out)
    out[index] = out[index + 1]
    out[index + 1] = "เราจะทำตามสัญญา"
    return insertionSort(l, out)
inp = list(map(int, input("Enter Input : ").split()))
x = insertionSort(inp)
print("sorted")
print(x)