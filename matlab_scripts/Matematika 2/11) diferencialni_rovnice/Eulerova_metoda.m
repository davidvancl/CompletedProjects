function [x,y] = Eulerova_metoda(f,a,b,podm,h)
    x(1) = a;
    y(1) = podm;
    
    n = (b-a)/h;
    
    for i = 1 : n
        x(i + 1) = x(i) + h;
        y(i + 1) = y(i) + h * f(x(i),y(i));
    end
    x = x';
    y = y';
end