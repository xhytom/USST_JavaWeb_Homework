from django.http import JsonResponse
from django.views.decorators.csrf import csrf_exempt
from .models import UserInfo, Adv
from django.contrib.auth.hashers import check_password
import json


@csrf_exempt
def register(request):
    if request.method == 'POST':
        try:
            # 获取请求体中的数据
            data = json.loads(request.body)
            username = data.get('username')
            password = data.get('password')
            is_operator = data.get('is_operator', False)

            # 检查必填字段
            if not username or not password:
                return JsonResponse({'message': 'Username and password are required'}, status=400)

            # 判断用户名是否已存在
            if UserInfo.objects.filter(username=username).exists():
                return JsonResponse({'message': 'Username already exists'}, status=400)

            # 创建用户并保存
            user = UserInfo(username=username, password=password, is_operator=is_operator)
            user.save()

            return JsonResponse({'message': 'User registered successfully'}, status=201)

        except json.JSONDecodeError:
            return JsonResponse({'message': 'Invalid JSON format'}, status=400)
        except Exception as e:
            return JsonResponse({'message': f'Error: {str(e)}'}, status=500)
    else:
        return JsonResponse({'message': 'Only POST method is allowed'}, status=405)


@csrf_exempt
def login(request):
    if request.method == 'POST':
        try:
            # 获取请求体中的数据
            data = json.loads(request.body)
            username = data.get('username')
            password = data.get('password')

            # 判断必需字段是否存在
            if not username or not password:
                return JsonResponse({'message': 'Username and password are required'}, status=400)

            # 查询用户信息
            user = UserInfo.objects.get(username=username)

            # 直接比较明文密码
            if password == user.password:
                return JsonResponse({'message': 'Login successful', 'username': user.username})
            else:
                return JsonResponse({'message': 'Invalid credentials'}, status=400)

        except UserInfo.DoesNotExist:
            return JsonResponse({'message': 'User not found'}, status=404)
        except json.JSONDecodeError:
            return JsonResponse({'message': 'Invalid JSON format'}, status=400)
        except Exception as e:
            # 捕获其他异常并返回详细信息
            return JsonResponse({'message': f'Error: {str(e)}'}, status=500)
    else:
        return JsonResponse({'message': 'Only POST method is allowed'}, status=405)


@csrf_exempt
@csrf_exempt
def add_adv(request):
    if request.method == 'POST':
        try:
            # 获取请求体数据
            data = json.loads(request.body)

            # 从请求体中获取数据
            adv_master = data.get('adv_master')
            title = data.get('title')
            description = data.get('description')
            url = data.get('url')
            image_url = data.get('image_url')

            # 校验数据
            if not all([adv_master, title, description, url, image_url]):
                return JsonResponse({'message': 'All fields are required'}, status=400)

            # 创建广告对象
            adv = Adv(
                adv_master=adv_master,
                title=title,
                description=description,
                url=url,
                image_url=image_url
            )
            adv.save()

            # 返回成功响应
            return JsonResponse({'message': 'Ad created successfully'}, status=201)

        except json.JSONDecodeError:
            return JsonResponse({'message': 'Invalid JSON'}, status=400)
        except Exception as e:
            return JsonResponse({'message': f'An error occurred: {str(e)}'}, status=500)
    else:
        return JsonResponse({'message': 'Only POST method is allowed'}, status=405)


# 获取所有广告列表
def get_all_ads(request):
    if request.method == 'GET':
        ads = Adv.objects.all()
        ads_list = []

        for ad in ads:
            ads_list.append({
                'id': ad.id,
                'adv_master': ad.adv_master,
                'title': ad.title,
                'description': ad.description,
                'url': ad.url,
                'image_url': ad.image_url,
                'click_time': ad.click_time,
                'show_time': ad.show_time,
            })

        return JsonResponse({'ads': ads_list}, safe=False)


# 根据广告 ID 获取单个广告的详细信息
def get_ad_by_id(request, ad_id):
    if request.method == 'GET':
        try:
            ad = Adv.objects.get(id=ad_id)
            ad_data = {
                'id': ad.id,
                'adv_master': ad.adv_master,
                'title': ad.title,
                'description': ad.description,
                'url': ad.url,
                'image_url': ad.image_url,
                'click_time': ad.click_time,
                'show_time': ad.show_time,
            }
            return JsonResponse({'ad': ad_data})
        except Adv.DoesNotExist:
            return JsonResponse({'message': 'Ad not found'}, status=404)


@csrf_exempt
def delete_ad(request, ad_id):
    if request.method == 'DELETE':
        try:
            # 查找广告
            ad = Adv.objects.get(id=ad_id)
            ad.delete()
            return JsonResponse({'message': f'Ad with ID {ad_id} deleted successfully'})
        except Adv.DoesNotExist:
            return JsonResponse({'message': 'Ad not found'}, status=404)
    else:
        return JsonResponse({'message': 'Only DELETE method is allowed'}, status=405)


@csrf_exempt
def update_ad(request, ad_id):
    if request.method == 'PUT':
        try:
            ad = Adv.objects.get(id=ad_id)
            data = json.loads(request.body)

            # 更新广告字段（只更新提供的字段）
            ad.adv_master = data.get('adv_master', ad.adv_master)
            ad.title = data.get('title', ad.title)
            ad.description = data.get('description', ad.description)
            ad.url = data.get('url', ad.url)
            ad.image_url = data.get('image_url', ad.image_url)

            # 保存更改
            ad.save()

            return JsonResponse({
                'message': f'Ad with ID {ad_id} updated successfully',
                'ad': {
                    'id': ad.id,
                    'adv_master': ad.adv_master,
                    'title': ad.title,
                    'description': ad.description,
                    'url': ad.url,
                    'image_url': ad.image_url,
                    'click_time': ad.click_time,
                    'show_time': ad.show_time,
                }
            })
        except Adv.DoesNotExist:
            return JsonResponse({'message': 'Ad not found'}, status=404)
    else:
        return JsonResponse({'message': 'Only PUT method is allowed'}, status=405)


def get_all_users(request):
    if request.method == 'GET':
        users = UserInfo.objects.all().values('id', 'username', 'is_operator')
        users_list = list(users)  # 转换为列表格式
        return JsonResponse({'users': users_list}, safe=False)
    else:
        return JsonResponse({'message': 'Only GET method is allowed'}, status=405)
