A1 = [1 1 1;1 2 3;1 3 6];
A = [1, 1, 0; 1, 1, 1; 0, 1, 1];
y0 = [1 1 1]';

%% Mocninná metoda pro nalezení dominantního vlastního èísla a vektoru
% eig() funkce v matlabu
[VE VA] = eig(A)
% vlastní funkce
[v3 e3] = mocninna_metoda(y0,A,1/10)
