FROM insideo/jdk8
ARG buildNo=2
ARG gitcommit=kelvin
ENV APP_HOME /usr/app
ADD ./res /usr/res
COPY ./app/dockerdemo-1.0.jar ${APP_HOME}/app.jar
RUN echo "build number: ${buildNo}"
RUN echo "git commit: ${gitcommit}"
RUN pwd
RUN chmod 777 ${APP_HOME}/app.jar
RUN cd ${APP_HOME} && ls -a -l
RUN cd /usr/res && ls -a -l
EXPOSE 8090/tcp
VOLUME /usr/res
WORKDIR ${APP_HOME}
ENTRYPOINT ["java","-jar","app.jar"]