function [x,itr] = method_jacob(A,b,tol)
    x=zeros(length(b),1);
    n=size(x,1);
    normVal=Inf; 
    itr=0;

    while normVal>tol
        xold=x;
        for i=1:n
            sigma=0;      
            for j=1:n
                if j~=i
                    sigma=sigma+A(i,j)*x(j);
                end
            end
            x(i)=(1/A(i,i))*(b(i)-sigma);
        end
        itr=itr+1;
        normVal=abs(xold-x);
    end
end

