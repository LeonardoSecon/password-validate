FROM maslick/minimalka:jdk11

# Recebimento de argumentos via linha de comando ( docker build )
ARG PROJECT_NAME
ARG VERSION
ARG REVISION

# # Configuração de variáveis de ambiente da imagem
ENV PROJECT_NAME $PROJECT_NAME
ENV VERSION $VERSION
ENV REVISION $REVISION
ENV PROFILE $PROFILE
ENV APPNAME $PROJECT_NAME-$VERSION.jar

COPY application/target/"$APPNAME" /app/
COPY devops/docker-entrypoint.sh /app/

# Configuração de diretório de trabalho. /app será a pasta inicial da imagem
WORKDIR /app

ENTRYPOINT [ "/app/docker-entrypoint.sh" ]

# Expõe as portas  quando o container é montado.
EXPOSE 80
