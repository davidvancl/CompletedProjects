% A=randn(1495,1378,2);
% A=funkce1(A);
% sum(A,'all')/numel(A)

% x=-15:0.01:15;
% y=-x.^2;
% figure,plot(x,y);
% 
% A=randn(5,5);
% c=sum(A(:,1:2:end)')'
% d=sum(A(:,1:2:end),2)
% f=sum(A(1:2:end,:),2)

% syms k n
% simplify(symsum(k.^3,1,n))

% syms x
% f=@(x) (sin(2.*x + 1) + 1) .* (cos(x) - 1)
% fsolve(f,[-pi 0])

x=-2:0.01:1;
y=funkce2(x);
plot(x,y)
fminbnd(@funkce2,-2,-1)

% syms a
% A=[6,-2,a;-3,-6,1;6,1,2];
% determinant=det(A);
% vpa(solve(determinant,a),3)

% a=7.9;
% A=[2*a,-2,1+a;-3,-12,a;-a^.4,-a.^2,2*a^2+1];
% [V D]=eig(A);
% sum(D,'all')

% syms x
% f=@(x) exp(-2.*x.^2-4.*x+3)+cos(x)
% fsolve(f,[1 2])

% syms x
% f=x./(x-1);
% vpa(int(f,-exp(1),0),6)

% D=diag(sort(5*rand(1,5)))