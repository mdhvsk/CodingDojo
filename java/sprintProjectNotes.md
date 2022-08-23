# Java Spring Project Set Up

* Create new spring starter project
    * Type: maven
    * Java Version: 8
    * Packaging: War
    * Language: Java
    * Import:
        * Spring Boot DevTools
        * Spring Web
    

* Create controller
    * @RestController for transferring string, json, data
    * @RequestMapping for routing

Controller Example: 

``` java
// ..
@RestController
@RequestMapping("/hello")
public class HomeController {
        @RequestMapping("")
        public String hello() {
                return "Hello World!";
        }
        @RequestMapping("/world")
        public String world() {
                return "Class level annotations are cool too!";
        }
}
```

Specify base url route (everything starts with /greeting): 
``` java
// ...
@RestController
@RequestMapping("/greeting")
public class HomeController {
    @RequestMapping("")
    public String index(){
      return "This is accessed view http://your_server/simple/root";
    }
    @RequestMapping("/hello")
    public String hello(){
      return "Hello world! What route did you use to access me?";
    }
    @RequestMapping("/goodbye")
    public String world(){
      return "Goodbye world!";
    }
}
```

Query Paramaters Example (required request):
``` java
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HomeController {
    @RequestMapping("/")
    public String index(@RequestParam(value="q") String searchQuery) {
        return "You searched for: " + searchQuery;
    }
}
```

Query Paramaters Example (optional request):
``` java
    @RequestMapping("/")
    public String index(@RequestParam(value="q", required=false) String searchQuery) {
        return "You searched for: " + searchQuery;
    }
//...
```
Path Variables Example: 
``` java
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HomeController {
    @RequestMapping("/m/{track}/{module}/{lesson}")
    public String showLesson(@PathVariable("track") String track, @PathVariable("module") String module, @PathVariable("lesson") String lesson){
    	return "Track: " + track + ", Module: " + module + ", Lesson: " + lesson;
    }
}
```

## JSP and JSTL
* Dependencies to add to pom.xml
``` html
    <dependency>
        <groupId>org.apache.tomcat.embed</groupId>
        <artifactId>tomcat-embed-jasper</artifactId>
    </dependency>
	<dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>jstl</artifactId>
    </dependency>
```
* line to add to index.jsp

``` html
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
```

* Create WEB-INF Directory in src/main/webapp
* Add line to application.properties

` spring.mvc.view.prefix=/WEB-INF/ `









