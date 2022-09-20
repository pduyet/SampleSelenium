FROM ubuntu:18.04

RUN apt-get -y update && apt-get -y upgrade && apt-get install -y \
    openjdk-11-jdk \
    openjdk-11-jre-headless \
    maven \
    wget \
    git > /dev/null

RUN wget -q https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
RUN apt-get install -y ./google-chrome-stable_current_amd64.deb

RUN mvn --version

ADD . /app
WORKDIR /app
RUN mvn clean

# RUN mvn -Dtest=Authorization_Login#auth_Login_Successfully test
# ADD target/my-maven-docker-project.jar my-maven-docker-project.jar
# ENTRYPOINT ["mvn", "-Dtest=Authorization_Login#auth_Login_Successfully", "test"]
# EXPOSE 8080