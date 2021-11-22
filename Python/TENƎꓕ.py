class Queue :
    
    def __init__(self, items = None) :
        if items == None :
            self.items = []
        else : 
            self.items = items
    
    def enQueue(self, i) :
        self.items.append(i)

    def deQueue(self) :
        return self.items.pop(0)

    def isEmpty(self) :
        return len(self.items) == 0

    def size(self) :
        return len(self.items)

Red, Blue = input("Enter Input (Red, Blue) : ").split()
RedExplosion, BlueExplosion, mistake = 0, 0, 0
FreezeBomb = Queue()

i = len(Blue) - 1
while i > 1 :
    if Blue[i] == Blue[i - 1] == Blue[i - 2] :
        FreezeBomb.enQueue(Blue[i] + Blue[i - 1] + Blue[i - 2])
        Blue = [Blue[:i - 2], ""][i - 2 == 0] + [Blue[i + 1:],""][i == len(Blue)]
        BlueExplosion += 1
        i -= 2
        
    i -= 1
i = 0
while i < len(Red) - 2 :
    if Red[i] == Red[i + 1] == Red[i + 2] :
        print(Red)
        if not FreezeBomb.isEmpty() :
            Red = Red[:i + 2] + FreezeBomb.deQueue()[0] + Red[i + 2:]
            if Red[i] == Red[i + 1] == Red[i + 2] :
                mistake += 1
                Red = [Red[:i], ""][i == 0] + [Red[i + 3:], ""][i + 2 == len(Red)]
            else :
                i += 3
        else :
            Red = [Red[:i], ""][i == 0] + [Red[i + 3:], ""][i + 2 == len(Red)]
            RedExplosion += 1
    else :
        i += 1

print("Red Team :")
print(len(Red))
print([Red[::-1], "Empty"][Red == ""])
print(str(RedExplosion) + " Explosive(s) ! ! ! (HEAT)")
if mistake > 0 :
    print("Blue Team Made (a) Mistake(s) " + str(mistake) + " Bomb(s)")
print("----------TENETTENET----------")
print(": maeT eulB")
print(len(Blue))
print([Blue, "ytpmE"][Blue == ""])
print("(EZEERF) ! ! ! (s)evisolpxE " + str(BlueExplosion))