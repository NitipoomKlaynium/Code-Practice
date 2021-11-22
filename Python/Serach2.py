inp = input("Enter Input : ").split('/')
l = list(map(int, inp[0].split()))
val = list(map(int, inp[1].split()))
for i in val :
    temp = i
    for j in l :
        if j > i :
            if temp == i or j < temp :
                temp = j
    if temp == i :
        print("No First Greater Value")
    else :
        print(temp)
