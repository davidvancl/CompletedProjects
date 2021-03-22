%% Numerick� derivace pomoc� tabulky bod�
%x = -5:0.2:5;
%y = cos(x);
%dy = derivateTable(x,y)
%hold on
%plot(x,y)
%plot(x,dy)
%hold off

%% Zad�n� hodnot
% bod x = 1
x = 1;
% f - funkce
f = @(x) cos(x);
% df - derivace funkce
df = @(x) sin(x);
% h - jednotliv� kroky
h = 0.0001:0.0001:1;

%% Dop�edn� numerick� derivace
dy1 = frontDerivate(df,x,h);
%% Zp�tn� numerick� derivace
dy2 = backDerivate(df,x,h);
%% Centr�ln� numerick� derivace
dy3 = centralDerivate(df,x,h);

%% Uk�zka jednotliv�ch krok�
figure(1)
hold on
plot(h,dy1)
plot(h,dy2)
plot(h,dy3)
hold off
%% Uk�zka odchylek
figure(2)
hold on
plot(h,f(x) - dy1)
plot(h,f(x) - dy2)
plot(h,f(x) - dy3)
hold off
