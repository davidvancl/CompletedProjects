%1)
A=randn(1000,2000);
%2)
B=round(A);
%3)
for i=1:size(B,2)
    for u=1:size(B,2)-1
        for j=1:size(B,1)
            if B(j,u) < B(j,u + 1)
                temp = B(:,u);
                B(:,u) = B(:,u+1);
                B(:,u+1) = temp;
                break
            elseif B(j,u) > B(j,u + 1)
                break
            end
        end
    end
end
