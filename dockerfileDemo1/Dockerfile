FROM insideo/jdk8
COPY ./app/dockerdemo-0.0.1.jar /app.jar
RUN pwd
RUN chmod 775 /app.jar
RUN ls -a -l
EXPOSE 8090/tcp
ENTRYPOINT ["java","-jar","app.jar"]