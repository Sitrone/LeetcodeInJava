## 设计注意点 
1. 版本，API带上版本信息  
2. 路径(Endpoint)使用资源集合进行操作，也即复数形式的资源 
3. HTTP动词对应资源的操作方法，常见的有get(查询), post(新建), put(更新单个资源(全量)), patch(更新单个资源(部分)), delete(删除) 
4. HTTP返回状态码对应操作结果 
5. restful-style设计中的常见问题?  
    1. 对于用户登录和用户退出这两个业务需求，REST指导下的架构和设计如何满足  
	2. 批量的删除、修改、新增如何满足
 

### 常见返回码：  
> 200 OK - [GET]：服务器成功返回用户请求的数据，该操作是幂等的（Idempotent）。  
> 201 CREATED - [POST/PUT/PATCH]：用户新建或修改数据成功。  
> 202 Accepted - [*]：表示一个请求已经进入后台排队（异步任务）  
> 204 NO CONTENT - [DELETE]：用户删除数据成功。  
> 400 INVALID REQUEST - [POST/PUT/PATCH]：用户发出的请求有错误，服务器没有进行新建或修改数据的操作，该操作是幂等的。  
> 401 Unauthorized - [*]：表示用户没有权限（令牌、用户名、密码错误）。  
> 403 Forbidden - [*] 表示用户得到授权（与401错误相对），但是访问是被禁止的。  
> 404 NOT FOUND - [*]：用户发出的请求针对的是不存在的记录，服务器没有进行操作，该操作是幂等的。  
> 406 Not Acceptable - [GET]：用户请求的格式不可得（比如用户请求JSON格式，但是只有XML格式）。  
> 410 Gone -[GET]：用户请求的资源被永久删除，且不会再得到的。  
> 422 Unprocesable entity - [POST/PUT/PATCH] 当创建一个对象时，发生一个验证错误。  
> 500 INTERNAL SERVER ERROR - [*]：服务器发生错误，用户将无法判断发出的请求是否成功。  


## ref 
1. [RESTful API 设计指南](http://www.ruanyifeng.com/blog/2014/05/restful_api.html) 
2. [Restful API 的设计规范](https://novoland.github.io/%E8%AE%BE%E8%AE%A1/2015/08/17/Restful%20API%20%E7%9A%84%E8%AE%BE%E8%AE%A1%E8%A7%84%E8%8C%83.html) 
3. [v2ex:我是一个人么，还有人觉得 RESTful 是糟糕的设计么](https://www.v2ex.com/t/111775) 
4. [理解本真的REST架构风格](http://www.infoq.com/cn/articles/understanding-restful-style) 
5. [RESTful GET，如果存在大量参数，是否有必要变通一下](https://www.zhihu.com/question/36706936) 
6. RESTful Web Services Cookbook 
7. [WEB开发中，使用JSON-RPC好，还是RESTful API好？](https://www.zhihu.com/question/28570307/answer/47876255)  
8. [REST风格的优势是什么?](https://www.zhihu.com/question/33959971)
