
_Work in progress_

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/0b8d189eeab34d9cba6ac4d5e7e38453)](https://www.codacy.com/app/jeroenwijdemans/jaxrs-error-handling?utm_source=github.com&utm_medium=referral&utm_content=jeroenwijdemans/jaxrs-error-handling&utm_campaign=badger) 
[![Build Status](https://travis-ci.org/jeroenwijdemans/jaxrs-error-handling.svg?branch=master)](https://travis-ci.org/jeroenwijdemans/jaxrs-error-handling)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![codecov](https://codecov.io/gh/jeroenwijdemans/jaxrs-error-handling/branch/master/graph/badge.svg)](https://codecov.io/gh/jeroenwijdemans/jaxrs-error-handling)

# JAXRS Error handler

Exceptions thrown by JAXRS are serialized to strings (JSON for example) but not 
in a nice format.
This library provides error mapping to a standardized Errors object or list.

 - Defines fixed error classes 
 - Provides simple runtime exception handling in JAXRS.

Fixed classes makes sure that all applications use the same format across services.

_TODO_ add support for XML

# Dependencies

Expected the jackson library on the classpath:

 - com.fasterxml.jackson.jaxrs
 - com.fasterxml.jackson.jaxrs.annotations
 
# Usage

Include dependency: 

```
dependencies {
    compile "com.wijdemans:jaxrs-jetty-error-handling:0.0.1"
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

# Changelog

[See changelog](./CHANGELOG.md)
