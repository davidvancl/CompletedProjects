function [x,itr] = method_gauss(A,b,tol)
    x=zeros(length(b),1);
    n=size(x,1);
    normVal=Inf; 
    %pøesnost 
    itr=0;
    while normVal>tol
        x_old=x;
        for i=1:n
            bi=0;
            for j=1:i-1
                    bi=bi+A(i,j)*x(j);
            end
            for j=i+1:n
                    bi=bi+A(i,j)*x_old(j);
            end
            x(i)=(1/A(i,i))*(b(i)-bi);
        end
        itr=itr+1;
        normVal=norm(x_old-x);
    end
end

