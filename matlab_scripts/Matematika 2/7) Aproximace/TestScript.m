x=[-1, 1, 2, 3];
y=[-6, -2, -3, 2];
%% Aproximace pomoc� Vander matice
% x - hodnoty na ose x
% y - hodnoty na ose y dan� funkce
[xout yout] = vanderMatrix(x,y);
% xout - aproximovan� hodnoty na ose x
% yout - aproximovan� hodnoty na ose y

% uk�zka aproximace
figure(1)
hold on
plot(xout,yout);
plot(x,y)
hold off

%% Aproximace pomoc� Lagrange polynomu
% x - hodnoty na ose x
% y - hodnoty na ose y dan� funkce
[xout yout] = lagrangePolynom(x,y);
% xout - aproximovan� hodnoty na ose x
% yout - aproximovan� hodnoty na ose y

% uk�zka aproximace
figure(2)
hold on
plot(xout,yout);
plot(x,y);
hold off

%% Aproximace pomoc� Newtonova polynomu
% x - hodnoty na ose x
% y - hodnoty na ose y dan� funkce
[xout yout] = newtonPolynom(x,y);
% xout - aproximovan� hodnoty na ose x
% yout - aproximovan� hodnoty na ose y
figure(3)
hold on
plot(xout,yout);
plot(x,y);
hold off
