# ItemSetManager

Live version at [https://itemsetmanager.herokuapp.com](https://itemsetmanager.herokuapp.com) 

It can take time to start, since it is a free hosted version which is automatically put on sleep mode by heroku when unused.

## Running

### Production mode

* Requires a [jdk 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html), [npm](https://nodejs.org/), bower (npm install -g bower) and gulp (npm install -g gulp)  
* The JAVA_HOME environment variable must be set correctly
* Move to src/main/ui and execute npm install && bower install && gulp dist
* In the project root execute eiter ./gradlew build or ./gradlew.bat build
* Execute java -jar --riot.api.key=YOUR_API_KEY build/libs/ItemSetManager-0.0.1-SNAPSHOT.jar
* Open your browser at [http://localhost:8080](http://localhost:8080)
 
NB : if you want to use PostgreSQL instead of H2, you need to passe those properties :
* spring.datasource.url=JDBC_DATABASE_URL
* spring.datasource.username=YOUR_DATABASE_USER
* spring.datasource.password=YOUR_DATABASE_PASSWORD
* spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
* spring.jpa.hibernate.ddl-auto=update

### Dev mode

* Run src/main/java/fr/kabiro/lol/ism/ItemSetManagerApplication.java in an IDE with --riot.api.key=YOUR_API_KEY or --spring.profiles.active=MOCK_RIOT
* Execute gulp in src/main/ui
* Open your browser at [http://localhost:9000](http://localhost:9000)

## Presentation

The goal of this project is to provide a web application for the League of Legends players, in order to easily manage their itemSets, without having to install an application on their computer. This is the reason why I choosed to provide a zip which contains their itemSets , or, for those who are comfortable with shells, one line scripts for easy copy and paste.
The application also provide an easy method for creating and downloading an itemSet from a game, in order to use it right away!

### MacOS
```Shell
curl https://itemsetmanager.herokuapp.com/api/sets/v1/EUW/Kabiro/zip > /Applications/League\ of\ Legends.app/Contents/LoL/Config/Config.zip && unzip -o /Applications/League\ of\ Legends.app/Contents/LoL/Config/Config.zip -d /Applications/League\ of\ Legends.app/Contents/LoL/Config/
```

### Windows PowerShell
```Shell
(new-object System.Net.WebClient).DownloadFile('https://itemsetmanager.herokuapp.com/api/sets/v1/EUW/Kabiro/zip', 'C:\League of Legends\Config.zip' ); $s = new-object -com shell.application; $s.namespace('C:\League of Legends\').Copyhere($s.namespace('C:\League of Legends\Config.zip').items())
``` 

## Technologies

* Hosting is done on Heroku
* The backend uses the Spring Boot stack
* The build tool for the backend is gradle
* The database is PostgreSQL for production (free on heroku) and H2 for development, accessed through hibernate
* The frontend is built with angularJS and bootstrap
* Build tools for the frontend are npm, bower and gulp

# TODO List
* [ ] Learn CSS
* [ ] Improve UI
* [ ] Make tests
* [ ] Use caching
* [ ] Provide an interface to easily edit an itemSet
* [ ] Compute for each block the cost
* [ ] Use CouchDB or MongoDB instead of PostgreSQL
* [ ] Cleanup code
* [ ] Real authentication system
 
# Notes

There are some minor changes on the heroku version, in order to make it work :
* The build.gradle contains a stage task (which is run by heroku, and simply calls the build task)
* The builded (gulp dist) ui is versioned under src/main/resources/public in order to be served by the server
* added a Procfile file which explains to heroku how to run the jar
* I also have a bunch of config variables which configure the connection to PostgreSQL

# Disclaimer
ItemSetManager isn’t endorsed by Riot Games and doesn’t reflect the views or opinions of Riot Games or anyone officially involved in producing or managing League of Legends. League of Legends and Riot Games are trademarks or registered trademarks of Riot Games, Inc. League of Legends © Riot Games, Inc.
