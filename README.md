# jap-http-adapter

#### 介绍
适配  jakarta.servlet-api、blade-mvc 的 http 接口，包括：request、response、cookie、session

- http 适配器：https://gitee.com/fujieid/jap-http-adapter
- http 接口：https://gitee.com/fujieid/jap-http

## 快速开始

### 适配 `jakarta.servlet`

1. 依次引入下方依赖
```xml
<dependency>
    <groupId>com.fujieid.jap.http</groupId>
    <artifactId>jap-http-jakarta-adapter</artifactId>
    <version>1.0.0</version>
</dependency>
```
2. 在需要适配 `HttpServletRequest` 的地方，替换为

```java
new JakartaRequestAdapter(HttpServletRequest);
```

### 适配 `blade` 框架

1. 依次引入下方依赖

```xml
<dependency>
    <groupId>com.fujieid.jap.http</groupId>
    <artifactId>jap-http-blade-adapter</artifactId>
    <version>1.0.0</version>
</dependency>
```
2. 在需要适配 `HttpRequest` 的地方，替换为

```java
new BladeRequestAdapter(HttpRequest);
```
