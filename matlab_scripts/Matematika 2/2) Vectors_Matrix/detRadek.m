function D = detRadek(M,i)
    D = 0;
    if(size(M,1) ~= size(M,2))
        error("Matrix is not n*n");
    end

    for j = 1 : size(M,1)
        subM = zeros(size(M,1) - 1,size(M,2) - 1);
        indX = 1;
        indY = 1;
        for u = 1: size(M,1)
            if u ~= i
                for l = 1:size(M,2)
                    if l ~= j
                        subM(indX,indY) = M(u,l);
                        indY = indY + 1;
                    end
                end
                indX = indX +1;
                indY = 1;
            end 
        end
        D = D + (M(i,j) * (-1)^(i+j) * det(subM));
    end
end