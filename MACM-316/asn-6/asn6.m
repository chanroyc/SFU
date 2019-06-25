format long
% MACM 316 Assignment 6
% Name: Roy Chan
% ID  : 301202770
% File; asn6.m

% Define f(x), comment/uncomment as needed.
%f=@(x)  1./(5-4.*x);
%f=@(x) 1./(1+16.*x.^2);
f=@(x) cos((10.^4).*x);

% Define a grid to evaluate f(x) and P(x) on
m=10000;
x_int=linspace(-1,1,m);
x_int=x_int';
fg=f(x_int);

% Declare variables
jp=5; % Stepsize for n
nmax= 100; % Max n
pc = 1; % Pointer for storing values into res and xax
res = zeros(ceil(nmax/jp), 1); % Vector of results
xax = zeros(ceil(nmax/jp), 1); % x-axis
xax(1) = jp; 
sum = 0;


figure(1);
for n=jp:jp:nmax
    
    x=linspace(-1,1,n); % Define the set of equally-spaced interpolation points x
    y=f(x); % Compute the data
    x=x';
    y=y';
    
    % Compute polynomial interpolant P(x)
        
    %w = baryweights(x);
    
    % Use barycweights(x) when computing f(x) = cos((10^4)x)
    w = barycweights(x);
    
    P = baryinterp(x,w,y,x_int);
    errP = max(abs(fg-P));
    res(pc) = log(errP)
    sum = sum + res(pc);
    if(pc~=1)
        xax(pc) = xax(pc-1) + jp
    end
    pc = pc + 1;
    
end
average = sum / (ceil(nmax/jp))
% Plot the graph
scatter(xax, res, '*');
xlabel('n', 'fontsize', 12);
ylabel('log_{10}(PErr)', 'fontsize', 12);
title('log_{10}(PErr) vs n', 'fontsize', 14);