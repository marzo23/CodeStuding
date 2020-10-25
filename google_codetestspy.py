def​ solution(data,​ n):​ 
​ ​ ​ ​ item_dict​ =​ {}
​ ​ ​ ​ for​ item​ in​ data:
​ ​ ​ ​ ​ ​ ​ ​ if​ item​ in​ item_dict:
​ ​ ​ ​ ​ ​ ​ ​ ​ ​ ​ ​ item_dict[item]+=1
​ ​ ​ ​ ​ ​ ​ ​ else:
​ ​ ​ ​ ​ ​ ​ ​ ​ ​ ​ ​ item_dict[item]=1
​ ​ ​ ​ for​ k,v​ in​ item_dict.items():
​ ​ ​ ​ ​ ​ ​ ​ if​ v​ >​ n:
​ ​ ​ ​ ​ ​ ​ ​ ​ ​ ​ ​ data​ =​ list(filter(lambda​ a:​ a​ !=​ k,​ data))
​ ​ ​ ​ return​ data






def solution(data, n):
    item_dict = {}
    for item in data:
        if item in item_dict:
            item_dict[item]+=1
        else:
            item_dict[item]=1
    output = []
    for item in data:
        if item_dict[item] <= n:
            output.append(item)
    return output



def solution(data, n):
    item_dict = {}
    for item in data:
        if item in item_dict:
            item_dict[item]+=1
        else:
            item_dict[item]=1
    for k,v in item_dict.items():
        if v > n:
            data = list(filter(lambda a: a != k, data))
    return data



braille_dict = {
    " " : "000000",
    "a" : "100000",
    "b" : "110000",
    "c" : "100100",
    "d" : "100110",
    "e" : "100010",
    "f" : "110100",
    "g" : "110110",
    "h" : "110010",
    "i" : "010100",
    "j" : "010110",
    "k" : "101000",
    "l" : "111000",
    "m" : "101100",
    "n" : "101110",
    "o" : "101010",
    "p" : "111100",
    "q" : "111110",
    "r" : "111010",
    "s" : "011100",
    "t" : "011110",
    "u" : "101001",
    "v" : "111001",
    "w" : "010111",
    "x" : "101101",
    "y" : "101111",
    "z" : "101011",
    "CAPS" : "000001"
}


def solutionb(input):
    output = ""
    for c in input:
        if c.isupper():
            output+=braille_dict["CAPS"]
        if c.lower() not in braille_dict:
            raise Exception(c+" is not on supported characters")
        output+=braille_dict[c.lower()]
    return output



def solution(l):
    pass

def is_higher_version(v1, v2):
    v1_arr = v1.split(".")
    v2_arr = v2.split(".")
    max_len = max(len(v1_arr), len(v2_arr))
    for i in range(max_len):
        if len(v1_arr)<=i:
            return True
        elif len(v2_arr)<=i:
            return False
        if int(v1_arr[i])>int(v2_arr[i]):
            return True
        elif int(v1_arr[i])<int(v2_arr[i]):
            return False
    return True





def is_higher_version(v1, v2):
    v1_arr = v1.split(".")
    v2_arr = v2.split(".")
    print("lenv1: "+str(v1_arr))
    print("lenv2: "+str(v2_arr))
    max_len = max(len(v1_arr), len(v2_arr))
    print("max: "+str(max_len))
    for i in range(max_len):
        if len(v1_arr)<=i:
            print("holi 1")
            return True
        elif len(v2_arr)<=i:
            print("holi 2")
            return False
        if int(v1_arr[i])>int(v2_arr[i]):
            print("holi 3")
            return True
        elif int(v1_arr[i])<int(v2_arr[i]):
            print("holi 4")
            return False
    print("sale")
    return True





def is_higher_version(v1, v2):
    v1_arr = v1.split(".")
    v2_arr = v2.split(".")
    max_len = max(len(v1_arr), len(v2_arr))
    for i in range(max_len):
        if len(v1_arr)<=i:
            return -1
        elif len(v2_arr)<=i:
            return 1
        if int(v1_arr[i])>int(v2_arr[i]):
            return 1
        elif int(v1_arr[i])<int(v2_arr[i]):
            return -1
    return 0

o = sorted(l, cmp=is_higher_version)



def get_min(n):
    count = 0
    sum = 0
    while sum <= n:
        sum +=2**count
        count+=1
    return count-1

def get_max(n):
    nxt = 1
    prev = 0
    count = 0
    sum = 0
    while sum <= n:
        prev, nxt = nxt, nxt+prev
        sum+=prev
        count +=1
    return count-1

def solution(n):
    return get_max(n) - get_min(n)

solution(143)


def get_fibo(n, cache = {}):
    if n in cache:
        return cache[n]
    if n<2:
        return 1
    cache[n] = get_fibo(n-1, cache = cache) + get_fibo(n-2, cache = cache)
    return cache[n]

import math

