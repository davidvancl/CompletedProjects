A = [2 1 3 14;1 0 -3 -17;3 -1 4 11];
CH = [6 15 55;15 55 225;55 225 979];
M = [2 1 3;1 0 -3;3 -1 4];
b = [14 -17 11];
%% LU rozklad s èásteènou pivotací
% M - vstupní rozkládaná matice
[L U P] = rozkladLU(M)
% L - dolnní trojúhelníková matice
% U - horní trojúhelníková matice
% P - permutaèní matice
%z = gauss_method(L,b)
%y = gauss_method(U,b)
%x = gauss_method(P,b)

%kontrola rozkladu 
kL = P * M
kR = L * U

%% QR rozklad
% M - vstupní rozkládaná matice
[Q R] = rozkladQR(M)
% Q - ortogonální matice n*n
% R - horní trojúhelníková matice

% kontrola rozkladu
kQ = Q * Q'
kM = Q * R

%% Choleského rozklad
cholL = rozkladCholesky(CH)

%kontrola
kR = cholL * cholL'
