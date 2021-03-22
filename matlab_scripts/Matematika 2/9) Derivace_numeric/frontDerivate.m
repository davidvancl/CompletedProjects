function dy = frontDerivate(df,x,h)
    dy = (df(x + h) - df(x)) ./ h;
end