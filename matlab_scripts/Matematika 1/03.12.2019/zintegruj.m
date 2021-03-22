function z = zintegruj(x,y)
    for i=1: length(x)
        xx = x(1:i);
        yy = y(1:i);
        z(i) = integral(xx,yy);
    end
end

