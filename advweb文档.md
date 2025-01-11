### register

post

```
http://150.158.79.12:8080/api/register/
```

请求体

```json
{
    "username": "testuser",
    "password": "testpass",
    "is_operator": false
}
```

响应json

```json
{
    "message": "User registered successfully"
}
```



### login

```
http://150.158.79.12:8080/api/login/
```

请求体

```json
{
    "username": "testuser",
    "password": "testpass"
}
```

响应json

```json
{
    "message": "Login successful",
    "username": "testuser"
}
```



### add_adv

post

```
http://150.158.79.12:8080/api/add_adv/
```

请求体

```json
{
    "adv_master": "ExampleMaster",
    "title": "Test Advertisement",
    "description": "This is a sample ad description.",
    "url": "https://example.com",
    "image_url": "https://example.com/image.jpg"
}
```

响应json

```json
{
    "message": "Ad created successfully",
    "ad": {
        "id": 1,
        "adv_master": "ExampleMaster",
        "title": "Test Advertisement",
        "description": "This is a sample ad description.",
        "url": "https://example.com",
        "image_url": "https://example.com/image.jpg",
        "click_time": 0,
        "show_time": 0
    }
}
```

错误json

```json
{
    "message": "All fields are required"
}
{
    "message": "Only POST method is allowed"
}
```





### get_all_ads

get

```
http://150.158.79.12:8080/api/get_all_ads/
```

相应json

```json
{
    "ads": [
        {
            "id": 1,
            "adv_master": "ExampleMaster",
            "title": "Test Advertisement",
            "description": "This is a sample ad description.",
            "url": "https://example.com",
            "image_url": "https://example.com/image.jpg",
            "click_time": 0,
            "show_time": 0
        },
        {
            "id": 2,
            "adv_master": "AnotherMaster",
            "title": "Another Advertisement",
            "description": "This is another sample ad.",
            "url": "https://another.com",
            "image_url": "https://another.com/image.jpg",
            "click_time": 0,
            "show_time": 0
        }
    ]
}
```



### get_by_id

```
http://150.158.79.12:8080/api/get_ad_by_id/1/
```

响应json同上

未找到

```json
{
    "message": "Ad not found"
}
```



### delete_ad



```
http://150.158.79.12:8080/api/delete_ad/1/
```

Json

```json
{
    "message": "Ad with ID 1 deleted successfully"
}
{
    "message": "Ad not found"
}
{
    "message": "Only DELETE method is allowed"
}

```



### update_ad

put

```
http://150.158.79.12:8080/api/update_ad/1/
```

请求体

```
{
    "title": "Updated Advertisement",
    "description": "This is an updated description.",
    "url": "https://updated-example.com",
    "image_url": "https://updated-example.com/image.jpg"
}
```

返回

```
{
    "message": "Ad with ID 1 updated successfully",
    "ad": {
        "id": 1,
        "adv_master": "ExampleMaster",
        "title": "Updated Advertisement",
        "description": "This is an updated description.",
        "url": "https://updated-example.com",
        "image_url": "https://updated-example.com/image.jpg",
        "click_time": 0,
        "show_time": 0
    }
}

{
    "message": "Ad not found"
}
{
    "message": "Only PUT method is allowed"
}
```

