MG = [1 3 -4; 2 -7 3;3 4 -7];
bG = [7 1 1];
MC = [2 -3 1;1 2 -1;2 1 1];
bC = [0 3 12];
%% Gaussova elimina�n� metoda
% s ��ste�nou pivotac�
% M - vstupn� matice
% b - prav� strana matice
xg = gauss_method(MG,bG)'
% xg - vypo�ten� koeficienty 
%% Cramerovo pravidlo
% M - vstupn� matice
% b - prav� strana matice
xc = cramer_method(MG,bG)
% xc = vypo�ten� koeficienty