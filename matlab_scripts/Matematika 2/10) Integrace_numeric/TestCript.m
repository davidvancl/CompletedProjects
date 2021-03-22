f = @(x) exp(x);
a = 1;
b = 2;
%% Obd�ln�kov� formule
% f - funkce
% a, b - interval integrov�n�
% n = po�et subinterval�
y1 = obdelnikovaFormule(f,a,b,50)

%% Lichob�n�kov� formule (p�esn�j��)
% f - funkce
% a, b - interval integrov�n�
% n = po�et subinterval�
y2 = lichobeznikFormule(f,a,b,5)

%% Simpsonova formule
% f - funkce
% a, b - interval integrov�n�
% n = po�et subinterval� mus� b�t sud�
y3 = simpsonovaFormule(f,a,b,4)