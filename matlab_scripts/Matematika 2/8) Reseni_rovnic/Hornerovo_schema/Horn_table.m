function [y] = Horn_table(p,x)
initial_length = length(p);
roots_found = 0;
is_root_found_this_iter = 0;
for i = 1 : length(x)
    temp(1) = p(1);
    for j = 2 : length(p)
       temp(j) = temp(j-1) * x(i) + p(j);
    end
    if(temp(end) == 0)
        roots_found = roots_found + 1;
        is_root_found_this_iter = 1;
        p = temp(1:end-1);
    end
    for j = length(temp) + 1 : initial_length
        temp(end + 1) = 0;
    end
    if(is_root_found_this_iter == 1)
        y(roots_found,:) = temp;
    end
    temp = 0;
end
end

