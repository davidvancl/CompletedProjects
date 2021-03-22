function print(r)
    
    for i = 1 : length(r)
       if r(i) > 0    
           disp("(x - " + (r(i)) + ")");
       else
           disp("(x + " + (r(i) * -1) + ")");
       end
       
    end
end

