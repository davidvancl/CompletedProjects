%% Generování zadání
n=4;
tol=1e-5;
A=gallery('poisson',n);
b=rand(n,1);

%% Iteraèní metody
% A - vygenerovaná matice
% b - pravá strana matice
% tol - tolerance výpoètu
%% Jacobiho (paralelní)
[x0, iter0] = method_jacob(A,b,tol)

%% Gauss-Siedlova (sekvenèní)
[x1, iter1] = method_gauss(A,b,tol)

% x - výsledný vektor
% iter - èíslo poslední iterace