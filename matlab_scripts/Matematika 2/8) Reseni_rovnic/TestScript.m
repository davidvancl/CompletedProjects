f = @(x) x^3 + x - 1;
%% Pøiblížné øešení rovnice pomocí bisekce
% f - zadaná funkce
% from - hodnota zaèínajícího intervalu
% to - koneèná hodnota intervalu
% eps - odchylka

[x iter] = myBisection(f,0,1,eps)
% x - pøibližná hodnota
% iter - poèet iterací bìhem výpoètu

%% Pøibližné øešení rovnic pomocí newtonovy metody
% f - zadaná funkce
% df - derivace funkce
% x0 - iniciální hodnota
% tol - tolerance
% maxit - maximální poèet iterací
df = @(x) 3*x^2 + 1;

[x,it] = myNewton(f,df,0.5,10^(-5),100)
% x - pøibližná hodnota
% iter - poèet iterací bìhem výpoètu

%% Pøibližné øešení pomocí prosté iterace
% f - funkce
% a - dolni mez definicniho oboru
% b - horni mez definicniho oboru
% x0-  pocatecni odhad reseni
% nmax - maximalni pocet iteraci
[x] = prostaIterace(f,-1,1.5,100,10^(-5))
% x - nalezene reseni rovnice
