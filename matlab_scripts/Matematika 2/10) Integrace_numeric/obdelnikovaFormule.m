function y = obdelnikovaFormule(f,a,b,n)
    if n < 1
        error("Po�et intervalu");
    end

    if ~(a < b)
        error("�patne meze");
    end

    h = (b - a)/n;
    y = 0;
    for x = a:h:b-h
        y = y + f(x);
    end
    y = y * h;
end