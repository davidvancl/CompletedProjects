x=[-1, 1, 2, 3];
y=[-6, -2, -3, 2];
%% Aproximace pomocí Vander matice
% x - hodnoty na ose x
% y - hodnoty na ose y dané funkce
[xout yout] = vanderMatrix(x,y);
% xout - aproximované hodnoty na ose x
% yout - aproximované hodnoty na ose y

% ukázka aproximace
figure(1)
hold on
plot(xout,yout);
plot(x,y)
hold off

%% Aproximace pomocí Lagrange polynomu
% x - hodnoty na ose x
% y - hodnoty na ose y dané funkce
[xout yout] = lagrangePolynom(x,y);
% xout - aproximované hodnoty na ose x
% yout - aproximované hodnoty na ose y

% ukázka aproximace
figure(2)
hold on
plot(xout,yout);
plot(x,y);
hold off

%% Aproximace pomocí Newtonova polynomu
% x - hodnoty na ose x
% y - hodnoty na ose y dané funkce
[xout yout] = newtonPolynom(x,y);
% xout - aproximované hodnoty na ose x
% yout - aproximované hodnoty na ose y
figure(3)
hold on
plot(xout,yout);
plot(x,y);
hold off
