MG = [1 3 -4; 2 -7 3;3 4 -7];
bG = [7 1 1];
MC = [2 -3 1;1 2 -1;2 1 1];
bC = [0 3 12];
%% Gaussova eliminaèní metoda
% s èásteènou pivotací
% M - vstupní matice
% b - pravá strana matice
xg = gauss_method(MG,bG)'
% xg - vypoètené koeficienty 
%% Cramerovo pravidlo
% M - vstupní matice
% b - pravá strana matice
xc = cramer_method(MG,bG)
% xc = vypoètené koeficienty