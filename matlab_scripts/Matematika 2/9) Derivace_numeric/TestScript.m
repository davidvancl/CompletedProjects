%% Numerická derivace pomocí tabulky bodù
%x = -5:0.2:5;
%y = cos(x);
%dy = derivateTable(x,y)
%hold on
%plot(x,y)
%plot(x,dy)
%hold off

%% Zadání hodnot
% bod x = 1
x = 1;
% f - funkce
f = @(x) cos(x);
% df - derivace funkce
df = @(x) sin(x);
% h - jednotlivé kroky
h = 0.0001:0.0001:1;

%% Dopøedná numerická derivace
dy1 = frontDerivate(df,x,h);
%% Zpìtná numerická derivace
dy2 = backDerivate(df,x,h);
%% Centrální numerická derivace
dy3 = centralDerivate(df,x,h);

%% Ukázka jednotlivých krokù
figure(1)
hold on
plot(h,dy1)
plot(h,dy2)
plot(h,dy3)
hold off
%% Ukázka odchylek
figure(2)
hold on
plot(h,f(x) - dy1)
plot(h,f(x) - dy2)
plot(h,f(x) - dy3)
hold off
