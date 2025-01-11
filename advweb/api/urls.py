from django.urls import path

from . import views

urlpatterns = [
    path('register/', views.register, name='register'),
    path('login/', views.login, name='login'),
    path('add_adv/', views.add_adv, name='add_adv'),
    path('get_all_ads/', views.get_all_ads, name='get_all_ads'),  # 获取所有广告
    path('get_ad_by_id/<int:ad_id>/', views.get_ad_by_id, name='get_ad_by_id'),  # 根据 ID 获取广告
    path('delete_ad/<int:ad_id>/', views.delete_ad, name='delete_ad'),
    path('update_ad/<int:ad_id>/', views.update_ad, name='update_ad'),  # 修改广告
]