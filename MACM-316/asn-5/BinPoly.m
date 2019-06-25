% MACM 316 - Binary Expressions
% Generates all possible row vectors of length d with {0,1} entries
% Instructor: Ben Adcock
% File name: BinPoly.m

d=8; % Polynomial degree
N=2^(d+1); %Number of binary polynomials of degree <=d
for i=1:N  
    str=dec2base(i-1,2); %Convert the number i-1 to a binary string
    l=length(str);

    % Put the binary representation of i-1 into a row vector b
    b(1:d+1) = -1;
   
    for j=1:l            
        if (str2num(str(j))) == 0
            continue
        else
            b(1,d+1-l+j)= str2num(str(j));
        end
    end
end
R_d = roots(b);
plot(real(R_d),imag(R_d),'*');
axis([-2 2 -2 2]);
title(['Roots of an n x n matrix in the complex plane'],'fontsize',14);
xlabel('Real Axis','fontsize',12);
ylabel('Imaginary Axis','fontsize',12);
sphere(50)