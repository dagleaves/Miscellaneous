valid = 0

with open('input.txt', 'r') as file:
    lines = file.readlines()
    for line in lines:
        info = line.split()

        indices = info[0].split('-')
        index_1 = int(indices[0]) - 1
        index_2 = int(indices[1]) - 1

        letter = info[1][0]

        pwd = info[2]

        # XOR -- only valid if exactly one of the two indices contains the letter
        if bool(pwd[index_1] == letter) ^ bool(pwd[index_2] == letter):
            valid += 1

print(f'Valid Passwords: {valid}')
