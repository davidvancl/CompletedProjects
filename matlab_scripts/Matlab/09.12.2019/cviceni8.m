%% 1]
%A]
krok=0.01;
rozdeleni=0:krok:(2*pi) - krok;
sum(1./(2+ cos(rozdeleni + krok/2))*krok);

syms x
int(1/(2 + cos(x)),0,2*pi);

%B]
krok=0.01;
rozdeleni=0:krok:sqrt(3) - krok;
sum((rozdeleni + krok/2) .* atan(rozdeleni + krok/2) * krok);

syms x
int(x * atan(x),0,sqrt(3));

%C]
krok=0.01;
rozdeleni=0:krok:(2*pi) - krok;
sum(sqrt(1 - sin(2 * (rozdeleni + krok/2))) * krok);

syms x
int(sqrt(1 - sin(2 * x)),0,2*pi);

%D]
krok=0.01;
rozdeleni=-10:krok:5 - krok;
sum(exp(-1 .* (rozdeleni + krok/2).^2) * krok);

syms x
int(exp(-x.^2),-10,5);

%E]
krok=0.01;
rozdeleni=-10000:krok:10000;
sum(exp(-1 .* (rozdeleni + krok/2).^2) * krok);

syms x
int(exp(-x.^2),-10000,10000);

%% 2]
%A]
syms n
symsum((-1).^n .* (1./(2.^(n - 1))),n,1,n);

n=1:50;
sum((-1).^n .* (1./(2.^(n - 1))));
sum((2 .*(-1/2).^50)/3 - 2/3);

%B]
syms n
symsum(1./(n.*(n + 1)),n,1,n);

n=1:50;
sum(1./(n.*(n + 1)));
sum(50 ./(50 + 1));

%C]
syms n
symsum(((-1).^n) .* (1./n),n,1,n); %nelze

n=1:50;
sum((-1).^n .* (1 ./ n));
sum((-1)^50/50);

%D]
syms n
symsum((2 .* n - 1) ./ 2.^n,n,1,n);
n=1:50;
sum((2 .* n - 1) ./ 2.^n);
sum(3 - 2/2^(50 + 1)*(2*50 + 3));

%% 3]
clear
syms alpha;
A = [   1   7   alpha;alpha^2 3   1-alpha;0   5   6];
fplot(det(A),[-10,10])
fa = matlabFunction(det(A));
Y = fa((-10:0.1:10));
lMaxA = nonzeros((islocalmax(Y).*Y));
lMinA = nonzeros(islocalmin(Y).*Y);

figure()
B = [ alpha     8      -3*alpha;1   (1-alpha)^2   alpha;3       -1       4];
fplot(det(B), [-10,10])
fb = matlabFunction(det(B));
Y = fb((-10:0.1:10));
lMaxB = nonzeros((islocalmax(Y).*Y));%není
lMinB = nonzeros(islocalmin(Y).*Y); %