FROM openjdk:8

ENV         ACTIVATOR_VERSION 1.3.11
ARG         USER_HOME_DIR="/root"

# Add cerificates that ensure download of dependencies works:
RUN         apt-get install -y ca-certificates-java && \
            update-ca-certificates

# Install Typesafe Activator
RUN         cd /tmp && \
            wget -q http://downloads.typesafe.com/typesafe-activator/$ACTIVATOR_VERSION/typesafe-activator-$ACTIVATOR_VERSION.zip && \
            unzip -q typesafe-activator-$ACTIVATOR_VERSION.zip -d /usr/local
RUN         mv /usr/local/activator-dist-$ACTIVATOR_VERSION /usr/local/activator && \
            rm /tmp/typesafe-activator-$ACTIVATOR_VERSION.zip

COPY . /w3act
COPY .git /w3act/.git

WORKDIR /w3act

# Patch in the version tag:
RUN git fetch -t && export VERSION=`git describe --tags --always` && sed -i -r 's|version := ".*"|version := "'${VERSION}'"|' build.sbt || exit 0

# Run without failing to try to download all dependencies:
RUN /usr/local/activator/bin/activator stage || exit 0
RUN /usr/local/activator/bin/activator stage || exit 0

# Perform a full clean build:
RUN rm -fr target
RUN /usr/local/activator/bin/activator clean stage

EXPOSE 9000

#VOLUME "$USER_HOME_DIR/.ivy2"

CMD /w3act/target/universal/stage/bin/w3act -Dconfig.file=/w3act/conf/docker.conf -Dpidfile.path=/dev/null

