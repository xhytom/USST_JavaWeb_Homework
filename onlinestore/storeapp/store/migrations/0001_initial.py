# Generated by Django 5.1.4 on 2024-12-12 18:42

from django.db import migrations, models


class Migration(migrations.Migration):
    initial = True

    dependencies = []

    operations = [
        migrations.CreateModel(
            name="Goods",
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
                ("name", models.CharField(max_length=50)),
                ("price", models.FloatField(default=0.0)),
                ("stock", models.IntegerField(default=0)),
                ("sales", models.IntegerField(default=0)),
            ],
        ),
    ]