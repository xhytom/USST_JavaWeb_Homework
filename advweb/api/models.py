from django.db import models
from django.contrib.auth.hashers import make_password, check_password


class UserInfo(models.Model):
    objects = None
    DoesNotExist = None
    username = models.CharField(max_length=50)
    password = models.CharField(max_length=300)
    is_operator = models.BooleanField(default=False)


class Adv(models.Model):
    DoesNotExist = None
    objects = None

    def __init__(self, *args, **kwargs):
        super().__init__(args, kwargs)
        self.id = None

    adv_master = models.CharField(max_length=50)
    title = models.CharField(max_length=50)
    description = models.CharField(max_length=500)
    url = models.CharField(max_length=500)
    image_url = models.CharField(max_length=500)
    click_time = models.IntegerField(default=0)
    show_time = models.IntegerField(default=0)
