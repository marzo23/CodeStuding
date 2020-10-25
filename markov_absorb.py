'''
foobar:~/ MariscalCristina23$ cat doomsday-fuel/readme.txt 
Doomsday Fuel
=============

Making fuel for the LAMBCHOP's reactor core is a tricky process because of the exotic matter involved. It starts as raw ore, then during processing, begins randomly changing between forms, eventually reaching a stable form. There may be multiple stable forms that a sample could ultimately reach, not all of which are useful as fuel. 

Commander Lambda has tasked you to help the scientists increase fuel creation efficiency by predicting the end state of a given ore sample. You have carefully studied the different structures that the ore can take and which transitions it undergoes. It appears that, while random, the probability of each structure transforming is fixed. That is, each time the ore is in 1 state, it has the same probabilities of entering the next state (which might be the same state).  You have recorded the observed transitions in a matrix. The others in the lab have hypothesized more exotic forms that the ore can become, but you haven't seen all of them.

Write a function solution(m) that takes an array of array of nonnegative ints representing how many times that state has gone to the next state and return an array of ints for each terminal state giving the exact probabilities of each terminal state, represented as the numerator for each state, then the denominator for all of them at the end and in simplest form. The matrix is at most 10 by 10. It is guaranteed that no matter which state the ore is in, there is a path from that state to a terminal state. That is, the processing will always eventually end in a stable state. The ore starts in state 0. The denominator will fit within a signed 32-bit integer during the calculation, as long as the fraction is simplified regularly. 

For example, consider the matrix m:
[
  [0,1,0,0,0,1],  # s0, the initial state, goes to s1 and s5 with equal probability
  [4,0,0,3,2,0],  # s1 can become s0, s3, or s4, but with different probabilities
  [0,0,0,0,0,0],  # s2 is terminal, and unreachable (never observed in practice)
  [0,0,0,0,0,0],  # s3 is terminal
  [0,0,0,0,0,0],  # s4 is terminal
  [0,0,0,0,0,0],  # s5 is terminal
]
So, we can consider different paths to terminal states, such as:
s0 -> s1 -> s3
s0 -> s1 -> s0 -> s1 -> s0 -> s1 -> s4
s0 -> s1 -> s0 -> s5
Tracing the probabilities of each, we find that
s2 has probability 0
s3 has probability 3/14
s4 has probability 1/7
s5 has probability 9/14
So, putting that together, and making a common denominator, gives an answer in the form of
[s2.numerator, s3.numerator, s4.numerator, s5.numerator, denominator] which is
[0, 3, 2, 9, 14].

Languages
=========

To provide a Java solution, edit Solution.java
To provide a Python solution, edit solution.py

Test cases
==========
Your code should pass the following test cases.
Note that it may also be run against hidden test cases not shown here.

-- Java cases --
Input:
Solution.solution({{0, 2, 1, 0, 0}, {0, 0, 0, 3, 4}, {0, 0, 0, 0, 0}, {0, 0, 0, 0,0}, {0, 0, 0, 0, 0}})
Output:
    [7, 6, 8, 21]

Input:
Solution.solution({{0, 1, 0, 0, 0, 1}, {4, 0, 0, 3, 2, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}})
Output:
    [0, 3, 2, 9, 14]

-- Python cases --
Input:
solution.solution([[0, 2, 1, 0, 0], [0, 0, 0, 3, 4], [0, 0, 0, 0, 0], [0, 0, 0, 0,0], [0, 0, 0, 0, 0]])
Output:
    [7, 6, 8, 21]

Input:
solution.solution([[0, 1, 0, 0, 0, 1], [4, 0, 0, 3, 2, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0]])
Output:
    [0, 3, 2, 9, 14]

Use verify [file] to test your solution and see how it does. When you are finished editing your code, use submit [file] to submit your answer. If your solution passes the test cases, it will be removed from your home folder.
foobar:~/ MariscalCristina23$  

'''

from fractions import Fraction

def get_states_lists(matrix):
    terminal_list = []
    non_terminal_list = []
    for state in range(len(matrix)):
        summ = sum(matrix[state])
        if summ == 0:
            terminal_list.append(state)
        else:
            non_terminal_list.append(state)
    return terminal_list, non_terminal_list

def build_identity_matrix(length):
    matrix = []
    for i in range(length):
        matrix.append([0]*length)
        matrix[i][i] = 1
    return matrix

#method to separate non terminal sub matrices
def get_non_terminal_submatrices(matrix):
    terminal_list, non_terminal_list = get_states_lists(matrix)
    sub_matrix_absmkv = []
    sub_matrix_prob = []
    for i in non_terminal_list:
        tmp_a = []
        summ = sum(matrix[i])
        for j in non_terminal_list:
            tmp_a.append(Fraction(matrix[i][j], summ))
        sub_matrix_absmkv.append(tmp_a)
        tmp_b = []
        for j in terminal_list:
            tmp_b.append(Fraction(matrix[i][j], summ))
        sub_matrix_prob.append(tmp_b)
    return sub_matrix_absmkv, sub_matrix_prob

