#!/usr/bin/env bash
exec java "${javaXms:--Xms512m}" \
  "${javaXmx:--Xmx1024m}" \
  -Dspring.profiles.active=$env \
  -Duser.timezone="America/Sao_Paulo" -jar /app/"$APPNAME" "$javaXms" "$javaXmx"
