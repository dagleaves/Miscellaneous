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

def find_end(pp, loc):
    end = pp.find(' ', loc)
    if end == -1:
        return len(pp)
    return end

def check_byr(pp):
    loc = pp.find('byr')
    if loc == -1:
        return False
    end = find_end(pp, loc)
    byr = pp[loc + 4 : end]

    if len(byr) != 4 or int(byr) < 1920 or int(byr) > 2002:
        return False
    return True

def check_iyr(pp):
    loc = pp.find('iyr')
    if loc == -1:
        return False
    end = find_end(pp, loc)
    iyr = pp[loc + 4 : end]

    if len(iyr) != 4 or int(iyr) < 2010 or int(iyr) > 2020:
        return False
    return True

def check_eyr(pp):
    loc = pp.find('eyr')
    if loc == -1:
        return False
    end = find_end(pp, loc)
    eyr = pp[loc + 4 : end]

    if len(eyr) != 4 or int(eyr) < 2020 or int(eyr) > 2030:
        return False
    return True

def check_hgt(pp):
    loc = pp.find('hgt')
    if loc == -1:
        return False
    end = find_end(pp, loc)
    hgt_units = pp[loc + 4 : end]
    hgt = hgt_units[:-2]

    if hgt_units[-2:] != 'cm' and hgt_units[-2:] != 'in':
        return False

    if hgt_units[-2:] == 'cm':
        if int(hgt) < 150 or int(hgt) > 193:
            return False
    if hgt_units[-2:] == 'in':
        if int(hgt) < 59 or int(hgt) > 76:
            return False
    return True

def check_hcl(pp):
    loc = pp.find('hcl:#')
    if loc == -1:
        return False
    end = find_end(pp, loc)
    hcl = pp[loc + 5 : end]

    if len(hcl) != 6:
        return False

    valid_chars = 'abcdef0123456789'
    for c in hcl:
        if c not in valid_chars:
            return False
    return True

def check_ecl(pp):
    loc = pp.find('ecl')
    if loc == -1:
        return False
    end = find_end(pp, loc)
    ecl = pp[loc + 4 : end]

    valid_ecls = ['amb', 'blu', 'brn', 'gry', 'grn', 'hzl', 'oth']
    if ecl not in valid_ecls:
        return False
    return True

def check_pid(pp):
    loc = pp.find('pid')
    if loc == -1:
        return False
    end = find_end(pp, loc)
    pid = pp[loc + 4 : end]

    if len(pid) != 9:
        return False
    return True


valid = 0
def check_reqs(pp):
    global valid
    if check_byr(pp) and check_iyr(pp) and check_eyr(pp) and check_hgt(pp) and check_hcl(pp) and check_ecl(pp) and check_pid(pp):
        valid += 1

for passport in passports:
    check_reqs(passport)

print(f'Valid Passports: {valid}')
