function [x]= prostaIterace(jmf,a,b,x0,nmax,epsilon)
    for k=1:nmax 	
       x=feval(jmf,x0); 	% volani funkce v bode x0
       if x<a | x>b 	% mimo definicni obor?
          x=inf; 
          return;
       end
       if abs(x-x0) < epsilon 	% postacuje presnost
          return; 
       end
       x0=x;
    end
    x=inf;
end