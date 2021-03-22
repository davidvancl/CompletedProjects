%1)Vygenerujte vektor a p�irozen�ch ��sel od 1 do 50.
a= 1:50;

%2)Vygenerujte vektor b, kter� bude obsahovat racion�ln� ��sla od 1 do 10 s krokem 0.2.
b= 1:0.2:10;

%3)Vygenerujte matici A o rozm�rech 3x3, kter� bude obsahovat sam� jednotky,
%nulovou matici B stejn�ch rozm�r� a jednotkovou matici D stejn�ch rozm�r�.
A= ones(3)
B= zeros(size(A))
D= eye(size(A))

%4)Spojte matice A,B a D do matice M o rozm�rech 3x9.
M= [A' B' D']; 

%5)Deklarujte matici C tak, aby m�la n�sleduj�c� prvky: 
C= [1 -1 1;1 -1 0;-1 0 1];

%6)Spo�t�te inverzn� matici matice C a v�sledek ulo�te do matice B1. 
B1= inv(C);

%7)Vyn�sobte matice C a B1:
    %a%
C * B1
    %b%
C .* B1

%8)Vyn�sobte (maticov�) matice M a C p��slu�n� transponovan� tak,
%aby sou�in existoval, pokud to v�bec jde. 
 M' * C

%9)P�epi�te druh� sloupec C n�hodn�mi hodnotami.
C(:,2) = rand(1,3)

%10)P�epi�te prvn� ��dek C vlastn�mi vymy�len�mi hodnotami.
C(1,:) = [3 2 3]

%11)Z matice C vyberte submatici C1,
%kter� bude obsahovat prvky prvn�ho ��dku z posledn�ch dvou sloupc�.
C(1:1,[2 3])

%12)Prvk�m matice C, kter� jsou v�t�� nebo rovny nule p�i�a�te hodnotu 1.
%Prvk�m, kter� jsou men�� ne� nula p�i�a�te n�hodn� hodnoty.
C(C>=0) = 1
C(C<0) = rand(size( C(C<0)))