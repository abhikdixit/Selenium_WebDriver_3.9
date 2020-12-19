set projectLocation=D:\F Drive\Selenium Training Data\workspace\Selenium_WebDriver_3.9
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testng.xml
pause