def count_divisor(n):
    list = []
    i =0
    while i <= int(math.sqrt(n)):
        i+=1
        if n%i == 0:
            list.append(i)
            list.append(n/i)
    return list


def create_adydic(list):
    graph_dic = {}
    for i in range(len(list)):
        item = list[i]
        if item not in graph_dic:
            graph_dic[item] = {}
            graph_dic[item]["count"] = 1
            graph_dic[item]["divisor"] = []
            for j in range(len(list)):
                if i!=j and i%j == 0:
                    graph_dic[item]["divisor"].append(list[j])
        else:
            graph_dic[i]["count"] += 1
    return graph_dic

def find_triplet(graph_dic):
    count = 0
    for item in graph_dic:
        nums = {}
        

def solution(list):
    i = len(list)
    count = 0
    while i >=2:
        i-=1
        div = 0
        mult = 0
        print("i: "+str(i))
        for j in range(0,i):
            print("div: "+str(j))
            if list[i] % list[j] == 0:
                print("div: sip")
                div += 1
        for j in range(i+1, len(list)):
            print("mult: "+str(j))
            if list[j] % list[i]  == 0:
                print("mult: sip")
                mult += 1
        count += div * mult
    return count



solution([1, 2, 3, 4, 5, 6])


def solution(list):
    i = len(list)
    count = 0
    while i >=2:
        i-=1
        div = 0
        mult = 0
        for j in range(0,i):
            if list[i] % list[j] == 0:
                div += 1
        for j in range(i+1, len(list)):
            if list[j] % list[i]  == 0:
                mult += 1
        count += div * mult
    return count










def get_states_lists(matrix):
    terminal_list = []
    non_terminal_list = []
    for state in range(len(matrix)):
        sum = 0
        for s in matrix[state]:
            sum += s
        if sum == 0:
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

def get_non_terminal_submatrixes(matrix):
    terminal_list, non_terminal_list = get_states_lists(matrix)
    sub_matrix_absmkv = []
    sub_matrix_prob = []
    for i in non_terminal_list:
        tmp_a = []
        for j in non_terminal_list:
            tmp_a.append(matrix[i][j])
        sub_matrix_absmkv.append(tmp_a)
        tmp_b = []
        for j in terminal_list:
            tmp_b.append(matrix[i][j])
        sub_matrix_prob.append(tmp_b)
    return sub_matrix_absmkv, sub_matrix_prob


def substract_matrices(matrix1, matrix2):
    result = []
    for i in range(len(matrix1)):
        row = []
        for j in range(len(matrix1[i])):
            row.append(matrix1[i][j]-matrix2[i][j])
        result.append(row)
    return result

def get_determinant(matrix):
    matrix_size = len(matrix)
    determinant = 0
    for i in range(matrix_size):
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


def get_determinant2(matrix):
    matrix_size = len(matrix)
    determinant = 0
    extended_matrix = [row + row for row in matrix]
    for i in range(matrix_size):
        plus = 1
        minus = 1
        for j in range(matrix_size):
            plus *= extended_matrix[i+j][j]
            minus *= extended_matrix[matrix_size-i-j][j]
        determinant += plus - minus
    return determinant

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
            if (i+j)%2 == 0:
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
    rows1 = len(matrix1) #2
    cols1 = len(matrix1[0]) #2
    rows2 = len(matrix2) #2
    cols2 = len(matrix2[0]) #4
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

def fill_test_matrix():
    count = 0
    result = [[0]*5 for i in range(4)]
    for i in range(4):
        for j in range(5):
            count +=1
            result[i][j] = count
    return result

def invert_matrix(matrix):
    determinant = get_determinant(matrix)
    adjunt_matrix = build_adjunt_matrix(matrix)
    return determinant, build_transpose_matrix(adjunt_matrix)


def soultion(matrix):
    sub_matrix_absmkv, sub_matrix_prob = get_non_terminal_submatrixes(matrix)
    identity_matrix = build_identity_matrix(len(sub_matrix_absmkv))
    substracted_matrix = substract_matrices(identity_matrix, sub_matrix_absmkv)
    determinant, inverted_matrix = invert_matrix(substracted_matrix)
    result_matrix = multiply_matrices(inverted_matrix, sub_matrix_prob)




matrix = [
  [0,1,0,0,0,1],  # s0, the initial state, goes to s1 and s5 with equal probability
  [4,0,0,3,2,0],  # s1 can become s0, s3, or s4, but with different probabilities
  [0,0,0,0,0,0],  # s2 is terminal, and unreachable (never observed in practice)
  [0,0,0,0,0,0],  # s3 is terminal
  [0,0,0,0,0,0],  # s4 is terminal
  [0,0,0,0,0,0],  # s5 is terminal
]



class solution:
    @staticmethod
    def solution(input_list, num):
        item_dict = {}
        for item in input_list:
            if item in item_dict:
                item_dict[item]+=1
            else:
                item_dict[item]=1
        for k,v in item_dict.items():
            if v > num:
                input_list = list(filter(lambda a: a != k, input_list))
        return input_list