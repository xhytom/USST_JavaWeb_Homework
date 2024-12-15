from django.http import HttpResponse
from .models import Goods
from django.shortcuts import render, redirect
from django.http import JsonResponse
from django.views.decorators.csrf import csrf_exempt
from .models import Goods,UserInfo
import json
import logging

logger = logging.getLogger(__name__)


def list_goods(request):
    goods = Goods.objects.all()
    return render(request, 'store/list_goods.html', {'goods': goods})


@csrf_exempt  # 仅在测试时使用，生产环境建议开启 CSRF 保护
def add_goods(request):
    if request.method == "GET":
        return render(request, "store/add_goods.html")
    if request.method == "POST":
        try:
            name = request.POST.get('name')
            price = request.POST.get('price', 0.0)
            stock = request.POST.get('stock', 0)
            sales = request.POST.get('sales', 0)

            if not name:
                return JsonResponse({'error': '必须填写商品名称'}, status=400)

            price = float(price)
            stock = int(stock)
            sales = int(sales)
            goods = Goods.objects.create(
                name=name,
                price=price,
                stock=stock,
                sales=sales,
            )

            return redirect("/store/goods/list")

        except Exception as e:
            return JsonResponse({'error': f'发生错误: {str(e)}'}, status=400)


def del_goods(request, item_id):
    if request.method == "POST":
        try:
            goods_array = Goods.objects.filter(id=item_id)
            for good in goods_array:
                good.delete()

            return redirect("/store/goods/list")
        except Exception as e:
            return JsonResponse({'error': f'发生错误: {str(e)}'}, status=400)


def modify_goods(request, item_id):
    if request.method == "GET":
        print(request.method)
        goods = Goods.objects.filter(id=item_id).first()
        return render(request, 'store/modify_goods.html', {'goods': goods})

    if request.method == "POST":
        name = request.POST.get('name')
        price = request.POST.get('price')
        stock = request.POST.get('stock')
        sales = request.POST.get('sales')
        goods = Goods.objects.filter(id=item_id).first()
        goods.name = name
        goods.price = price
        goods.stock = stock
        goods.sales = sales
        goods.save()
        return redirect("/store/goods/list")


def login(request):
    if request.method == "GET":
        return render(request, 'store/login.html')

    if request.method == "POST":
        username = request.POST.get('username')
        password = request.POST.get('password')
        user = UserInfo.objects.filter(username=username).first()
        pwd = user.password
        if pwd != password:
            return redirect("/store/login")
        else:
            return redirect("/store/goods/list")
