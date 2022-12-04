
# ShopAround ECommerce Application

ShopAround is a Ecommerce application, backend built with Springboot and MongoDB.
Using Java version 11 and MongoDB version 6.0




## Run Locally

### Clone the project

```bash
  git clone https://link-to-project
```

Go to the project directory

```bash
  cd my-project
```
### Database
To setup MongoDB database create a folder `database` under root directory and copy the 
path to folder. Then to start the MongoDB server, run following command from CMD

```bash
mongod --dbpath <PathtoDatabaseFolder> --port 28034
```
The DB server will start on the port 28034

### Start the server
Run the following command from project root directory 

```bash
  gradlew bootRun
```
The backend server will start on the port 8083. To check open URL http://localhost:8083/ from browser.


## API Reference

### Admin APIs
#### 1. Create Product
```http
POST /products
```
Request body Parameters
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `name` | `string` | Product name |
| `description` | `string` | Product Description |
| `price` | `double` | Product price |
| `image` | `string` | Product image URL |

Sample request
```json
{
	"name":"Deo Leo Engineered Wood Computer Desk ",
	"description":"Bring this brown and silver colored computer table from Nilkamal for your computer room and enjoying hours of surfing net and sitting in front of the computer screen. Made from a strong material, it is ready to be used ruggedly by the user. It features an amazing finish that will last longer and is easy to maintain. The durability of this product makes it a sturdy and robust item",
	"price":4300.0,
	"image":"https://rukminim1.flixcart.com/image/832/832/jn97frk0/computer-table/d/w/x/mdf-cdleobch-nilkamal-beech-original-imaf9srxmv2th2k7.jpeg?q=70"
}
```

### Ecom Site APIs

#### 1. Get all products

```http
  GET /products
```

#### 2. Get product details

```http
  GET /products/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | Id of product to fetch details |

#### 3. Add product to cart
```http
  POST /carts
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `productId`      | `string` | Id of product to be added to cart |
| `userId` | `string` | Id of the customer |

Sample request
```json
{
	"productId": "6384d24efe418f3c35f0268d",
	"userId": "customer@example.com"
}
```