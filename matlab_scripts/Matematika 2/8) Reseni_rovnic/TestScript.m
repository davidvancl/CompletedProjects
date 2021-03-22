f = @(x) x^3 + x - 1;
%% P�ibl�n� �e�en� rovnice pomoc� bisekce
% f - zadan� funkce
% from - hodnota za��naj�c�ho intervalu
% to - kone�n� hodnota intervalu
% eps - odchylka

[x iter] = myBisection(f,0,1,eps)
% x - p�ibli�n� hodnota
% iter - po�et iterac� b�hem v�po�tu

%% P�ibli�n� �e�en� rovnic pomoc� newtonovy metody
% f - zadan� funkce
% df - derivace funkce
% x0 - inici�ln� hodnota
% tol - tolerance
% maxit - maxim�ln� po�et iterac�
df = @(x) 3*x^2 + 1;

[x,it] = myNewton(f,df,0.5,10^(-5),100)
% x - p�ibli�n� hodnota
% iter - po�et iterac� b�hem v�po�tu

%% P�ibli�n� �e�en� pomoc� prost� iterace
% f - funkce
% a - dolni mez definicniho oboru
% b - horni mez definicniho oboru
% x0-  pocatecni odhad reseni
% nmax - maximalni pocet iteraci
[x] = prostaIterace(f,-1,1.5,100,10^(-5))
% x - nalezene reseni rovnice
