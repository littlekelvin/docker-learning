FROM ubuntu:14.04

LABEL maintainer="Kelvin Mai<kelvin.mai@oocl.com>"

# install grobal tool
RUN apt-get update && apt-get -y install curl

# install jdk
ARG java_home=/usr/share/jdk8

RUN mkdir -p /usr/share/jdk8
ADD ./res/ /usr/share/jdk8/
RUN tar -xzf ${java_home}/jdk-8.tar.gz -C ${java_home} \
    && rm -f ${java_home}/jdk-8.tar.gz
RUN chmod -R 777 ${java_home}

# intall maven env
ARG MAVEN_VERSION=3.5.3
ARG DOWNLOAD_BASE_URL=https://archive.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries

RUN mkdir -p /usr/share/maven \
    && curl -L -o /tmp/apache-maven.tar.gz ${DOWNLOAD_BASE_URL}/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
    && tar -xzf /tmp/apache-maven.tar.gz -C /usr/share/maven \
    && ls -a -l /usr/share/maven \
    && rm -f /tmp/apache-maven.tar.gz
RUN ln -s /usr/share/maven/apache-maven-${MAVEN_VERSION}/bin/mvn /usr/bin/mvn

ENV JAVA_HOME /usr/share/jdk8/jdk1.8.0_181
ENV M2_HOME /usr/share/maven/apache-maven-${MAVEN_VERSION}
ENV PATH $PATH:${JAVA_HOME}/bin
RUN echo $PATH
RUN ls -a -l ${JAVA_HOME}/bin
RUN mvn -v

ARG WORKPLACE=/usr/app/dockerdemo

ADD ./dockerdemo/  ${WORKPLACE}/
RUN cd ${WORKPLACE} && ls -a -l
RUN cd ${WORKPLACE} && mvn clean install -DskipTests=true
RUN cd ${WORKPLACE} && ls -a -l
RUN cd ${WORKPLACE}/target && ls -a -l