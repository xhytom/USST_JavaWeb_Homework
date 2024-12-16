## 广告投放系统

#### 获取广告信息

新闻网站，购物网站向广告投放网站发送请求，返回一个Advertisement类

### Advertisement.java

```java
public class Advertisement {
    private Integer id; // 数据库中的id
    private String title; // 广告的名称
    private String description; // 广告展示的描述
    private String imageUrl; // 广告图片路径
    private String url;  // 广告跳转的 URL
}
```

### AdvertisementController.java

```java
url: /api/advertisement/getAdvertisement
    
public Advertisement getAdvertisement() {
	return new Advertisement(1, "", "百度一下，你就知道", "http://localhost:8080/images/baidu.png", "https://www.baidu.com");
}
```





