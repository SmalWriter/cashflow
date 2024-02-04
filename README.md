# cashflow

first personal side project

一般來說，個人專案的README應該包括：
TODO：  專案基本資料: basic e-commerce shop, combined with line pay as payment.
TODO：  功能介紹、螢幕截圖或錄影 (work flow)
TODO：  使用教學、專案啟動教學 (how to set up environment? build it in docker image to suit for every OS)
TODO：  涵蓋的技術: sql, nosql (redis in front of database for caching)
TODO：  技術亮點或其他相關資訊 
how to scale up : using some system design technique
1. i18n, 
2. offline read, 
3. load balancer(redis: master write, others' slave read), 
4. how to database replication, Partitioning and Sharding

# shop 
shop is the spring boot project repository.

function:
1. member login, logout, register
firebase as authentication, integrate with many third party providers. 
I plan using firebaseUI to do the login flow.
spring security as backend authentication.
2. chat system: to let customer to interact with customer service staff. maybe will connect to line bot to answer basic question.
-- websocker, message queue, pub/sub to topic.
3. order management: to let whether supplier or customer to know how many items left on the shelf.
4. shopping cart: to let customer pick up the product they want. front end will store at local storage.
5. payment: line pay.
6. button to toggle dark mode/bright mode (Tailwind CSS) -[dark mode](https://tailwindcss.com/docs/dark-mode)

# frontend 
frontend is created by create-react-app. (might just using Vanilla JavaScript)
I will try to combine springboot using Java backend, thymeleaf as server side render template, and react as a front end interface. 
If I cant make it before I send resume, means I will only use Vanilla JavaScript.

## Tables in project and their relationship (table is based on function)
1. user
2. product
3. cart
4. order
5. 

## Table 

--Essential Tables:
Products:
Columns: product_id (primary key), name, description, price, stock, image_url, category_id (foreign key referencing Categories table)
Relationships:
One-to-Many with Order Items table (one product can be in multiple orders)
One-to-Many with Reviews table (one product can have multiple reviews)
Many-to-One with Categories table (one category can have many products)
Many-to-Many with Coupons table (through a separate "Product_Coupons" table)

Customers:
Columns: customer_id (primary key), name, email, password, address_id (foreign key referencing Addresses table)
Relationships:
One-to-Many with Orders table (one customer can have multiple orders)
One-to-Many with Addresses table (one customer can have multiple addresses)
Many-to-Many with Wishlist table (through a separate "Customer_Wishlist" table)

Orders:
Columns: order_id (primary key), customer_id (foreign key referencing Customers table), order_date, total_amount, status (e.g., "pending", "shipped", "delivered")
Relationships:
One-to-Many with Order Items table (one order can have multiple items)
Belongs-To Customer table (one customer placed this order)

Order Items:
Columns: order_item_id (primary key), order_id (foreign key referencing Orders table), product_id (foreign key referencing Products table), quantity, price


--Optional Tables:
Categories:
Columns: category_id (primary key), name, description
Relationships:
One-to-Many with Products table (one category can have many products)

Reviews:
Columns: review_id (primary key), product_id (foreign key referencing Products table), customer_id (foreign key referencing Customers table), rating, review_text

Coupons/Discounts:
Columns: coupon_id (primary key), code, discount_type (e.g., "percentage", "fixed amount"), value, expiry_date
Relationships:
Many-to-Many with Products table (through a separate "Product_Coupons" table)

Payment Methods:
Columns: payment_method_id (primary key), name, description, payment_gateway

Shipping Methods:
Columns: shipping_method_id (primary key), name, description, cost, estimated_delivery_time

Wishlist:
Columns: wishlist_id (primary key), customer_id (foreign key referencing Customers table), product_id (foreign key referencing Products table)

Inventory Management:
Columns: product_id (foreign key referencing Products table), stock_level, reorder_point, supplier_information

Content Management:
Columns: content_id (primary key), type (e.g., "blog post", "FAQ"), title, content, author, publish_date

## listing the basic web pages(.html files) the whole project needs, and the elements inside each page :
1. login
2. logout
3. register
4. member setting
5. member information
6. shopping page
7. checking shopping cart
8. check out page
9. shipment page
10. 
