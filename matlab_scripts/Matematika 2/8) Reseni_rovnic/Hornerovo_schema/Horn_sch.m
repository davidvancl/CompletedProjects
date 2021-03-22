function [y] = Horn_sch(p,x)
for i = 1 : length(x)
    temp = p(1);
    for j = 2 : length(p)
       temp = temp * x(i) + p(j);
    end
    y(i) = temp;
end
end

