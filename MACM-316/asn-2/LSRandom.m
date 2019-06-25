% MACM 316 - Week 2
% Gaussian Elimination for a random matrix
% Description: Computes the mean solution error over M trials for the
% system Ax=b where A is a random NxN matrix and x is a vector of ones.
% Plots the result as a line graph.
% Instructor: Ben Adcock
% File name: LSRandom.m

% Set values below can be changed at users' discretion
N=10; % Matrix size
M=100; % Number of Trials
Q=10; % Number of Data to insert into set

errs=zeros(M,1); % Vector of errors
x=ones(N,1); % Exact solution vector

size_N=zeros(Q,1); % Vector of Trials for plot
EN=zeros(Q,1); % Vector to Store Mean Errors

for i=1:Q
    for j=1:M % Number of Trials: 100
    
        A=randn(N,N); % Construct a random NxN matrix (normally distributed)
        b=A*x; % Compute the right-hand side vector
        z=A\b; % Solve the linear system
    
        errs(j)=max(abs(z-x)); % Compute the error
    end
    % Store Size N and Mean Error correspondingly into Vectors
    size_N(i)= N; % Store Size of N
    EN(i) = mean(errs); % Compute the Mean Error
    N=N+10; % Increment by set amount, default N=N+10, change at users' discretion
    x=ones(N,1); % Update size of Exact Solution Vector
end

% Plot of the log of Errors and N
plot(log10(size_N),log10(EN))
title(['log10(N) versus log10(EN)'],'fontsize',14)
xlabel('log_{10}(N)','fontsize',12)
ylabel('log_{10}(EN)','fontsize',12)