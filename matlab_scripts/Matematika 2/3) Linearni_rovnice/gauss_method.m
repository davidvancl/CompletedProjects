function x = gauss_method(A,b)
    len = length(A);
    for j = 1:(len-1)
        for i = len:-1:j+1
            m = A(i,j)/A(j,j);
            A(i,:) = A(i,:) - m*A(j,:);
            b(i) = b(i) - m*b(j);
        end
    end 
    x = zeros(len,1);
    x(len) = b(len)/A(len,len);               
    for i = len-1:-1:1                    
        lenum = 0;
        for j = len:-1:i+1                
            lenum = lenum + A(i,j)*x(j);    
        end 
        x(i) = (b(i)- lenum)/A(i,i);
    end
end