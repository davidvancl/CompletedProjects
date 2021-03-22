function output = function2(xx,yy)
    x = 0;
    y = 0;
    switch(nargin)
        case 1
            x = xx;
        case 2
            x = xx;
            y = yy;
    end
    output = x.*exp(-(x).^2 - (y).^2) + tanh(x .* y);
end