# Stage 1: Build the react application
FROM node:alpine as build

# Set the working directory inside the container
WORKDIR /my-counter-app

# Copy package.json and package-lock.json for npm install
COPY package.json package-lock.json ./

# Install dependencies using npm
RUN npm install

# Copy the rest of the application files
COPY . .

# Build the React application
RUN npm run build

# Stage 2: Serve the react application using nginx
FROM nginx:alpine

# Copy build output from the previous stage to nginx's html directory
COPY --from=build /my-counter-app/build /usr/share/nginx/html

# Expose port 80
EXPOSE 80

# Run nginx server
CMD ["nginx", "-g", "daemon off;"]
