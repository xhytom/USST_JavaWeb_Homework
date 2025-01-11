from django.db import models
from django.contrib.auth.hashers import make_password, check_password


class UserInfo(models.Model):
    objects = None
    DoesNotExist = None
    username = models.CharField(max_length=50)
    password = models.CharField(max_length=300)
    is_operator = models.BooleanField(default=False)


class Adv(models.Model):
    adv_master = models.CharField(max_length=50)  # 确保是字符串类型
    title = models.CharField(max_length=50)
    description = models.TextField()
    url = models.URLField()
    image_url = models.URLField()
    click_time = models.IntegerField(default=0)
    show_time = models.IntegerField(default=0)
