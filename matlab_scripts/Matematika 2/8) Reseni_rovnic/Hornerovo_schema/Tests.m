p = [1 -4 -7 22 24];
s = divider(p);
y = Horn_sch(p,s);
[x,M] = integer_roots(p);
print(x);