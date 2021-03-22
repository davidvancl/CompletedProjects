A=randn(1495,1378,2);
A=function1(A);
sm=sum(A,'all') / numel(A);

syms x
vpa(int(x ./ (x - 1),-1 * exp(1),0),6);

vpa(int(cos(x)* sin(x) - x,-1,2),6)

