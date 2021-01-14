import pandas as pd

try:
    database = pd.read_csv('database.csv')
except FileNotFoundError:
    response = input('File not found! Download database? (y/n)')
    if response == '' or response.lower() == 'y':
        pass
        # Download database

def search(toy):
