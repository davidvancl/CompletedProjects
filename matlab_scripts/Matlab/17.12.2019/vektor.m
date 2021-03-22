function Y = vektor(x,y)
    ro=sqrt(x*x+y*y);
    if ro == 0
        fi = 0;
    elseif x>=0
        fi=atan(y/x);
    else
        fi=atan(y/x) + pi;
    end
    Y=vektorofi(ro,fi);
end

