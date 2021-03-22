%1)Vygenerujte 3D pole C s náhodnými rozmìry v rozsahu 10 - 40,
%ke generovánírozmìrù použijte pøíkaz rand, kzaokrouhlování floor,
%ceil, fix nebo round a kegenerování prvkù matice pøíkaz randn.
C=randn(floor(10 + 30 .*rand(1,1)),floor(10 + 30 .*rand(1,1)),floor(10 + 30 .*rand(1,1)));

%2)a Spoèítejte prùmìr všech prvkù C s použitím for
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

%2)b Spoèítejte prùmìr všech prvkù C s použitím sum
b = sum(C(:)) / length(C(:));

%3)Pøeveïte pole C(1,:,:) na 2D matici pomocí pøíkazu squeeze 
%a od každého øádku výsledné matice odeètìte jeho prùmìrnou hodnotu
%(jinými slovy odeètìte øádkové prùmìry – viz pøednáška).
Cq = squeeze(C(1,:,:));
for j=1:size(Cq,1)
   sum(Cq(j,:)) = sum(Cq(j,:)) - (sum(Cq(j,:)) / length(Cq(j,:)));
end

%4)Naprogramujte funkci, která zkaždého prvku x vstupní promìnné vrací
%hodnotu sin2(x)cos(x), a tedy funguje stejnì jako standardní funkce vMatlabu
%(tj. „po prvcích“). Knaprogramování funkce nepoužívejte cyklù for nebo while
%. Optimální délka kódu jsou 2 øádky
result = myFunction(50)
