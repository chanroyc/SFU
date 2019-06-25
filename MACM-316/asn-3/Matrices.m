% MACM 316 - Matrices for Homework 3 
% Generates different types of random matrices of size N
% Instructor: Ben Adcock
% File name: Matrices.m

% Make sure to comment out the matrices you don't need
Ntr = 100; % Number of trials
N = 50; % Matrix Size
s = 50; % Step size
num_m = 20; % Number of matrices to go through
times = zeros(Ntr, 1); % Vector to for mean time calculation
T = zeros(num_m, 1); % Mean time results
N_vec = zeros(num_m,1); % Vector of Matrix sizes;

% Random matrix
for j=1:num_m

for i=1:Ntr
   
    % Replace Code in this Loop to change Matrices
    A=randn(N,N);
    b=randn(N,1);
    tic;
    x=A\b;
    times(i)=toc;
end
T(j) = mean(times);
N_vec(j) = N;
N = N + s;
end

scatter(log10(N_vec),log10(T), '+')
title(['log_{10}(N) versus log_{10}(T_{avg})'],'fontsize',14)
xlabel('log_{10}(N)','fontsize',12)
ylabel('log_{10}(T_{avg})','fontsize',12)

% ******************** Random Matrix ********************

%A=randn(N,N);
%b=randn(N,1);
%tic;
%x=A\b;
%times(i)=toc;

% ******************** Diagonally dominant ********************

%A=randn(N,N);
%A=A-diag(diag(A));
%A=A+diag(1+sum(abs(A),2));
%b=randn(N,1);
%tic;
%x=A\b;
%times(i)=toc;

% ******************** Upper triangular ********************

%A=randn(N,N);
%A=triu(A);
%b=randn(N,1);
%tic;
%x=A\b;
%times(i)=toc;

% *********************** Tridiagonal ***********************

%A=diag(randn(N-1,1),-1)+diag(randn(N-1,1),1)+diag(randn(N,1));
%b=randn(N,1);
%tic;
%x=A\b;
%times(i)=toc;

% ******************** Tridiagonal sparse ********************

%b1=randn(N,1);
%b2=rand(N,1);
%b3=rand(N,1);
%A=spdiags([b1 b2 b3],-1:1,N,N);
%c=rand(N,1);
%tic;
%x=A\c;
%times(i)=toc;
