### Springframework Terminology
Important points about spring framework
#### 1. @CrossOrigin:
This annotation is used both at class and method level to enable cross origin requests. In many cases the host that serves JavaScript will be different from the host that serves the data. In such a case Cross Origin Resource Sharing (CORS) enables cross-domain communication.
````java
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/account")
public class AccountController {

@CrossOrigin(origins = "http://example.com")
@RequestMapping("/message")
  public Message getMessage() {
      // ...
    }
 
@RequestMapping("/note")
    public Note getNote() {
        // ...
    }
}
````
#### 2. @InitBinder
The @InitBinder annotated methods will get called for each HTTP request if you don’t specify the value element of this annotation. The value element can be a single or multiple form names or request parameters that the init binder method is applied to.
This annotation is a method level annotation that plays the role of identifying the methods which initialize the WebDataBinder - a DataBinder that binds the request parameter to JavaBean objects.

#### 3. @Cacheable
This annotation is used on methods. The simplest way of enabling the cache behaviour for a method is to annotate it with @Cacheable and parameterize it with the name of the cache where the results would be stored.
````java
@Cacheable("addresses")
public String getAddress(Book book){...}
````
In the snippet above , the method getAddress is associated with the cache named addresses. Each time the method is called, the cache is checked to see whether the invocation has been already executed and does not have to be repeated.

#### H2-db default path
`http://localhost:8080/h2-console`
if we mention spring.h2.console.path=/pathname
then use pathname
`http://localhost:8080/pathname`

### Aspect Oriented Terminology
1. **Aspect :** Is a module of code for cross cutting concerns.
2. **Advice :** Uses to specify what action is taken and when it should be applied.
Advice types are:
    1. `Before:` Run the code before the actual method is executed.
    2. `After Finally:` Run the code after the method finishes it's execution.
    3. `After Returning:` Run the code method for a successful execution.
    4. `After Throwing:` Run the code after the method finishes and if an exception is thrown.
    5. `Around:` Run the code before and after the method execution.
3. **Join Point :** Uses to specify when to apply the code during program execution.
4. **Pointcut :** Predicate expression to specify where the advice should be applied. 
#### Spring AOP
* Advantages
    * Very easy to use
    * Uses Proxy Pattern & Decorator Pattern
    * Easy to migrate from spring AOP to Aspect J
* Disadvantages
    * Supports only method level join points
    * Supports only objects created using Spring App Context
    * Performance is slow
#### Aspect J
* Advantages
    * Supports all Join types(Method level, Constructor level and Field level)
    * Can be used with any POJO
    * Performance is faster when compared with spring AOP
    * Provides full implementation of AOP specification
* DisAdvantages
    * Compile time weaving requires additional compile time step
    * AspectJ Pointcut syntax is very close.
#### References:
1. [https://springframework.guru/spring-framework-annotations/](https://springframework.guru/spring-framework-annotations/)
2. [https://stackoverflow.com/questions/1606559/spring-aop-vs-aspectj)](https://stackoverflow.com/questions/1606559/spring-aop-vs-aspectj)