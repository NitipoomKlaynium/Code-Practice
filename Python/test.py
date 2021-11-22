# from fractions import Fraction
# def fraction_(x, y) :
#     i = 2
#     while i <= x :
#         if x % i == 0 and y % i == 0 :
#             x = x / i
#             y = y / i
#         else :
#             i += 1
#     return str(int(x)) + "/" + str(int(y))
# def fraction(x) :
#     if x % 1 == 0 :
#         return x
#     else :
#         y = 1
#         while x % 1 != 0 :
#             x = x * 10
#             y = y * 10
#         return (fraction_(x, y))
# x = [1, 2, 3, 4]
# for i in enumerate(x, 3) :
#     print(i)
# def pattern(n, arr, path) :
    

#     if n == 1 :
#         print("arr =", arr, "path =", path)
#     if arr != [] :
#         newPath = list(path)
#         newPath.append(arr[0])
#         pattern(1, arr[1:], list(newPath))
#         if len(arr) >= 2 :
#             pattern(2, arr[1:], path)

# pattern(0, [1, 2, 3, 4, 5], [])

# def func1(n, l = None) :
#     if l == None :
#         l = []
#         global count
#         count = 0
#     if n > 0 :
#         l.append(n)
#         count += 1
#         func1(n - 1, l)
#     else :
#         print(count)

# func1(5)
# def GCD(a, b) :
#     if b == 0 :
#         return a
#     return GCD(b, a % b)
# x = dict()
# x['1'] = 10
# print(x.get('1', 110))


# def permute(l) :
#     if len(l) == 2 :
#         return [l] + [l[::-1]]
#     else :
#         out = l.pop(0)
#         temp_lst = permute(l)
#         permute_lst = []
#         for i in range(len(temp_lst)) :
#             for j in range(len(temp_lst[i]) + 1) :
#                 permute_lst.append(temp_lst[i].copy())
#                 permute_lst[-1].insert(j, out)
#         return permute_lst

# print("*** Fun with permute ***")
# lst = list(map(int, input("input : ").split(",")))
# print("Original Coflection: ", lst)
# lst.reverse()
# print("Collection of distinct numbers:")
# print("", permute(lst))


# def countdown(n) :
#     print(n)1,1,
#     if n == 0 :
#         return
#     else :
#         countdown(n-1)

# countdown(5)

class Bus:
    def __init__(self,people, fare):
        self.people = people
        self.fare = fare
    def __str__(self):
        return 'this bus has ' + str(self.people) \
        + ' people with fare = ' + str(self.fare)
    def __lt__(self,rhs):
        return self.people*self.fare < \
                 rhs.people*rhs.fare
    def people_in(self,k):
        self.people = self.people + k
    def people_out(self,k):
        self.people = self.people - k
    def change_fare(self,new_fare):
        self.fare = new_fare


b1, b2, f1, f2 = input("Enter people in Bus1, Bus2, fare Bus1, Bus2 : ").split()
b1 = Bus(int(b1), int(f1))
b2 = Bus(int(b2), int(f2))
if b1 < b2:
    print(b1)
else:
    print(b2)
b1.people_in(3)
b1.people_out(6)
b1.change_fare(12)
print(b1)