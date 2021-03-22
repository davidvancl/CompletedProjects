%1]
x=-10:0.1:10;
y=function1(x);
minimum2a4X=fminbnd(@function1,2,4);
minimum4a6X=fminbnd(@function1,4,6);
minimum2a4Y=function1(fminbnd(@function1,2,4));
minimum4a6Y=function1(fminbnd(@function1,4,6));
plot(x,y);

%2]
x=10:0.1:16;
y=function2(x);
globMinimumX=fminbnd(@function2,10,16);
globMinimumY=function2(fminbnd(@function2,10,16));

%3]
x=[-2:0.1:2;-2:0.1:2];
y=function3(x);
plot(x(1,:),y);
minBezOmezeni=fminsearch(@function3,x(:,1));

%4]
x = optimvar('x','LowerBound',-50,'UpperBound',50);
y = optimvar('y','LowerBound',-50,'UpperBound',50);
z = optimvar('z','LowerBound',-50,'UpperBound',50);
prob = optimproblem('Objective',-5*x -2*y -6*z ,'ObjectiveSense','min');
prob.Constraints.c1 = x - y + z <= 20;
prob.Constraints.c2 = 3*x + 2*y + 4*z <= 42;
prob.Constraints.c3 = 3*x + 2*y + 0*z <= 30;
prob.Constraints.c4 = x + 0*y + 0*z >= 0;
prob.Constraints.c5 = 0*x + y + 0*z >= 0;
prob.Constraints.c6 = 0*x + 0*y + z >= 0;
[sol,fval,exitflag,output] = linprog(prob2struct(prob));
sol;

%5]
x = optimvar('x',3);
obj = 4*x(1)^2 + 2*x(2)^2 + 3*x(3)^2 + 2*x(1)*x(2) - 3*x(2)*x(3) - x(1);
prob = optimproblem('Objective',obj,'ObjectiveSense','min');
prob.Constraints.cons1 = x(1) - x(2) + x(3) <= -1;
prob.Constraints.cons2 = x(1) + 2*x(2) - 6*x(3) <= 5;
prob.Constraints.cons3 = x(1) + 0*x(2) + 0*x(3) >= 0;
prob.Constraints.cons4 = 0*x(1) + x(2) + 0*x(3) >= 0;
prob.Constraints.cons5 = 0*x(1) + 0*x(2) + x(3) >= 0;
problem = prob2struct(prob);
[x,fval2] = quadprog(problem);
x;
