# Generated by Django 5.1.4 on 2025-01-11 13:33

from django.db import migrations, models


class Migration(migrations.Migration):
    initial = True

    dependencies = []

    operations = [
        migrations.CreateModel(
            name="Adv",
            fields=[
                (
                    "id",
                    models.BigAutoField(
                        auto_created=True,
                        primary_key=True,
                        serialize=False,
                        verbose_name="ID",
                    ),
                ),
                ("adv_master", models.CharField(max_length=50)),
                ("title", models.CharField(max_length=50)),
                ("description", models.CharField(max_length=500)),
                ("url", models.CharField(max_length=500)),
                ("image_url", models.CharField(max_length=500)),
                ("click_time", models.IntegerField(default=0)),
                ("show_time", models.IntegerField(default=0)),
            ],
        ),
        migrations.CreateModel(
            name="UserInfo",
            fields=[
                (
                    "id",
                    models.BigAutoField(
                        auto_created=True,
                        primary_key=True,
                        serialize=False,
                        verbose_name="ID",
                    ),
                ),
                ("username", models.CharField(max_length=50)),
                ("password", models.CharField(max_length=20)),
                ("is_operator", models.BooleanField(default=False)),
            ],
        ),
    ]
