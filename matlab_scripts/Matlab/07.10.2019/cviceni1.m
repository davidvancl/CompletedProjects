%1)Vygenerujte vektor a pøirozených èísel od 1 do 50.
a= 1:50;

%2)Vygenerujte vektor b, který bude obsahovat racionální èísla od 1 do 10 s krokem 0.2.
b= 1:0.2:10;

%3)Vygenerujte matici A o rozmìrech 3x3, která bude obsahovat samé jednotky,
%nulovou matici B stejných rozmìrù a jednotkovou matici D stejných rozmìrù.
A= ones(3)
B= zeros(size(A))
D= eye(size(A))

%4)Spojte matice A,B a D do matice M o rozmìrech 3x9.
M= [A' B' D']; 

%5)Deklarujte matici C tak, aby mìla následující prvky: 
C= [1 -1 1;1 -1 0;-1 0 1];

%6)Spoètìte inverzní matici matice C a výsledek uložte do matice B1. 
B1= inv(C);

%7)Vynásobte matice C a B1:
    %a%
C * B1
    %b%
C .* B1

%8)Vynásobte (maticovì) matice M a C pøíslušnì transponované tak,
%aby souèin existoval, pokud to vùbec jde. 
 M' * C

%9)Pøepište druhý sloupec C náhodnými hodnotami.
C(:,2) = rand(1,3)

%10)Pøepište první øádek C vlastními vymyšlenými hodnotami.
C(1,:) = [3 2 3]

%11)Z matice C vyberte submatici C1,
%která bude obsahovat prvky prvního øádku z posledních dvou sloupcù.
C(1:1,[2 3])

%12)Prvkùm matice C, které jsou vìtší nebo rovny nule pøiøaïte hodnotu 1.
%Prvkùm, které jsou menší než nula pøiøaïte náhodné hodnoty.
C(C>=0) = 1
C(C<0) = rand(size( C(C<0)))