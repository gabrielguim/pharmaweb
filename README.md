# PharmaWeb
A simple app to manage users, druggists, pharmacy, orders, products...

## Backlog
https://github.com/gabrielguim/pharmaweb/wiki

## Running the App

Type the following command in your terminal to run the app or simply use your IDE (IntelliJ, Eclipse...)

```bash
$ gradle bootRun
```

The app will start running at <http://localhost:8081>.

## Explore Rest API  

Description of the entities:

    Entity: { name: User, endpoint: users }
    Entity: { name: Druggist, endpoint: druggists }
    Entity: { name: Product, endpoint: products }

The app defines following CRUD APIs.

    GET /api/[entity.endpoint]

    POST /api/[entity.endpoint]

    GET /api/[entity.endpoint]/{id}

    PUT /api/[entity.endpoint]/{id}

    DELETE /api/[entity.endpoint]/{id}
    
The app defines also search API for Product

    GET /api/products/?q={text}

You can test them using Postman or any other rest client.
