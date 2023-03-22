FROM node:16

WORKDIR /app

RUN --mount=type=secret,id=USERNAME \
	cat /run/secrets/USERNAME > /app/username.txt