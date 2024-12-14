from django.http import HttpResponse
from .models import Goods
from django.shortcuts import render, redirect
from django.http import JsonResponse
from django.views.decorators.csrf import csrf_exempt
from .models import Goods
import json
import logging
logger = logging.getLogger(__name__)

def index(request):
    goods = Goods.objects.all()
    return render(request, 'store/index.html', {'goods': goods})

@csrf_exempt  # 仅在测试时使用，生产环境建议开启 CSRF 保护
def addGoods(request):
    if request.method == "GET":
        return render(request, "store/addGoods.html")
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

            return JsonResponse({'message': '商品添加成功'}, status=201)

        except Exception as e:
            return JsonResponse({'error': f'发生错误: {str(e)}'}, status=400)


