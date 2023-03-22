FROM node:16

WORKDIR /usr/src/app

COPY package*.json ./
COPY wait-for-it.sh ./
COPY docker-deploy.sh ./

RUN npm install --legacy-peer-deps

COPY . .

RUN npm run build

ENTRYPOINT ["./docker-deploy.sh"]