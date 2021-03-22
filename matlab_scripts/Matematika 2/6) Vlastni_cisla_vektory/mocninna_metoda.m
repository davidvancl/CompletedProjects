function [vec,value] = mocninna_metoda(start,A,toler)
    dd = 1;
    x = start;
    n = 10;
    while dd > toler
        y = A * x; %mocninný krok
        dd = abs(norm(x) - n);
        n = norm(x);
        x = y / n;
    end
    vec = x / n;
    value = n;
end