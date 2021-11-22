def addbits(bit, list = None) :
    a = str(bit[0]) + '0'
    b = str(bit[0]) + '1'
    if list == None :
        list = []
    list.append(a)
    list.append(b)
    if len(bit) == 1 :
        return list
    return addbits(bit[1:], list)

def recursion3(num, list = None) :
    if int(num) < 0 :
        return ["Only Positive & Zero Number ! ! !"]
    if int(num) == 0 :
        if list == None :
            return ['0']
        return list
    if list == None :
        list = ['']
    list = addbits(list)
    return recursion3(int(num) - 1, list)    
        
print(*recursion3(input("Enter Number : ")), sep = '\n')