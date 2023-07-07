# Define la imagen base de Java
FROM openjdk:17

# Establece el directorio de trabajo en la imagen
WORKDIR /app

# Copia el archivo JAR generado por Maven a la imagen
COPY target/openmarketms-0.0.1-SNAPSHOT.jar /app/app.jar

# Expone el puerto en el que la aplicación se ejecutará (ajústalo según tus necesidades)
EXPOSE 8080

# Define el comando de inicio de la aplicación cuando se ejecute el contenedor
CMD ["java", "-jar", "app.jar"]
