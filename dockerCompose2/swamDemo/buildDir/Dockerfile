FROM insideo/jdk8
ARG buildNo
ARG gitcommit
ENV APP_HOME /usr/app
ADD ./res /usr/res
COPY ./app/dockerdemo-1.0.jar ${APP_HOME}/app.jar
RUN echo "build number: ${buildNo}"
RUN echo "git commit: ${gitcommit}"
RUN pwd
RUN chmod 775 ${APP_HOME}/app.jar
RUN cd ${APP_HOME} && ls -a -l
RUN cd /usr/res && ls -a -l
EXPOSE 8090/tcp
WORKDIR ${APP_HOME}
ENTRYPOINT ["java","-jar","app.jar"]