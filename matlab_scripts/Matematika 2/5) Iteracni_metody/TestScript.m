%% Generov�n� zad�n�
n=4;
tol=1e-5;
A=gallery('poisson',n);
b=rand(n,1);

%% Itera�n� metody
% A - vygenerovan� matice
% b - prav� strana matice
% tol - tolerance v�po�tu
%% Jacobiho (paraleln�)
[x0, iter0] = method_jacob(A,b,tol)

%% Gauss-Siedlova (sekven�n�)
[x1, iter1] = method_gauss(A,b,tol)

% x - v�sledn� vektor
% iter - ��slo posledn� iterace