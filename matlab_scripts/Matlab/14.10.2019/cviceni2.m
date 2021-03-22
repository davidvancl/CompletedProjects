%1)Vygenerujte 3D pole C s n�hodn�mi rozm�ry v rozsahu 10 - 40,
%ke generov�n�rozm�r� pou�ijte p��kaz rand, kzaokrouhlov�n� floor,
%ceil, fix nebo round a kegenerov�n� prvk� matice p��kaz randn.
C=randn(floor(10 + 30 .*rand(1,1)),floor(10 + 30 .*rand(1,1)),floor(10 + 30 .*rand(1,1)));

%2)a Spo��tejte pr�m�r v�ech prvk� C s pou�it�m for
sm=0;
cn=0;
for i=1:size(C,1)
    for j=1:size(C,2)
        for k=1:size(C,3)
            sm = sm + C(i,j,k);
            cn = cn + 1;
        end
    end
end
a = sm / cn;

%2)b Spo��tejte pr�m�r v�ech prvk� C s pou�it�m sum
b = sum(C(:)) / length(C(:));

%3)P�eve�te pole C(1,:,:) na 2D matici pomoc� p��kazu squeeze 
%a od ka�d�ho ��dku v�sledn� matice ode�t�te jeho pr�m�rnou hodnotu
%(jin�mi slovy ode�t�te ��dkov� pr�m�ry � viz p�edn�ka).
Cq = squeeze(C(1,:,:));
for j=1:size(Cq,1)
   sum(Cq(j,:)) = sum(Cq(j,:)) - (sum(Cq(j,:)) / length(Cq(j,:)));
end

%4)Naprogramujte funkci, kter� zka�d�ho prvku x vstupn� prom�nn� vrac�
%hodnotu sin2(x)cos(x), a tedy funguje stejn� jako standardn� funkce vMatlabu
%(tj. �po prvc�ch�). Knaprogramov�n� funkce nepou��vejte cykl� for nebo while
%. Optim�ln� d�lka k�du jsou 2 ��dky
result = myFunction(50)
