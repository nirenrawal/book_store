FROM java:8
LABEL maintainer="nirenrawal@gmail.com"
VOLUME /tmp
EXPOSE 5555
ADD target/store-0.0.1-SNAPSHOT.jar store-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","store-0.0.1-SNAPSHOT.jar"]

#FROM mysql:latest
#ENV MYSQL_ROOT_PASSWORD rOOtpass123
#ENV MYSQL_DATABASE mydb
#ENV MYSQL_USER neymar
#ENV MYSQL_PASSWORD 12345678
#ADD mydb.sql /docker-entrypoint-initdb.d
#EXPOSE 3306