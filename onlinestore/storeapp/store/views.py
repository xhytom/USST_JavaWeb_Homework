from django.http import HttpResponse
from .models import Goods
from django.shortcuts import render


def index(request):
    goods = Goods.objects.all()  # 获取所有商品
    return render(request, 'store/index.html', {'goods': goods})
