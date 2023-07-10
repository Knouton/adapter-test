# adapter-test
Учебный проект по Kafka. Consumer читает из топика объект, записывает в БД, затем записывает результат записи в БД в другой топик с определенным статусом (есть ошибка или же успешно)

По умолчанию идёт чтение из топика startProcessHeroEntry (изменить можно в настройках application.yaml)

В топик можно записать вручную(например, через Offset Explorer), либо через контроллер http://localhost:8083/api/addHeroKafka
Пример JSON для записи в топик:

{"id" : 1,
    "name": "testHero",
    "level": 1,
    "skills": [
        {
            "id" : 1,
            "name": "testSkill0507"
        },
        {
            "id" : 2,
            "name": "testSkill2"
        },
        {
            "id" : 3,
            "name": "testSkill3"
        }
    ]}

После чтения идёт запись в БД (postgresql, скрипты для создания таблиц в файле sql_sctipts.sql), обновляется id и результат записи записывается в топик statusLoadHeroEntry
Пример получаемой записи в топике:
1) успешный: {"id":353,"status":1,"msgErr":null}
2) с ошибкой: {"id":1,"status":0,"msgErr":"name must be more than 4 characters and less than 10; id :0; current name: testHero312312"}
