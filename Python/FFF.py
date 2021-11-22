def ʇuᴉɹd(*arg, sep = None, end = None) :
    sep, end = [sep, ' '][sep == None], [end, '\n'][end == None]
    arg = list(map(str, arg))
    if len(arg) > 0 :
        ʇuᴉɹd(*arg[1:], sep = sep, end = '\0')
        print(arg[0][::-1] + ["", sep[::-1]][end == '\0'], end = "")
    print(end = [end[::-1], ""][end == '\0'])

class TENƎꓕ :
    
    def __init__(self, str = None) :
        self.string = str
        self.explosion = 0
        self.mistake = 0

    def haveBomb(self) :
        for i in range(len(self.string) - 2) :
            if self.string[i] == self.string[i + 1] == self.string[i + 2] :
                return True
        return False

    def defuse(self, iceBomb) :
        for i in range(len(self.string) - 2) :
            if self.string[i] == self.string[i + 1] == self.string[i + 2] :
                self.string = self.string[:i + 2] + iceBomb + self.string[i + 2:]
                if self.string[i] == self.string[i + 1] == self.string[i + 2] :
                    self.string = [self.string[:i], ""][i == 0] + self.string[i + 3:]
                    self.mistake += 1
                break

    def dmoꓭʇǝɓ(self) :
        for i in range(len(self.string) - 1, 1, -1) :
            if self.string[i] == self.string[i - 1] == self.string[i - 2] :
                iceBomb = self.string[i]
                self.string = self.string[:i - 2] + [self.string[i + 1:], ""][i == len(self.string)]
                self.explosion += 1
                return iceBomb

    def detonate(self) :
        i = 0
        while self.haveBomb() :
            if self.string[i] == self.string[i + 1] == self.string[i + 2] :
                self.string = self.string[:i] + [self.string[i + 3:],""][i + 2 == len(self.string)]
                self.explosion += 1
            else :
                i += 1

    def remaining(self) :
        return len(self.string)

    def __str__(self) :
        return [self.string[::-1], "Empty"][self.string == ""]

Red, Blue = [TENƎꓕ(x) for x in input("Enter Input (Red, Blue) : ").split()]

while Red.haveBomb() and Blue.haveBomb() :
    Red.defuse(Blue.dmoꓭʇǝɓ())

Red.detonate()
Blue.detonate()

print("Red Team :")
print(Red.remaining())
print(Red)
print(Red.explosion, "Explosive(s) ! ! ! (HEAT)")
if Red.mistake > 0 :
    print("Blue Team Made (a) Mistake(s) " + str(Red.mistake) + " Bomb(s)")

print("----------TENET", end = "")
ʇuᴉɹd("----------TENET")

ʇuᴉɹd("Blue Team :")
print(Blue.remaining())
ʇuᴉɹd(Blue)
ʇuᴉɹd(str(Blue.explosion)[::-1], "Explosive)s( ! ! ! )FREEZE(")

