# AutomationScript_project
simple automation script project using page object model it includes end to end test using @dataprovider testNG 
and integrate with extent report,and testing of hyper links.
working: its finds product name which is present in json file in key value pair and then click on that product and 
its verify product name and size, cart , product details etc. functionality and test the all links which is related to mens 
clothing section at bottom of the website.

(website is keep updatig data so just change the product name present in json file or copy from website and paste in file)

steps:
1) go bewakoof.com and  serach t shirt for men.  
2) copy the any product name from searched result home page.
3) go to jsonTestData package and inside json file paste the product name
4) run the testng file from testngSuit_xml package.
