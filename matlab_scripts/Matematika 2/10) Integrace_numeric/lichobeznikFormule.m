function y = lichobeznikFormule(f,a,b,n)
    if n < 1
        error("Po�et intervalu");
    end

    if ~(a < b)
        error("�patne meze");
    end
    
    h = (b - a) / n;
    y = f(a)/2 + f(b)/2;
    for x=a+h:h:b-h
        y=y+f(x);
    end
    y = y * h;
end