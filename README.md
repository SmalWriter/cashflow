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
3. load balancer, 
4. how to database replication, Partitioning and Sharding

might takes half to a year to finish the whole project.

TODO: Tables in project and their relationship (table is based on function)
1. user
2. product
3. cart
4. order
5. 

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
