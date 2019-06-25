% MACM316    : Assignment 7
% Name       : Roy Chan
% ID         : 301202770
% Instructor : Ben Adcock
% File       : asn7.m

%%%%% StandardNormal Quadrature %%%%%
format long
% Variable declarations
f = @(x) x.^(-1).*sin(x.^(-1).*log(x)); % Function
n = 100; % Number of roots to compute
a = zeros(1, n); % Row vector to store roots
ct = 1; % Counter
Q = zeros(1, n); % Store approximations 
x = zeros(1, n); % Vector of values of 'n' for plot

% Compute roots
for i=1:n
    b = fzero(@(x) x*exp(x)-i*pi,0);
    a(i) = exp(-b);
end

% Compute exact value for integral
for i=1:n-1    
    I=integral(f,a(i),1);
    Q(ct) = I;
    x(ct) = ct;
    ct = ct + 1;
end

% Plot the graph
figure(1)
plot(x(1:n-1), Q(1:n-1))
xlabel('n', 'fontsize', 12);
ylabel('Q_n', 'fontsize', 12);
title('Approximation of I=Q_n with Roots A_i computed via Numerical Quadrature', 'fontsize', 12);


%%%%% Aitkens Delta Squared %%%%%

% Variable Declarations
Q_hat = zeros(1, n); % Row vector storing results of Aitkens

% Compute Approximations
for i=1:n-2
    Q_hat(i) = Q(i) - ((Q(i+1) - Q(i+2))^2) / (Q(i+2) - 2*Q(i+1) + Q(i));
end

% Plot the graph
figure(2)
plot(x(1:n-3), Q_hat(1:n-3));
xlabel('n', 'fontsize', 12);
ylabel('Q_{hat,n}', 'fontsize', 12);
title('Approximation of I=Q_{hat,n} with Roots A_i computed via Aitkens ', 'fontsize', 14);
