def get_subs(line):
    if line.find(',') != -1:
        subs = line.split(', ')[1:]
        for sub in subs:
            sub = sub.split()
            sub = sub[1:]
            sub = ' '.join(sub)
            if '.' in sub:
                sub = sub[:-1]
            if sub not in bags:
                bags.append(sub)

def search(lines):
    found = False
    for line in lines:
        index = line.index(' contain')
        if 'shiny gold' in line and line[:index] not in bags and line.index('shiny gold') > index:
            bags.append(line[:index])
            found = True
        for bag in bags:
            if bag in line and line[:index] not in bags and line.index(bag) > index :
                bags.append(line[:index])

                # get_subs(line)
                found = True
                break
            # if bag in line and
    if found:
        search(lines)

bags = []
result = 0
with open('input.txt', 'r') as file:
    lines = file.readlines()
    lines = [line.rstrip() for line in lines]

    search(lines)

    for line in lines:
        index = line.index(' contain')
        for bag in bags:
            if bag in line and line.index(bag) < index :
                result += 1

print(f'Result: {result}')
