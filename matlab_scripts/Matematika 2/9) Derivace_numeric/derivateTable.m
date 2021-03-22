function dy = derivateTable(x,y)
    N = length(x);
    if N~=length(y)
        error("X a Y nejsou stejne dlouhe.");
    end
    if N < 3
        error("Delka neni dostatecne dlouha");
    end
    
    h = (x(2) - x(1));
    dy = y;
    dy(1) = (-3*y(1) + 4 * y(2) - y(3)) / (2*h);
    
    for i=2:N-1
        dy(i) = (y(i+1)-y(i - 1)) / (2*h);
    end
    dy(N) = (y(N - 2) - 4*y(N-1)+3*y(N)) / (2*h);
end