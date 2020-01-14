FROM openjdk:8-jre

RUN groupadd -g 999 opsianuser && \
    useradd -r -u 999 -g opsianuser opsianuser
USER opsianuser

COPY /gatlingtest.jar /app.jar
COPY /libopsian.so /libopsian.so

CMD ["java", "-agentpath:/libopsian.so=apiKey=XXXXXXXXX,applicationVersion=1", "-jar", "/app.jar"]
