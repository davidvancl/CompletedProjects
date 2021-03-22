function Y = vektory(xy)
    Y=vektor(xy(1,1),xy(2,1));
    d=size(xy);
    for i=2:d(2)
        Y=[Y,vektor(xy(1,i),xy(2,i))];
    end
end

