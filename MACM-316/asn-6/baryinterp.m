function u= baryinterp(x,w,y,grid)
%MACM 316 Assignment 6
% Matlab function to compute the Barycentric form of the interpolating
% polynomial P(x)
% File: baryinterp.m

% Inputs:
% x - interpolation nodes [-1;1] 
% w - Barycentric weights [-0.5;0.5]
% y - values to interpolate 
% grid - fine grid to evaluate the interpolating polynomial P on

% Output:
% u = P(grid) - the values P on the fine grid

n=length(x);
m=length(grid);

u=zeros(m,1);

for i=1:m
    diff=grid(i).*ones(n,1)-x;
    l=sum(diff==0);
    if l==0
        z=w./diff;
        u(i)=(z'*y)/sum(z);
    else
        u(i)=y(find(diff==0));
    end
end
end
