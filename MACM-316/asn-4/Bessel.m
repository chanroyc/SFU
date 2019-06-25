% MACM 316 - Bessel Functions for Homework 4
% Instructor: Ben Adcock
% File name: Bessel.m

% Set Values
c = 100; % Number of Bessel Function iterations
j = zeros(c, 1); % Storage for results of computations
x = zeros(c, 1); % Defining the domain (X-Axis)
x_2 = zeros(33,1);
tol = 1e-15;  % Tolerance
N = 100; % Maximum number of iterations
temp = zeros(100,1); % Array to store data
Bdata = zeros(33, 1); % True data set
pos = 1;

% Compute Bessel Function for 'c' iterations
for i=1:c
    j(i) = besselj(0, i);
    x(i) = i;
end

% Plot the Bessel Function Graph
%plot(x, j, 'LineWidth', 1.5)
%grid on
%legend('J_0', 'Location', 'Best')
%xlabel('X-Axis')
%ylabel('J_0(x)')
%title('First Zero with Bisection Method on Bessel Function')

% Compute Initial 'a' and 'b' for Bisection Method
for h=1:100
    a = h; % value 'a' used to search for zeros
    b = h + 1;
    for i=1:c
        if b == 2
            continue
        else
            b = b + 1;
        end
        % No changes required as values for 'a' and 'b' are opposite signs
        if (besselj(0,a)>0 && besselj(0,b)<0)
            for k = 1:N
                p = a + (b-a)/2;
                if ((b-a)/2<tol)
                    break;
                elseif (besselj(0,p)*besselj(0,a)>0)
                    a = p;
                else
                    b = p;
                end
            end
            temp(h) = p;
            break
        % Same as the above, no changes required
        elseif (besselj(0,a)<0 && besselj(0,b)>0)
            for k = 1:N
                p = a + (b-a)/2;
                if ((b-a)/2<tol)
                    break;
                elseif (besselj(0,p)*besselj(0,a)>0)
                    a = p;
                else
                    b = p;
                end
            end
            temp(h) = p;
            break
        % Continue FOR LOOP to check next value of 'b'
        else
            continue
        end
    end
end

% Fix for code above to get proper set of values
for i=1:99
    if(temp(i) == temp(i+1))
        continue
    elseif(temp(i) == 0)
        continue
    else
        Bdata(pos) = temp(i);
        pos = pos + 1;
    end
end

for i=2:32
    Bdata(i) = Bdata(i+1);
end

for i=1:33
    x_2(i) = i;
end

% Plot X_M
plot(x_2, Bdata, 'LineWidth', 1.5)
grid on
xlabel('X-Axis')
ylabel('Zeros at X_M')
title('Zeros of Bessel Function at X_M')