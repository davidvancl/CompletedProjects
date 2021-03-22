%1)
vec = 0:pi/3:2*pi;
x1 = sin(vec);
x2 = cos(vec);
plot(x1,x2);
axis square
%2)
result = function2(1);

%3)
vecx = -5:0.05:5;
%a
res = figure;
hold on;
plot(function2(vecx));
plot(function2(vecx,1));
plot(function2(vecx,2));
saveas(res,'a.jpg');
saveas(res,'a.bmp');
saveas(res,'a.pdf');

%b
res = figure;
a1 = subplot(3,1,1);
plot(function2(vecx),'red');
title('f(x)');
legend('graf');
xlabel('axis X');
ylabel('axis Y');

a2 = subplot(3,1,2);
plot(function2(vecx,1),'yellow');
title('f(x,1)');
legend('graf');
xlabel('axis X');
ylabel('axis Y');

a3 = subplot(3,1,3);
plot(function2(vecx,2),'blue');
title('f(x,2)');
legend('graf');
xlabel('axis X');
ylabel('axis Y');
saveas(res,'b.fig');

linkaxes([a1,a2,a3],'x');

%3)
hold off
res = figure;
x = -5:0.1:5;
y = -6:0.2:6;
[X,Y] = meshgrid(x,y);
mesh(X,Y,function2(X,Y));