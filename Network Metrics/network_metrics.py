from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

# Change PATH to path to chromedriver
PATH = "chromedriver.exe"
driver = webdriver.Chrome(PATH)

driver.get("https://google.com")

# Navigate to 'test' search page
search = driver.find_element_by_name("q")
search.send_keys("test")
search.send_keys(Keys.RETURN)

# Find Ookla SpeedTest
link = driver.find_element_by_partial_link_text("Speedtest by Ookla")
link.click()

# Start SpeedTest
try:
    start = WebDriverWait(driver, 10).until(
        EC.presence_of_element_located(
            (By.CLASS_NAME, "start-text")))
    start.click()
except:
    driver.quit()

# Get results
try:
    WebDriverWait(driver, 60).until(
        EC.url_contains("result"))
    download_result = driver.find_element_by_css_selector(
        ".result-data-large.number.result-data-value.download-speed")
    upload_result = driver.find_element_by_css_selector(
        ".result-data-large.number.result-data-value.upload-speed")
    print("Download Speed: " + download_result.text +
          "\nUpload Speed: " + upload_result.text)
finally:
    driver.quit()
