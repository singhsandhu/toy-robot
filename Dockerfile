FROM openjdk:8 

COPY target/Toy-Robot-1.0-FINAL.jar /Toy-Robot-1.0-FINAL.jar

ENTRYPOINT ["java","-jar","/Toy-Robot-1.0-FINAL.jar"]

