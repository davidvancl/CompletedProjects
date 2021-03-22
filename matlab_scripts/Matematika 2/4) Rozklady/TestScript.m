A = [2 1 3 14;1 0 -3 -17;3 -1 4 11];
CH = [6 15 55;15 55 225;55 225 979];
M = [2 1 3;1 0 -3;3 -1 4];
b = [14 -17 11];
%% LU rozklad s ��ste�nou pivotac�
% M - vstupn� rozkl�dan� matice
[L U P] = rozkladLU(M)
% L - dolnn� troj�heln�kov� matice
% U - horn� troj�heln�kov� matice
% P - permuta�n� matice
%z = gauss_method(L,b)
%y = gauss_method(U,b)
%x = gauss_method(P,b)

%kontrola rozkladu 
kL = P * M
kR = L * U

%% QR rozklad
% M - vstupn� rozkl�dan� matice
[Q R] = rozkladQR(M)
% Q - ortogon�ln� matice n*n
% R - horn� troj�heln�kov� matice

% kontrola rozkladu
kQ = Q * Q'
kM = Q * R

%% Cholesk�ho rozklad
cholL = rozkladCholesky(CH)

%kontrola
kR = cholL * cholL'
