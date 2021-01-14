ROW_SIZE = 128
COL_SIZE = 8

seat_ids = []
with open('input.txt', 'r') as file:
    lines = file.readlines()
    lines = [line.rstrip() for line in lines]

    for line in lines:
        top_bound = ROW_SIZE
        bottom_bound = 0
        for c in line[:7]:
            if c == 'F':
                top_bound = int((top_bound + bottom_bound) / 2)
            else:
                bottom_bound = int(bottom_bound + (top_bound - bottom_bound) / 2) + 1

        row = top_bound - 1

        top_bound = COL_SIZE
        bottom_bound = 0
        for c in line[7:]:
            if c == 'L':
                top_bound = int((top_bound + bottom_bound) / 2)
            else:
                bottom_bound = int(bottom_bound + (top_bound - bottom_bound) / 2) + 1

        col = top_bound - 1
        seat_ids.append(row * 8 + col)

seat_ids.sort()
for i in range(1, len(seat_ids) - 1):
    if seat_ids[i + 1] - seat_ids[i] == 2:
        print(seat_ids[i + 1] - 1)
