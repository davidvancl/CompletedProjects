M = [-3 2 2 1;1 -3 2 4;4 0 0 7;1 4 -2 5];
A = [2, -3, 8; 4, 6, -7; -5, 4, -9];

%% rozvoj podle radku
% M - vstupní matice
% i - vstupní øádek (index)
D1 = detRadek(A,2)
%% rozvoj podle sloupce
% M - vstupní matice
% i - vstupní sloupec (index)
D2 = detSloupec(M,2)

%% inverzní matice
E = eye(size(M,1));
X = M \ E
