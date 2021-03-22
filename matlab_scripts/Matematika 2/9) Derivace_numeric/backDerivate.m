function dy = backDerivate(df,x,h)
    dy = (df(x) - df(x - h)) ./ h;
end