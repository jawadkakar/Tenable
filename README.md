# This is a maven project

Please follow the following steps to build and deploy the code:

Assumption: Java 8, Maven 3.+ and git are installed. JAVA_HOME and M2_HOME are set.
1: Check out the code from github using the following command 
   git clone https://github.com/jawadkakar/Tenable.git
2: navigate to the folder where code was checked out
   cd Tenable

3: build the code using maven 
   mvn clean install
4: cd /Tenable/Rest/target
5: deploy tenable.war file to tomcat, I used tomcat 8.5
6: There are total of 4 REST end points (i.e. customize, exclusivity, pricing, restock ), to hit the end points use curl or browser 
curl http://localhost:8080/tenable/rest/customize/kitcustomizer?id=22&&name=mykit
curl http://localhost:8080/tenable/rest/exclusivity/kitexclusivity?id=22&&name=mykit
curl http://localhost:8080/tenable/rest/pricing/kitpricing?id=22&&name=mykit
curl http://localhost:8080/tenable/rest/restock/kitrestock?id=22&&name=mykit




