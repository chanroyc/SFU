% MACM 316 Assignment 8
% Name       : Roy Chan
% Student ID : 301202770
% E-mail     : chanroyc@sfu.ca
% Filename   : asn8.m



clc % Clear Command Window
clear all % Clear all variables/values in case of residual values from previous runs

T = 200; % Time
h = 0.0005; % Stepsize

% Other variables
N = T/h;


% Initial Conditions
e = 0.6;
q1(1) = 1-e;
q2(1) = 0;

p1(1) = 0;
p2(1) = ((1+e)/(1-e))^0.5;

t(1) = 0;


for n=1:(N+1) 
    % Part 1
    dp1(n)  = -(1/((q1(n))^2 +(q2(n))^2)^(3/2))*q1(n);
    dp2(n)  = -(1/((q1(n))^2 +(q2(n))^2)^(3/2))*q2(n);
    
    dq1(n) = p1(n);
    dq2(n) = p2(n);
    
    t(n+1)=t(n)+h;
    
    q1(n+1)=q1(n)+h*dq1(n);
    q2(n+1)=q2(n)+h*dq2(n);
    
	p1(n+1)=p1(n)+h*dp1(n);
    p2(n+1)=p2(n)+h*dp2(n);
    
    %Part 2
    A1(n) = q1(n)*p2(n) - q2(n)*p1(n);
    H1(n) = (0.5)*((p1(n)^2)+(p2(n)^2)) - 1/(sqrt((q1(n)^2) + (q2(n)^2)));
    
    %Part 3
    q3(n+1) = q1(n)+h*p1(n);
    q4(n+1) = q2(n)+h*p2(n);
    
    p3(n+1) = p1(n)-(h/((q1(n+1))^2+(q2(n+1))^2))*q1(n+1);
    p4(n+1) = p2(n)-(h/((q1(n+1))^2+(q2(n+1))^2))*q2(n+1);
    
    A2(n) = q3(n)*p4(n) - q4(n)*p3(n);
    H2(n) = (0.5)*((p3(n)^2)+(p4(n)^2)) - 1/(sqrt((q3(n)^2) + (q4(n)^2)));
    
    
end

% Plot the graph
figure(1)
plot(q1,q2)
title('Euler''s Method')
xlabel('q_1(t)')
ylabel('q_2(t)')
figure(2)
plot(q3,q4)
title('Symplectic Euler Method')
xlabel('q_{n+1,1}')
ylabel('q_{n+1,2}')

