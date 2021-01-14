
groups = []
with open('input.txt', 'r') as file:
    lines = file.readlines()
    lines = [line.rstrip() for line in lines]

    index = 0
    for i in range(len(lines)):
        line = lines[i]
        if line == '':
            index += 1
        elif i == 0:
            groups.append(line)
        elif lines[i-1] == '':
            groups.append(line)
        else:
            groups[index] += f'{line}'

result = 0
for group in groups:
    result += len(set(group))
print(f'Result: {result}')
