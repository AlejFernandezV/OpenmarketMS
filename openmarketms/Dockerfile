# Usa una imagen base de Java
FROM openjdk:11
# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app
# Copia el archivo JAR de la aplicación al contenedor
COPY target/openmarketms-0.0.1-SNAPSHOT.jar app.jar
# Expone el puerto en el que se ejecuta la aplicación
EXPOSE 8080
# Comando de inicio de la aplicación
CMD ["java", "-jar", "app.jar"]
