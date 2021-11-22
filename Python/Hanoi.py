def move(n, x = ['A'], y = ['C'], z = ['B'], maxn = 0) :
    def display(_n, χ = [], ψ = [], ζ = []) :
        if χ == ψ == ζ == [] :
            χ, ψ, ζ = list(x), list(y), list(z)
        if _n == 0 :
            print("|  |  |")        
        if _n < 0 :
            a, b, c = sorted([χ, ψ, ζ])
            α, β, γ = a.pop(1) if len(a) > 1 else '|', b.pop(1) if len(b) > 1 else '|', c.pop(1) if len(c) > 1 else '|'
            display(_n + 1, χ, ψ, ζ)
            print(α, '', β, '', γ)
    # x, y, z = list(x), list(y), list(z)
    if n > 0 :
        x.append(n)
        move(n - 1, x, y, z , maxn + 1)
    elif n == 0 :
        n = -maxn
        display(n)
    if n < 0 :
        if maxn == 1 :
            print("move 1 from ",x[0] ,"to", y[0])
            y.append(x.pop(len(x) - 1))
            display(n)
            return
        move(n, x, z, y, maxn - 1) 
        print("move", maxn, "from ", x[0], "to", y[0])
        y.append(x.pop(len(x) - 1))
        display(n)
        move(n, z, y, x, maxn - 1)   

r = int(input("Enter Input : "))
move(r)