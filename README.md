# orderfullfill-async


### This Microservice is Demonstration of using Async annotation, implementing Asynchronous API logic

#### Microservice Architecture
* In this : <br>1.we want 3 Tasks, <b>Order,Payment,Inventory Check</b> wants to execute synchronously</br>
 so these 3 Tasks will b executed with help of Server/Servlet API<br>2.The remaining tasks will be executed asynchronously using <b>MULTIPLE THREADS & EXECUTOR SERVICE</b></br>
* so we created Thread pool setting Number of threads, maximum thread limit, maximum tasks a queue can hold, if number of tasks crosses queue capacity what additional threads needs to be created
* please refer Thread pool executors configuration in src/main/config/OrderConfig
* when we use @ASYNC annotation either method can be <b>VOID or COMPLETABLE FUTURE</b>


1. Inventory Check Service - Synchronous
2. Order Service - Synchronous
3. Payment Service - Synchronous
4. Notify user - Asynchronous
5. Assign to Vendor - Asynchronous
6. Packaging - Asynchronous
7. Assign Delivery Partner - Asynchronous
8. Assign Trailer - Asynchronous
9. Dispatch Product - Asynchronous


