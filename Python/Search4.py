class hash:
    def __init__(self, maxSize, maxCollision, threshold) :
        self.size = 0
        self.maxSize = maxSize
        self.maxCollision = maxCollision
        self.threshold = threshold
        self.items = []
        for i in range(maxSize) :
            self.items.append(None)

    def getASCII(self, text) :
        temp = 0
        for c in text :
            temp += ord(c)
        return temp

    def isPrime(self, num) :
        if num % 2 == 0 :
            return False
        for i in range(3, int(num / 2), 2) :
            if num % i == 0 :
                return False
        return True

    def getNextPrime(self, num) :
        num += 1
        while not self.isPrime(num) :
            num += 1
        return num

    def reHash(self) :
        temp = []
        for i in range(len(self.items)) :
            if self.items[i] and self.items[i] != i + 1 :
                temp.append(self.items[i])
                self.items[i] = None
                self.size -= 1
        self.maxSize = self.getNextPrime(self.maxSize * 2)
        while len(self.items) < self.maxSize :
            self.items.append(None)
        while temp :
            self.insert(temp.pop())            

    def insert(self, data) :
        check = False
        while self.size + 1 > self.maxSize * self.threshold / 100 :
            print("****** Data over threshold - Rehash !!! ******")
            self.reHash()
        key = data % self.maxSize
        count = 0
        while count <= self.maxCollision :
            if count == self.maxCollision :
                print("****** Max collision - Rehash !!! ******")
                self.reHash()
                count = 0
                key = data % self.maxSize
                continue
            if not self.items[key] :
                self.items[key] = data
                self.size += 1                  
                return
            else :
                count += 1
                print(f"collision number {count} at {key}")
                key = (data + (count * count)) % self.maxSize   

    def __str__(self) :
        s = ""
        for i in range(len(self.items)) :
            s += '#' + str(i + 1) + '\t' + str(self.items[i]) + '\n'
        return s + "----------------------------------------"

print(" ***** Rehashing *****")
inp  = input("Enter Input : ").split('/')
s, maxC, threshold = inp[0].split()
h = hash(int(s), int(maxC), float(threshold))
print("Initial Table :")
print(h)
data = list(map(int, inp[1].split()))
for i in data :
    print("Add :", i)
    h.insert(i)
    print(h)
