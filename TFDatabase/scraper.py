from bs4 import BeautifulSoup, NavigableString
import pandas as pd
import requests
import copy

BASE_LINK = 'https://tfwiki.net'

tl_link = requests.get('https://tfwiki.net/wiki/Category:Toylines').text
tl_soup = BeautifulSoup(tl_link, 'lxml')

toylines_group = tl_soup.find('div', {'id': 'mw-pages'})
toylines_html = toylines_group.find_all('a')

toylines = []
toylines_links = []
for toyline in toylines_html:
    toylines.append(toyline['title'])
    toylines_links.append(BASE_LINK + toyline['href'])

toyline_link = requests.get(toylines_links[0]).text
toy_soup = BeautifulSoup(toyline_link, 'lxml')

sublines = []
sublines_html = ''
subline_html_index = 0
sublines.append([toy_soup.find('span', class_='mw-headline').text])
for tag in toy_soup.find('span', class_='mw-headline').parent.next_siblings:
    if tag.name == 'h2':
        sublines[subline_html_index].append(sublines_html)
        sublines_html = ''
        sublines.append([tag.text])
        subline_html_index += 1
    else:
        sublines_html += str(tag)

sublines[subline_html_index].append(sublines_html)


for i in range(len(sublines)):

    subline_soup = BeautifulSoup(sublines[i][1], 'lxml')

    classes = []
    classes_html = ''
    class_html_index = -1
    for tag in subline_soup.find('span', class_='mw-headline').parent.next_siblings:
        print(tag)
        # if isinstance(tag, NavigableString):
        #     break
        # if tag.text == 'Notes' or tag.text == 'External links' or tag.text == 'References':
        #     break
        if tag.name == 'h3' or tag.name == 'h4':
            if class_html_index == -1:
                classes.append([tag.text])
                class_html_index += 1
            else:
                classes[class_html_index].append(classes_html)
                classes_html = ''
                classes.append([tag.text])
                class_html_index += 1
        else:
            classes_html += str(tag)
    sublines[i].append([classes])
print(sublines)
# classes[class_html_index].append(classes_html)

# COLUMNS = ['Toy', 'Toyline', 'Subline', 'Class', 'Wave']
# df = pd.DataFrame(columns=COLUMNS)

# for i in range(len(sublines)):
#     for j in range(len(classes)):
#         wave_index = -1
#         for small_table in classes[j][1].find_all('td', attrs={'style': 'vertical-align: top; width: 20%;'}):
#             if small_table.find('b') is not None:
#                 wave = small_table.find('b').text
#             for toy in small_table.find_all('li').text:
#                 df.append(pd.DataFrame(
#                     [toy, toylines[0], sublines[i][0], classes[j][0], wave]))

# df.to_excel('database')

# sublines = []
# classes = []
# waves = []
# index = -1
# for html in toy_soup.find_all('span', class_='mw-headline'):
#     if html.text == 'Notes' or html.text == 'External links' or html.text == 'References':
#         continue
#     # Sublines
#     elif html.parent.name == 'h2':
#         if classes != []:
#             sublines[index].append(classes)
#         classes = []    # Reset classes for next subline
#         sublines.append([html.text])
#         index += 1
#     else:
#         # Classes
#         classes.append([html.text])
# sublines[index].append(classes)

# print(sublines)

# subline_index = 0
# class_index = -1
# wave_index = 0
# for tag in toy_soup.find('span', class_='mw-headline').parent.next_siblings:
#     if tag.name == 'h2':
#         if subline_index > len(sublines):
#             break
#         subline_index += 1
#         class_index = -1
#         wave_index = 0
#     elif tag.name == 'table':
#         class_index += 1
#         for wave in tag.find_all('td'):
#             if wave.find('u') is not None:
#                 print(
#                     f'Subline index: {subline_index}\nClass index: {class_index}\nWave index: {wave_index}')
#                 print(sublines)
#                 print(f'Thing: {sublines[subline_index][1][0][class_index]}')
#                 sublines[subline_index][1][0][class_index].append(
#                     [wave.find('u').text])
#                 wave_index += 1
#                 try:
#                     print(sublines[subline_index][1]
#                           [0][class_index][wave_index])
#                 except:
#                     sublines[subline_index][1][0][class_index][wave_index] = 'ToysRUs'
#                 for toy in wave.find_all('a'):
#                     sublines[subline_index][1][0][class_index].append(
#                         toy.text)

# print(sublines[0][1][0])
# toy_tables = toy_soup.find_all(
#     'table', attrs={'style': 'width: 100%; margin-left:1em;'})
# for index, toy_table in enumerate(toy_tables):
#     print(f'Class: {class_names[index]}')
#     waves = toy_table.find_all('b')
#     for wave in waves:
#         try:
#             print(wave.text)
#         except:
#             print('ToysRUs')
#     print()
