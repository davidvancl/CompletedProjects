function L = rozkladCholesky(M)
n = length( M );
L = zeros( n, n );
for i=1:n
   % i = j
   L(i, i) = sqrt(M(i, i) - L(i, :)*L(i, :)');
   % i ~= k
   for j=(i + 1):n
      L(j, i) = (M(j, i) - L(i,:)*L(j ,:)')/L(i, i);
   end
end
end