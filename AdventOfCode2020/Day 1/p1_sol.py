with open('input.txt', 'r') as file:
    lines = file.readlines()
    for i in range(len(lines)):
        for j in range(len(lines)):
            if i == j:
                continue
            if (int(lines[i]) + int(lines[j])) == 2020:
                print(f'First num: {lines[i]}\nSecond Num: {lines[j]}\nProduct: {int(lines[i]) * int(lines[j])}')
