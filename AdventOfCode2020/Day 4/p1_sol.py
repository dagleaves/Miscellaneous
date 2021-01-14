passports = []
with open('input.txt', 'r') as file:
    lines = file.readlines()

    index = 0
    for i in range(len(lines)):
        line = lines[i].rstrip()
        if line == '':
            index += 1
        elif i == 0:
            passports.append(line)
        elif lines[i-1].rstrip() == '':
            passports.append(line)
        else:
            passports[index] += f' {line}'


reqs = ['ecl', 'pid', 'eyr', 'hcl', 'byr', 'iyr', 'hgt'] # cid not included

valid = 0
def check_reqs(pp):
    global valid
    for req in reqs:
        if req not in pp:
            return
    valid += 1

for passport in passports:
    check_reqs(passport)

print(f'Valid Passports: {valid}')
