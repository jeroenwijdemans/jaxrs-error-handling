
# Jetty Error handling

provides simple error handling in JAXRS.

errors thrown by JAXRS are serialized to JSON but not in a nice format.
This library provides error mapping to a standardized Errors object or list.

TODO add support for XML

# Dependencies

Expected the jackson library on the classpath:

 - com.fasterxml.jackson.jaxrs
 - com.fasterxml.jackson.jaxrs.annotations
 
# Usage

Include dependency: 

```
dependencies {
    compile "com.wijdemans:jaxrs-jetty-error-handling:1.0.0"
}
``` 

Add to container:

```java

class Main {
    
    private ResourceConfig createResourceConfig () {
        
        final ResourceConfig rc = new ResourceConfig();
        rc.register(JaxRsErrorMapper.class);
        
        return rc;
    }  
        
}



```
