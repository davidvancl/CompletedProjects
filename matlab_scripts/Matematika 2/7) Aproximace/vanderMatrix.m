function [x y] = vanderMatrix(x,y)
    sz = size(x,2);
    vmatrix=zeros(sz);
    
    %sestavení matice
    for i=1:sz
        for j=(sz):-1:1
            vmatrix(i,j)=x(i).^(j-1);
        end
    end

    %výpoèet koeficientù
    P=vmatrix\y'; 
    x=x(1):0.1:x(sz); 
    y=zeros(size(x,2),1);
    y=y';
    for i=1:size(y,2)
        y(i)=x(i)^0*P(1)+x(i)^1*P(2)+x(i)^2*P(3)+x(i)^3*P(4);
    end
end