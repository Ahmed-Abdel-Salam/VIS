# VIS
Steps to clone the project:

- From eclipse , select import project -> Project from GIt (Smart import) - > Clone URI
- Add Link https://github.com/Ahmed-Abdel-Salam/VIS -> click Next
- Select Master -> Click Next
- Select your workspace -> Click Next.
- From folders , Select VIS/Vodafone.
- Click Finish.


Project structure:

- src>Main>Java Contains three packages:  
  - com.framework : contains classes that handle main actions that will be used across the whole project “Assertions , Reporting ,           Element actions and data driven manipulation”.
  
  - com.pageObjectModel.mainPages : contains page object model classes , 1 class per page , each class contains all needed element           locators and related business methods .
  
  - com.utilities : contains two classes , Test base class that contains all basic objects need through the execution lifetime , General     Methods class contains helper methods.

- src>test>Java : contains GUI test package , that contains test classes .

- src>test>resources: contains drivers.
 
- Resources folder :contains test data sheet.

- Test - output : contains testReport.HTML , it is the generated extent report after execution.
