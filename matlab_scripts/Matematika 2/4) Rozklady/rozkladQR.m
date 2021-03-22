function [Q,R] = rozkladQR(A)
    n = size(A,1);
    Q = zeros(n,n);
    R = zeros(n,n);
    
    for j=1:n
        v = A(:,j);
        for i=1:j-1
            R(i,j) = Q(:,i)'*A(:,j);
            v = v - R(i,j) * Q(:,i);
        end
        R(j,j) = norm(v);
        if abs(R(j,j)) > 1e-5
            Q(:,j) = v/R(j,j);
        else
            Q(j,j) = 1;
        end  
    end
end