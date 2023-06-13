FROM node:lts-alpine as build-stage
WORKDIR /app
COPY package*.json ./
#COPY package.json ./
RUN npm install -g npm@8.12.1
RUN npm install

COPY . .

RUN npm run build

# Remove unused directories
RUN rm -rf ./src
RUN rm -rf ./build

#CMD ["npm", "run", "serve"]
#EXPOSE 80


FROM nginx:1.21.1-alpine as production-stage
COPY --from=build-stage /app/dist/ /usr/share/nginx/html
EXPOSE 80
CMD [ "nginx", "-g", "daemon off;"]
