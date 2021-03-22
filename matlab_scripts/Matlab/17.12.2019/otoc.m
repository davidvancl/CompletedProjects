function Y = otoc(X,fi)
    S=[cos(fi),-sin(fi);sin(fi),cos(fi)];
    Y=S*X;
end

