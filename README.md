本项目为调用nbu master 接口的sdk,封装了请求和响应参数，调用方法，异常信息处理。
项目分为以下包：
`exception`
`http`:包含调用nbu的APIClient类
`path`:请求路径常量
`request`:请求体封装
`request.enumeration` 请求相关的枚举类
`response`:响应类
`response.schema`:nbu响应类的层次较深，响应结构有通用的部分，因此将通用的部分放入schema包,在response包中组装
`util`:工具类

请求类应extends自AbstractReq类，该类包含以下可覆盖方法：
`uri()`:返回请求的uri地址,子类都需要覆盖
`needAuthorization()`:请求是否需要鉴权token,默认为true,如不需要鉴权设置为false
`acceptHeader()`:请求的AcceptHeader类型，默认为json,其他类型请覆盖此方法
请求类命名必须符合XxxMethodReq规则,即倒数第二个单词为请求的方法，AbstractReq类将依此来判断请求类型

APIClientTest 中给出了调用方法的示例

