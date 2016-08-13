Thymeleaf 3 shiro tag
---

**See also:** 

1. [thymeleaf-extras-shiro](https://github.com/theborakompanioni/thymeleaf-extras-shiro)
2. [thymeleaf-dialect](http://www.thymeleaf.org/doc/tutorials/3.0/extendingthymeleaf.html)



###Download


Maven
```xml
<repositories>
    <repository>
        <snapshots>
            <enabled>false</enabled>
        </snapshots>
        <id>bintray-usydapeng-maven</id>
        <name>bintray</name>
        <url>http://dl.bintray.com/usydapeng/maven</url>
    </repository>
</repositories>
<dependencies>
    <dependency>
        <groupId>org.zunpeng</groupId>
        <artifactId>thymeleaf3-shiro</artifactId>
        <version>0.0.1</version>
        <type>pom</type>
    </dependency>
</dependencies>
```

gradle
```gradle
repositories {
    jcenter()
}
dependencies {
    compile 'org.zunpeng:thymeleaf3-shiro:0.0.1'
}
```


Shiro Tags Usage With Thymeleaf
---
See [http://shiro.apache.org/tags](http://shiro.apache.org/tags) and
[http://shiro.apache.org/web.html#Web-JSP%252FGSPTagLibrary](http://shiro.apache.org/web.html)
* * *

### The `guest` tag
    <shiro:guest>
        <p>Please <a href="login.html">Login</a></p>
    </shiro:guest>

preferred approach:

    <p shiro:guest="">Please <a href="login.html">Login</a></p>

### The `user` tag
    <shiro:user>
        <div>Welcome back John!  Not John? Click <a href="login.html">here<a> to login.</div>
    </shiro:user>

preferred approach:

    <div shiro:user="">
        Welcome back John!  Not John? Click <a href="login.html">here<a> to login.
    </div>


### The `hasRole` tag
    <shiro:hasRole name="administrator">
        <a href="admin.html">Administer the system</a>
    </shiro:hasRole>

preferred approach:

    <a shiro:hasRole="administrator" href="admin.html">Administer the system</a>

### The `lacksRole` tag
    <shiro:lacksRole name="administrator">
        <p>Sorry, you are not allowed to administer the system.</p>
    </shiro:lacksRole>

preferred approach:

    <p shiro:lacksRole="administrator">
        Sorry, you are not allowed to administer the system.
    </p>

### The `hasAnyRoles` tag
    <shiro:hasAnyRoles name="developer, project manager, administrator">
        <div class="message">You are either a developer, project manager, or administrator.</div>
    </shiro:hasAnyRoles>

preferred approach:

    <div shiro:hasAnyRoles="developer, project manager, administrator" class="message">
        You are either a developer, project manager, or administrator.
    </div>
    
    
### The `hasAllRoles` tag
    <shiro:hasAllRoles name="developer, project manager, administrator">
        <div class="message">You are either a developer, project manager, or administrator.</div>
    </shiro:hasAllRoles>

preferred approach:

    <div shiro:hasAllRoles="developer, project manager, administrator" class="message">
        You are either a developer, project manager, or administrator.
    </div>

### The `hasPermission` tag
    <shiro:hasPermission name="user:create">
        <a href="createUser.html">Create a new User</a>
    </shiro:hasPermission>

preferred approach:

    <a shiro:hasPermission="user:create" href="createUser.html">Create a new User</a>

### The `hasAllPermissions` tag
    <shiro:hasAllPermissions name="user:create">
        <a href="createUser.html">Create a new User</a>
    </shiro:hasAllPermissions>

preferred approach:

    <a shiro:hasAllPermissions="user:create" href="createUser.html">Create a new User</a>


### The `hasAnyPermissions` tag
    <shiro:hasAnyPermissions name="user:create">
        <a href="createUser.html">Create a new User</a>
    </shiro:hasAnyPermissions>

preferred approach:

    <a shiro:hasAnyPermissions="user:create" href="createUser.html">Create a new User</a>



### The `lacksPermission` tag
    <shiro:lacksPermission name="user:delete">
        <p>Sorry, you are not allowed to delete user accounts.</p>
    </shiro:hasPermission>

preferred approach:

    <p shiro:lacksPermission="user:delete">Sorry, you are not allowed to delete user accounts.</p>
