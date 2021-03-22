function [x,M] = integer_roots(p)
x = divider(p);
M = Horn_table(p,x);
y = Horn_sch(p,x);
x_index = 1;
for i = 1 : length(y)
    if y(i) == 0
        x_result(x_index) = x(i);
        x_index = x_index + 1;
    end
end
x = x_result;
end

