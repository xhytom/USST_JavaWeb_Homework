from django.urls import path

from . import views

urlpatterns = [
    path("goods/list/", views.list_goods, name="list_goods"),
    path("goods/add/", views.add_goods, name="add_goods"),
    path("goods/del/<int:item_id>/", views.del_goods, name="del_goods"),
    path("goods/modify/<int:item_id>/", views.modify_goods, name="modify_goods"),
    path("login/", views.login, name="login"),
]
