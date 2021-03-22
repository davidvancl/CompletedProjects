lambda=roots([1,-4,4]);
V=vander(lambda)';
A=V\[2;1];
F0=A'*lambda.^0
F1=A'*lambda.^1
F2=A'*lambda.^2
F3=A'*lambda.^3
F4=A'*lambda.^4

QF=[0 1;1 1];

