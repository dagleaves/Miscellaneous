valid = 0

with open('input.txt', 'r') as file:
    lines = file.readlines()
    for line in lines:
        info = line.split()

        min_max = info[0].split('-')
        min_ = int(min_max[0])
        max_ = int(min_max[1])

        letter = info[1][0]

        pwd = info[2]

        count = pwd.count(letter)

        if count >= min_ and count <= max_:
            valid += 1

print(f'Valid Passwords: {valid}')
