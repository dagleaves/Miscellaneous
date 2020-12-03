
def check_slope(x, y):
    trees = 0

    with open('input.txt', 'r') as file:
        lines = file.readlines()

        col = 0
        for row in range(0, len(lines), y):
            line = lines[row].rstrip()

            if line[col] == '#':
                trees += 1
            col += x

            # Repeat pattern to the right
            if col >= (len(line) - 1):
                col -= len(line)

    return trees

t1 = check_slope(1, 1)
t2 = check_slope(3, 1)
t3 = check_slope(5, 1)
t4 = check_slope(7, 1)
t5 = check_slope(1, 2)

print(f'Result: {t1 * t2 * t3 * t4 * t5}')
