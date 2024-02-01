# cashflow

first personal side project

一般來說，個人專案的README應該包括：
-- TODO：  專案基本資料: basic shopping mall, consider combined with line pay as payment.
-- TODO：  功能介紹、螢幕截圖或錄影
-- TODO：  使用教學、專案啟動教學
-- TODO：  涵蓋的技術
-- TODO：  技術亮點或其他相關資訊

# shop 
shop is the spring boot project repository.

1. member login, logout, register
firebase as authentication, integrate with many third party providers. 
I plan using firebaseUI to do the login flow also.
spring security as backend authentication.
2. chat system: to let customer to interact with customer service staff. maybe will connect to line bot to answer basic question.
-- websocker, message queue, pub/sub to topic.
3. order management: to let whether supplier or customer to know how many items left on the shelf.
4. shopping cart: to let customer pick up the product they want. front end will store at local storage.
5. payment: line pay.

# frontend 
frontend is created by create-react-app. (maybe will just using Vanilla JavaScript)
I will try to combine springboot using Java backend, thymeleaf as server side render template, and react as a front end interface. 
If I cant make it before I send resume, means I will only use Vanilla JavaScript.
