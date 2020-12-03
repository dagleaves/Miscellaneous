trees = 0

with open('input.txt', 'r') as file:
    lines = file.readlines()
    col = 0
    for line in lines:
        line = line.rstrip()    # Return character threw off lines
        if line[col] == '#':
            trees += 1
        col += 3
        # Repeat pattern to the right
        if col >= (len(line) - 1):
            col -= len(line)

print(f'Trees Encountered: {trees}')
