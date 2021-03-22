function x = cramer_method(M,b)
    len = size(M,1);
    if len ~= size(M,2)
        error("m * n matrix");
    end
    
    if det(M) == 0
        error("Is singular");
    end

    for i = 1 : len
        Mi = M;
        Mi(:,i) = b;
        x(i) = det(Mi) / det(M);
    end
end