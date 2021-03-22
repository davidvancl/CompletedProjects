function dy = centralDerivate(df,x,h)
    dy = (df(x + h) - df(x - h)) ./ (2 * h);
end