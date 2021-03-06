# PharmaWeb
A simple app to manage users, druggists, pharmacy, orders, products...

## Backlog
https://github.com/gabrielguim/pharmaweb/wiki

## Running the App (Backend: pharmaweb folder)

Type the following command in your terminal to run the app or simply use your IDE (IntelliJ, Eclipse...)

```bash
$ gradle bootRun
```
The app will start running at <http://localhost:8081>.

## Running the App (Frontend: pharmaweb-front folder)

Install the dependencies using

```bash
$ npm install
```

Then...

```bash
$ npm start
```

The app will start running at <http://localhost:3000>.

## Explore Rest API  

Description of the entities:

    Entity: { name: Customer, endpoint: customers }
    Entity: { name: Druggist, endpoint: druggists }
    Entity: { name: Product, endpoint: products }
    Entity: { name: Order, endpoint: orders }

The app defines following CRUD APIs.

    GET /api/[entity.endpoint]

    POST /api/[entity.endpoint]

    GET /api/[entity.endpoint]/{id}

    PUT /api/[entity.endpoint]/{id}

    DELETE /api/[entity.endpoint]/{id}
    
For detailed information about the API, please check out: [API Docs](https://gabrielguim.github.io/pharmaweb/api_docs.html)
