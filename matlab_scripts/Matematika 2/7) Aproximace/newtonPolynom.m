function [x y] = newtonPolynom(x,y)
    A = zeros(size(x,2));
    A(:,1) = y;
    for i = 2:size(x,2)
        for j = i:size(x,2)
            A(j,i) = (A(j, i - 1) - A(j - 1, i - 1)) / (x(j) - x(j - i + 1));
        end                                                           
    end
    
    %sestavení polynomu
    syms P2 tmx
    P2 = A(1,1);
    for i = 2:size(x,2)
        pom=A(i,i);
        for j = 1:(i - 1)
            pom = pom * ((tmx - x(j)));
        end
        P2 = P2 + pom;
    end

    x = (-1:0.1:3);
    y = zeros(size(x,2),1);

    %Dosazení do polynomu
    for i = 1:size(x,2)
        y(i) = subs(P2,tmx,x(i));
    end
    
end