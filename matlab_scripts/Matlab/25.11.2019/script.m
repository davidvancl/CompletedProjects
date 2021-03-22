close all;
clear
res = figure;
x = -pi:0.1:1;
xx = 1:0.1:2;
yy = function1(xx);
y=function1(x);
limFce1zprava=function1(1+eps);
limFce1zleva=function1(1-eps);
limFceN1zprava=function1(1000000);
limFceN1zleva=function1(-1000000);
plot(x,y,'blue');
hold on
plot(xx,yy,'blue');
saveas(res,'fx','epsc')
hold off


res = figure;
x = -pi:0.1:pi;
y=function2(x);
limFce2zprava=function2(1+eps);
limFce2zleva=function2(1-eps);
limFceN2zprava=function2(1000000);
limFceN2zleva=function2(-1000000);
y(imag(y) ~= 0) = NaN
plot(x,y,'blue');

saveas(res,'gx','epsc')

res = figure;
x = 0:0.1:2;
y=function3(x);
limFce3zprava=function3(1+eps);
limFce3zleva=function3(1-eps);
limFceN3zprava=function3(1000000);
limFceN3zleva=function3(-1000000);
plot(x,y,'blue');
saveas(res,'hx','epsc')