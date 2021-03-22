function y = obdelnikovaFormule(f,a,b,n)
    if n < 1
        error("Poèet intervalu");
    end

    if ~(a < b)
        error("Špatne meze");
    end

    h = (b - a)/n;
    y = 0;
    for x = a:h:b-h
        y = y + f(x);
    end
    y = y * h;
end