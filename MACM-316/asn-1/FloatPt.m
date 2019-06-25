% MACM 316 - Homework 1
% Floating Point Arithmetic
% Description: Performs n-fold square-rooting following by squaring of
% the number x
% Instructor: Ben Adcock
% File name: FloatPt.m

clear

n=5;
st=0.001; % Define a stepsize
x=0:st:5; % x is a row vector of numbers between 0 and 1 of increments st
y=x;

for i=1:n
    y=sqrt(y);
end

for i=1:n
    y=y.^2; % The '.' here means the squaring is carried out on each element of y
end

eps = 1;
while (1+eps/2)~=1.0
        eps = eps/2;
end
display(eps);

rel_error=abs(x-y)/abs(x)

abs_error=abs(x-y);

% Plot the output y versus the input x
plot(x,y)
title(['Output of the Computation with n = ' num2str(n)],'fontsize',14)
xlabel(['Input x'],'fontsize',12)
ylabel(['Output y'],'fontsize',12)