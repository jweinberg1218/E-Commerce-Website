# E-Commerce-Website

Pre-requistites
----------------
- Maven (build automation tool)
- Java EE 8-compliant application server (Wildfly recommended)
- MySQL database server

Packaging/Deployment
---------------------
1. With Maven's bin directory in your system's PATH variable, open a shell in this project's root directory (directory containing pom.xml) and run the "mvn package" command. This will compile/package all source files into a WAR file in the [project root]/target directory.
2. Copy the generated WAR file from the [project root]/target directory to your application server's deployments directory (if using Wildfly, this is located at [Wildfly root]/standalone/deployments).
3. Run SQL script located at [project root]/src/main/webapp/resources within your MySQL server to initialize the jasonsbookstore database.
4. Add JDBC driver and data source for jasonsbookstore database to your application server (if using Wildfly, this can be done from the Administrative Console at http://localhost:9990/console/index.html#configuration;path=configuration~subsystems!css~datasources).
5. Run application server (if using Wildfly, run [Wildfly root]/bin/standalone.bat on Windows or [Wildfly root]/bin/standalone.sh on Unix/Linux).
6. Enjoy!
