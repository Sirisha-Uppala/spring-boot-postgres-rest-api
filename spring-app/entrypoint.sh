#entrypoint.sh

if [ -z ${DB_HOST} ]
 then
 DB_HOST='postgres-service'
fi

if [ -z ${DB_PORT} ]
 then
 DB_PORT='5432'
fi

if [ -z ${DB_NAME} ]
 then
 DB_NAME='postgres'
fi

if [ -z ${DB_USER} ]
 then
 DB_USER='postgres'
fi

if [ -z ${DB_PASSWD} ]
 then
 DB_PASSWD='postgrespass'
fi

if [ -z ${DB_URL} ]
 then
 DB_URL='jdbc:postgresql://postgres-service:${DB_PORT}/postgres'
fi

#replace values in application.properties file
cd /work/java/test1/src/main/resources
#sed -i.org 's/%{DB_URL}%/${DB_URL}/g;s/%{DB_USER}%/${DB_USER}/g;s/%{DB_PASSWORD}%/${DB_PASSWORD}/g' application.properties 

sed "s/%{DB_PASSWORD}%/${DB_PASSWD}/g" application.properties.org > application.properties
sed "s/%{DB_USER}%/${DB_USER}/g" application.properties.org > application.properties
sed "s/%{DB_URL}%/${DB_URL}/g" application.properties.org > application.properties

cat application.properties
echo "application.properties modified"

#run java code using mvn
cd /work/java/test1
echo "creating jar"
#mvn clean package -e
mvn clean package spring-boot:repackage -DskipTests

#run jar
cd /work/java/test1/target
echo "running jar"
java -jar test-0.0.1-SNAPSHOT.jar