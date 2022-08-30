random-data-generator (open source)
----

Формирование случайных данных разного типа для обучения аналитиков (миллион строк ~ 11 секунд)

На компьютере должна быть установлена Java: 
https://www.java.com/ru/download/

Актуальная версия программы: 
https://github.com/mrprogre/data-generator/raw/master/data-generator.jar

![image](https://user-images.githubusercontent.com/45883640/187388857-35acbb7f-f501-4887-b56e-fe6a957b41cb.png)


Пример выгрузки csv (миллион строк ~ 2,5 минуты):

![image](https://user-images.githubusercontent.com/45883640/187202475-5058164b-59e0-42b8-baa7-29cf76af68c2.png)

----

P.S. Приложение работает в разы быстрее, если выделить для Java больше оперативной памяти!

Делается это через указание параметра **-Xmx2048m** по адресу **Пуск -> Java -> View -> Runtime parameters**
