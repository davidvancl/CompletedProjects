%1
    q=(((12/63) + (21/51)) * (7/5)) - 22/7;
    b=(((sym(12)/63) + (21/51)) * (7/5)) - 22/7;
%2
    syms x y
    f=log(abs(cos(x))) + y * x * exp(-(x^2));
    pretty(f);
%3
    f2=subs(f,x,1/y); 
%4  
    f3=vpa(subs(f2,y,sym(3)),100);
%5
    I1=vpa(int(f2,1,2),6);
%6
    I2=int(f,x);
%7
    syms k
    kf=vpa(symsum(sin(((2*pi) / 3)*k),1,40),6);
%8
    res1=limit(f,x,pi/2);    
%9
    fxy=diff(f,x)/diff(f2,x);
    resInt=int(fxy,x,0,inf);
%10
    syms a
    A=[1 -3 a;2 -6 9;-a 3 0];
    nejasne=solve(det(A));
    
    A=[1 -3 1;2 -6 9;-1 3 0];
    cis=det(A);
%11
    syms x
    w=expand(cos(3*x) - sin(3*x));
%12
    %solve
    resSolve=solve(exp(-x^2 + 4*x - 9) - 1);
    %roots
    resRoots=roots([-1 4 -9]);