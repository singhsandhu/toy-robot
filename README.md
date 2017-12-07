# Toy Robot

## Technical specs
- Java 8
- Maven 3

### Static Analysis
- PMD
- FindBug

### Logging
- Log4J

## Building locally (you will need Java 8 and Maven)
- ./build.sh

## Building using Vagrant
- vagrant up (This will provision a Vagrant box with Java8 and Maven installed)
- vagrant ssh
- cd /vagrant
- ./build.sh

## Running Robot App
- java -jar target/Toy-Robot-1.0-FINAL.jar <optional_file_path>

## Author
Ramanjit Singh