function [x y] = lagrangePolynom(x,y)
    koef=ones(size(x,2),1);
    for i=1:size(x,2) %V�po�et konstant pro n�soben� jednotliv�ch polynom�
        for j=1:size(x,2)
            if(i~=j)
                koef(i)=(koef(i)*1/((x(i)-x(j))));
            end
        end
    end

    %Sestaven� polynomu
    syms pol tx fpol
    pol=1;
    fpol=0;
    for i=1:size(x,2)
        for j=1:size(x,2)
            if(i~=j)
                pol=pol*(tx-x(j));
            end
        end
        fpol=fpol+y(i)*koef(i)*pol;
        pol=1;
    end
    
    x = x(1):0.1:x(end);
    y = zeros(size(x,2),1);
    
    %Dosazen� do polynomu
    for i = 1:size(x,2)
        y(i) = subs(fpol,tx,x(i));
    end
end