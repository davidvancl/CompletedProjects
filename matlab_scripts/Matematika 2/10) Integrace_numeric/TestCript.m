f = @(x) exp(x);
a = 1;
b = 2;
%% Obdélníková formule
% f - funkce
% a, b - interval integrování
% n = poèet subintervalù
y1 = obdelnikovaFormule(f,a,b,50)

%% Lichobìžníková formule (pøesnìjší)
% f - funkce
% a, b - interval integrování
% n = poèet subintervalù
y2 = lichobeznikFormule(f,a,b,5)

%% Simpsonova formule
% f - funkce
% a, b - interval integrování
% n = poèet subintervalù musí být sudý
y3 = simpsonovaFormule(f,a,b,4)