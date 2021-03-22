M = [-3 2 2 1;1 -3 2 4;4 0 0 7;1 4 -2 5];
A = [2, -3, 8; 4, 6, -7; -5, 4, -9];

%% rozvoj podle radku
% M - vstupn� matice
% i - vstupn� ��dek (index)
D1 = detRadek(A,2)
%% rozvoj podle sloupce
% M - vstupn� matice
% i - vstupn� sloupec (index)
D2 = detSloupec(M,2)

%% inverzn� matice
E = eye(size(M,1));
X = M \ E
