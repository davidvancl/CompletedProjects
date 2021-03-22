function y = simpsonovaFormule(f,a,b,n)
    if n < 1
        error("Poèet intervalu");
    end

    if ~(a < b)
        error("Špatne meze");
    end
    
    h= (b - a)/n;
    y = f(a) + f(b);
    k = 1;
    for x=a+h:h:b-h
        if(mod(k,2)==0)
            y = y+2*f(x);
        else
            y = y+4*f(x);
        end
        k = k+1;
    end
    y = y *h/3;
end