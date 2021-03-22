close all;
clear all;
clc;
%spoètení úlohy ze zadání
% polomìr koule
r = 0.5;
% hmotnost koule
m = 80;
% tvarovy koeficient
Cx = 1/2;
% hustota vzduchu
rhov = 1.29;
% odporovy koeficient, po¡´ateèni rychlost
k = Cx * rhov * pi * r^2;

v0 = 50 / 3.6;

% nastaveni intervalu posunu
h = 25;

% analyticky vypocet (presny)
ta = 0;
va = v0;
i = 1;
while (va(i) > (5 / 3.6))
    tn = ta(i) + h;
    ta = [ta,tn];
    van = v0/(v0 * tn * k / m + 1);
    va = [va,van];
    i = i + 1;
end
va = va.*3.6;

% numericky vypocet
% explicitni
te = 0;
ve = v0;
i = 1;
while (ve(i) > (5 / 3.6))
    ten = te(i) + h;
    te = [te,ten];
    ven = ve(i) + h * (- k * ve(i)^2 / m);
    ve = [ve,ven];
    i = i + 1;
end
ve = ve.*3.6;

% implicitni
ti = 0;
vi = v0;
i = 1;
while (vi(i) > (5 / 3.6))
    tin = ti(i) + h;
    ti = [ti,tin];
    % z rovnice bylo nutne vyjardit vin
    vin = (sqrt(m)*sqrt(4*h*k*vi(i)+m)-m)/(2*h*k);
    vi = [vi,vin];
    i = i + 1;
end
vi = vi.*3.6;
% Zobrazení grafu
figure(1);
plot(ta,va);
figure(2);
plot(te,ve);
figure(3);
plot(ti,vi);