function w = baryweights(x)
% MACM 316 Assignment 6
% Matlab function to compute the barycentric weights w
% File: baryweights.m

% Input:
% x - interpolation nodes

% Output:
% w - vector of barycentric weights

n=length(x);
w=zeros(n,1);
for i=1:n 
    X=x-x(i)*ones(n,1);
    X=X([1:i-1 i+1:n],1);
    w(i)=1/prod(X);
end