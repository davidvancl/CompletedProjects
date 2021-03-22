function [L, U, P] = rozkladLU(A)
    %èásteèná pivotace
    indexOfMax = 1;
    for i = 1 : size(A,1)
        if(indexOfMax < A(i,1))
            indexOfMax = i;   
        end
    end
    
    temp = A(indexOfMax,:);
    A(indexOfMax,:) = A(1,:);
    A(1,:) = temp;
    %konec pivotace
    
    len = size(A, 1);
    L = eye(len);
    P = L;
    
    temp = P(indexOfMax,:);
    P(indexOfMax,:) = P(1,:);
    P(1,:) = temp;
    
    for k = 1 : len
        % operace pod k sloupcem
        L(k + 1 : len, k) = A(k + 1 : len, k) / A(k, k);
        % gauss
        for l = k + 1 : len
            A(l,:) = A(l,:) - L(l, k) * A(k, :);
        end
    end
    U = A;
end