#method to substract matrix1 - matrix2
def substract_matrices(matrix1, matrix2):
    result = []
    for i in range(len(matrix1)):
        row = []
        for j in range(len(matrix1[i])):
            row.append(matrix1[i][j]-matrix2[i][j])
        result.append(row)
    return result

#this was my first try to program determinant method
#I tried with starrus scheme method to calculate determinant, but it went wrong on tests
def get_determinant2(matrix):
    matrix_size = len(matrix)
    matrix_size_x = matrix_size
    if matrix_size == 1:
        return matrix[0][0]
    if matrix_size == 2:
        matrix_size_x -= 1
    determinant = 0
    for i in range(matrix_size_x):
        plus = 1
        minus = 1
        for j in range(matrix_size):
            x = i+j
            if x >= matrix_size :
                x = abs(matrix_size-x)
            plus *= matrix[x][j]
            minus *= matrix[matrix_size-x-1][j]
        determinant += plus - minus
    return determinant

#Laplace expansion method to calculate determinant
def get_determinant(matrix):
    matrix_size = len(matrix)
    if matrix_size == 1:
        return matrix[0][0]
    if matrix_size == 2:
        return matrix[0][0]*matrix[1][1]-matrix[0][1]*matrix[1][0]
    determinant = 0
    for i in range(matrix_size):
        sign = 1 
        if (i)%2 != 0:
            sign = -1
        determinant += get_determinant(build_submatrix_x_y(matrix,0,i)) * matrix[0][i] * sign
    return determinant

#method to build sub matrix by removing X row and Y column
def build_submatrix_x_y(matrix, x, y):
    result = []
    for i in range(len(matrix)):
        if i == x:
            continue
        row = []
        for j in range(len(matrix[i])):
            if j == y:
                continue
            row.append(matrix[i][j])
        result.append(row)
    return result

def build_adjunt_matrix(matrix):
    matrix_size = len(matrix)
    result = []
    for i in range(matrix_size):
        row = []
        for j in range(matrix_size):
            sign = 1 
            if (i+j)%2 != 0:
                sign = -1
            row.append(get_determinant(build_submatrix_x_y(matrix, i,j))*sign)
        result.append(row)
    return result

def build_transpose_matrix(matrix):
    matrix_size = len(matrix)
    result = [[0]*matrix_size  for i in range(matrix_size)]
    for i in range(matrix_size):
        for j in range(matrix_size):
            result[j][i] = matrix[i][j]
    return result

def multiply_matrices(matrix1, matrix2):
    rows1 = len(matrix1)
    cols1 = len(matrix1[0])
    rows2 = len(matrix2)
    cols2 = len(matrix2[0])
    if rows2 != cols1:
        return None
    result = [[0]*cols2 for i in range(rows1)]
    for i in range(rows1):
        for j in range(cols2):
            product = 0
            for k in range(cols1):
                product += matrix1[i][k] * matrix2[k][j]
            result[i][j] = product
    return result

def multiply_matrix_scalar(matrix, scalar):
    matrix_size = len(matrix)
    result = [[0]*matrix_size  for i in range(matrix_size)]
    for i in range(matrix_size):
        for j in range(matrix_size):
            result[i][j] = matrix[i][j] * scalar
    return result

def get_greatest_common_denominator(num1, num2):
    while num2:      
        num1, num2 = num2, num1 % num2
    return num1

def get_lowest_common_multiplier(num1, num2):
    result = num1 * num2 / get_greatest_common_denominator(num1, num2)
    return result

def get_lowest_common_multiplier_from_list(lst):
    list_length = len(lst)
    result = get_lowest_common_multiplier(lst[0], lst[1])
    i = 2
    while i < list_length:
        result = get_lowest_common_multiplier(result, lst[i])
        i += 1
    return result

#method to calculate inverted matrix by determinants
def invert_matrix(matrix):
    determinant = get_determinant(matrix)
    adjunt_matrix = build_adjunt_matrix(matrix)
    transposed_matrix = build_transpose_matrix(adjunt_matrix)
    return determinant, multiply_matrix_scalar(transposed_matrix, Fraction(1, determinant))

#This problem was solved using absorbing Markov chain
#Resources consulted:
#https://en.wikipedia.org/wiki/Absorbing_Markov_chain
#https://www.superprof.es/apuntes/escolar/matematicas/algebralineal/determinantes/matriz-inversa.html
#https://www.superprof.es/apuntes/escolar/matematicas/algebralineal/determinantes/menor-complementario-y-adjunto.html
#for debugging of my code and correct determinant method (didn't coped this code): https://github.com/mkutny/absorbing-markov-chains
def solution(matrix):
    if len(matrix) == 1:
        return [1,1]
    sub_matrix_absmkv, sub_matrix_prob = get_non_terminal_submatrices(matrix)
    identity_matrix = build_identity_matrix(len(sub_matrix_absmkv))
    substracted_matrix = substract_matrices(identity_matrix, sub_matrix_absmkv)
    determinant, inverted_matrix = invert_matrix(substracted_matrix)
    result_matrix = multiply_matrices(inverted_matrix, sub_matrix_prob)
    denominator = get_lowest_common_multiplier_from_list([i.denominator for i in result_matrix[0]])
    result = [denominator*i.numerator/i.denominator for i in result_matrix[0]]
    result.append(denominator)
    return result