
def soln():
    with open('input.txt', 'r') as file:
        lines = file.readlines()
        for i in range(len(lines)):
            for j in range(len(lines)):
                for k in range(len(lines)):
                    if i == j or i == k or j == k:
                        continue
                    if int(lines[i]) + int(lines[j]) + int(lines[k]) == 2020:
                        print(int(lines[i]) * int(lines[j]) * int(lines[k]))
                        return


soln()
