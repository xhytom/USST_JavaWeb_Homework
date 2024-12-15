from django.db import models


class Goods(models.Model):
    name = models.CharField(max_length=50)
    price = models.FloatField(default=0.0)
    stock = models.IntegerField(default=0)
    sales = models.IntegerField(default=0)

    def __str__(self):
        return self.name


class UserInfo(models.Model):
    username = models.CharField(max_length=32)
    password = models.CharField(max_length=32)
    is_operator = models.IntegerField(default=0)
