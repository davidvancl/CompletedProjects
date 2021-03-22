function [x,it] = myNewton(f,df,x0,tol,maxit)
    it = maxit;
    x(1) = x0;
    for i = 1:maxit
        x(i+1) = x(i)-f(x(i))/df(x(i));
        if(abs(f(x(i+1)))<tol)
            it = i;
            break;
        end
    end
    x= x(it);
end

