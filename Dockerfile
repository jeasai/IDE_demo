FROM maven:3.8.1
WORKDIR /app
COPY . .
RUN mvn compile
ENTRYPOINT ["mvn", "exec:java", "-Dexec.mainClass=Main", "-q"]
RUN useradd --create-home appuser
USER appuser
EXPOSE 9000
