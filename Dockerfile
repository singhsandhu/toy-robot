FROM java:openjdk-8-jdk-alpine 

COPY target/Toy-Robot-1.0-FINAL.jar /Toy-Robot-1.0-FINAL.jar

ENTRYPOINT ["java","-jar","/Toy-Robot-1.0-FINAL.jar"]

