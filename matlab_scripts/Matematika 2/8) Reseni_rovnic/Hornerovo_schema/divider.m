function [d] = divider(p)
a = abs(p(end));
index_d = 1;
for i = 1 : a/2
    if mod(a,i) == 0
        if i < (1 + a/abs(p(1)))
            d(index_d) = i;
            index_d = index_d + 1;
            d(index_d) = -i;
            index_d = index_d + 1;
        end
    end
end
end

