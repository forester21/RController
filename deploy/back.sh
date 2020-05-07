cd ~/IdeaProjects/RController
mvn clean package
scp target/rcontroller-0.0.1-SNAPSHOT.jar pi@192.168.1.70:/home/pi/RController
#ssh pi@192.168.1.70 "/opt/jdk-11/bin/java -jar /home/pi/RController/rcontroller-0.0.1-SNAPSHOT.jar"
