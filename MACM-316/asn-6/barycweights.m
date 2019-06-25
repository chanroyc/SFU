function w = barycweights(x)
%MACM 316 Assignment 6
% Matlab function to compute the barycentric weights for chebyshev
% nodes using given formula.
% File: barycweights.m

% Input:
% x - interpolation nodes

% Output:
% w - vector of weights

n=length(x);
w=zeros(n,1);
for i=1:n 
    w(i) = (1/2) * (-1)^(x(i));
end