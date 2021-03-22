function [x it] = myBisection(f,a,b,epsi)
    it = 1;
    if sign(f(a)) * sign(f(b)) >= 0
       error("Neplatná podmínka.")
    end
    
    functionA = f(a);
    functionB = f(b);
    
    while(b - a) > epsi
        c = (a+b) / 2;
        functionC = f(c);
        
        if functionC == 0
            x = c;
            it = it + 1;
            break;
        end
        
        if sign(functionC) * sign(functionA) < 0
            b = c;
            functionB = functionC;
        else
            a = c;
            functionA = functionC;
        end
    end
    x = (a + b) / 2;
end