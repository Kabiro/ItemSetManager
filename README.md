# ItemSetManager

Live version at [https://itemsetmanager.herokuapp.com](https://itemsetmanager.herokuapp.com) 

## Running

* Requires a [jdk 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html), [npm](https://nodejs.org/), bower (npm install -g bower) and gulp (npm install -g gulp)  
* The JAVA_HOME environment variable must be set correctly
* move to src/main/ui and execute npm install && bower install && gulp dist
* in the project root execute eiter ./gradlew build or ./gradlew.bat build
* execute java -jar --riot.api.key=YOUR_API_KEY build/libs/ItemSetManager-0.0.1-SNAPSHOT.jar
* open your browser at [http://localhost:8080](http://localhost:8080)

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

# TODO List
* [ ] Improve UI
* [ ] Provide an interface to easily edit an itemSet
* [ ] Use CouchDB or MongoDB instead of PostgreSQL
* [ ] Cleanup code
* [ ] Real authentication system

# Disclaimer
ItemSetManager isn’t endorsed by Riot Games and doesn’t reflect the views or opinions of Riot Games or anyone officially involved in producing or managing League of Legends. League of Legends and Riot Games are trademarks or registered trademarks of Riot Games, Inc. League of Legends © Riot Games, Inc.
