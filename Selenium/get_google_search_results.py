from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

# Change PATH to location of chromedriver
PATH = "chromedriver.exe"
driver = webdriver.Chrome(PATH)

driver.get("https://google.com")

search = driver.find_element_by_name("q")
search.send_keys("test")
search.send_keys(Keys.RETURN)

main = driver.find_element_by_id("rso")

try:
    main = WebDriverWait(driver, 10).until(
        EC.presence_of_element_located((By.ID, "rso")))
except:
    driver.quit()

results = main.find_elements_by_class_name("g")

titles = []
for result in results:
    titles.append(result.find_element_by_tag_name('h3'))

# Finding descriptions
descriptions = []
for result in results:
    descriptions.append(result.find_element_by_class_name("aCOpRe"))

# # Print titles
for title in titles:
    print(title.text)

# # Print descriptions
for description in descriptions:
    if description.text != '':
        print(description.text)
