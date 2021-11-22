class Data:
    def __init__(self, key, value):
        self.key = key
        self.value = value

    def __str__(self):
        return "({0}, {1})".format(self.key, self.value)

class hash:
    def __init__(self, size, maxCollision) :
        self.size = size
        self.maxCollision = maxCollision
        self.items = []
        for i in range(size) :
            self.items.append(None)

    def getASCII(self, text) :
        temp = 0
        for c in text :
            temp += ord(c)
        return temp

    def insert(self, inKey, data) :
        H = self.getASCII(inKey) % self.size
        key = H
        count = 0
        while count < self.maxCollision :
            if not self.items[key] :
                self.items[key] = Data(inKey, data)
                return
            else :
                count += 1
                print("collision number", count, "at", key)
                key = (H + (count * count)) % self.size
        print("Max of collisionChain")

    def __str__(self) :
        s = ""
        for i in range(self.size) :
            s += '#' + str(i + 1) + '\t' + str(self.items[i]) + '\n'
        return s + "---------------------------"

print(" ***** Fun with hashing *****")
inp  = input("Enter Input : ").split('/')
s, maxC = map(int, inp[0].split())
h = hash(s, maxC)
data = []
[data.append((i.split()[0], i.split()[1])) for i in inp[1].split(',')]
for i in data :
    h.insert(i[0], i[1])
    print(h)
    if not None in h.items :
        print("This table is full !!!!!!")
        break
