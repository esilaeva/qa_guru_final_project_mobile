# Проект автоматизации тестирования для мобильного приложения мессенджера Wire

<a href="https://www.wire.com/">
  <img title="Wire" src="src/test/resources/icons/logo.png" alt="Wire">
</a>

> Просто самый безопасный мессенджер.  
> Самые требовательные организации в мире полагаются на Wire с его постоянным шифрованием для чатов, голосовых и видеоконференций.

## [Содержание](#Содержание)
[Технологии и инструменты](#Технологии-и-инструменты)  
[Реализованные проверки](#Реализованные-проверки)  
[Запуск тестов из терминала](#Запуск-тестов-из-терминала)  
[Сборка в Jenkins](#Сборка-в-Jenkins)   
[Интеграция с Allure Report](#Интеграция-с-Allure-Report)  
[Интеграция с Allure TestOps](#Интеграция-с-Allure-TestOps)  
[Интеграция с Browserstack](#Интеграция-с-Browserstack)  
[Интеграция с Jira](#Интеграция-с-Jira)  
[Уведомление в Telegram](#Уведомление-в-Telegram)  
[Примеры видео выполнения тестов на Browserstack](#Примеры-видео-выполнения-тестов-на-Browserstack)


### Технологии и инструменты

Автотесты написаны на языке `Java` с использованием `JUnit 5`, `Selenide`. Сборщик проекта - `Gradle`. Для удаленного
запуска реализована задача в `Jenkins` с формированием `Allure-отчета` и отправкой результатов в `Telegram канал` при
помощи бота. Локальный запуск осуществляется в эмуляторе `Android Studio`. Удаленный запуск на реальных мобильных
усройствах производится в `Browserstack`. Для написания автотестов используется `Appium Server GUI`
и `Appium Inspector`. Так же реализована интеграция с `Allure TestOps` и `Jira`.

<p align="center">
    <a href="https://www.java.com/">
      <img width="6%" title="Java" src="src/test/resources/icons/java-original.svg" alt="java">
    </a>
    <a href="https://www.jetbrains.com/">
      <img width="6%" title="IntelliJ IDEA" src="src/test/resources/icons/Idea.svg" alt="IntelliJ IDEA">
    </a>
    <a href="https://gradle.org/">
      <img width="6%" title="Gradle" src="src/test/resources/icons/gradle-plain.svg" alt="Gradle">
    </a>
    <a href="https://junit.org/junit5/">
      <img width="6%" title="JUnit5" src="src/test/resources/icons/Junit5.svg" alt="JUnit5">
    </a>
    <a href="https://github.com/">
      <img width="6%" title="GitHub" src="src/test/resources/icons/github-mark-white.svg" alt="GitHub">
    </a>
    <a href="https://selenide.org/">
      <img width="6%" title="Selenide" src="src/test/resources/icons/Selenide.svg" alt="Selenide">
    </a>
    <a href="https://developer.android.com/studio">
      <img width="6%" title="Android Studio" src="src/test/resources/icons/Android_Studio.png" alt="Android Studio">
    </a>
    <a href="https://appium.io/">
      <img width="6%" title="Appium" src="src/test/resources/icons/appium.svg" alt="Appium">
    </a>
    <a href="https://github.com/appium/appium-inspector">
      <img width="6%" title="Appium Inspector" src="src/test/resources/icons/appium_inspector.png" alt="Appium Inspector">
    </a>
    <a href="https://github.com/appium/appium-inspector">
      <img width="6%" title="Appium Inspector" src="src/test/resources/icons/appium_inspector.png">
    </a>
    <a href="https://www.browserstack.com/">
      <img width="6%" title="Browserstack" src="src/test/resources/icons/Browserstack.svg" alt="Browserstack">
    </a>
    <a href="https://qameta.io/allure-report/">
      <img width="6%" title="Allure Report" src="src/test/resources/icons/Allure.svg" alt="Allure Report">
    </a>
    <a href="https://www.jenkins.io/">
      <img width="6%" title="Jenkins" src="src/test/resources/icons/jenkins-original.svg" alt="Jenkins">
    </a>
    <a href="https://telegram.org/">
      <img width="6%" title="Telegram" src="src/test/resources/icons/Telegram.svg" alt="Telegram">
    </a>
    <a href="https://qameta.io/">
      <img width="6%" title="Allure TestOps" src="src/test/resources/icons/Allure_TO.svg" alt="Allure TestOps">
    </a>
    <a href="https://www.atlassian.com/software/jira">
      <img width="6%" title="Jira" src="src/test/resources/icons/Jira.svg" alt="Jira">
    </a>
</p>

[Назад к содержанию](#Содержание)

### Реализованные проверки
- Успешная/неуспешная авторизация пользователя
- Удаление старых, уже не используемых устройств, из списка, подключенных к учетной записи Wire
- Создание группы для общения

[Назад к содержанию](#Содержание)

### Запуск тестов из терминала

#### Локальный запуск

`gradle clean test -DdeviceHost=emulation`

Для запуска локальных тестов на компьютере должны быть установлен эмулятор `Android Studio`.

#### Удаленный запуск

`gradle clean test -DdeviceHost=browserstack`

[Назад к содержанию](#Содержание)

### Сборка в [Jenkins](https://jenkins.autotests.cloud/job/qa_guru_21_final_project_mobile/)
Для запуска сборки необходимо перейти на страницу проекта [qa_guru_21_final_project_mobile](https://jenkins.autotests.cloud/job/qa_guru_21_final_project_mobile/)
в `Jenkins`, далее в раздел `Build with Parameters`, выбрать необходимые параметры и нажать
кнопку `Build`.

<img title="Jenkins" src="src/test/resources/screenshorts/006-jenkins.png" alt="Jenkins">

[Назад к содержанию](#Содержание)

### Интеграция с [Allure Report](https://jenkins.autotests.cloud/job/qa_guru_21_final_project_mobile/allure/)
При удаленном запуске тестов в `Jenkins`, автоматически генерируется отчет `Allure Report`

##### [Overview](https://jenkins.autotests.cloud/job/qa_guru_21_final_project_mobile/allure/#)

<img title="Allure Report" src="src/test/resources/screenshorts/004-allureReport.png" alt="Allure Report. Overview">

##### [Test details](https://jenkins.autotests.cloud/job/qa_guru_21_final_project_mobile/allure/#behaviors/7f547f5110b277a0267f688d919be626/eea69086d2f9ea02/)

<img title="Allure Report" src="src/test/resources/screenshorts/008-allureReport.png" alt="Allure Report. Test details">

[Назад к содержанию](#Содержание)

### Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/3766/test-cases/27033?treeId=0)

В отчете `Allure TestOps` можно:

- просматривать созданные тест-кейсы и чек-листы,
- запускать ручные и автоматические тестовые прогоны,
- заводить дефекты,
- собирать статистику о проделанной работе.

##### [Allure TestOps Dashboard](https://allure.autotests.cloud/project/3766/dashboards)

<img title="Allure TestOps" src="src/test/resources/screenshorts/009-testOps_dashboards.png" alt="Allure TestOps. Dashboards">

##### [Ручные и автоматические тест-кейсы](https://allure.autotests.cloud/project/3766/test-cases/27034?treeId=0)

<img title="Allure TestOps" src="src/test/resources/screenshorts/010-testOps_testCase.png" alt="Allure TestOps. Test cases">

[Назад к содержанию](#Содержание)

### Интеграция с [Browserstack](https://www.browserstack.com/)

Сервис `Browserstack`:
- позволяет прогонять автотесты на реальных устройствах;
- каждый новый build помещает в отдельную папку;
- после прогона можно увидеть продолжительность каждого теста, пометить прошел ли тест или упал;
- также для каждого теста автоматически делается видео запись прогона.  
  
<img title="Browserstack" src="src/test/resources/screenshorts/012-browserstack.png" alt="Browserstack">

[Назад к содержанию](#Содержание)

### Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-945)

Интеграция `Allure TestOps` с `Jira`, позволяет отображать в [задаче](https://jira.autotests.cloud/browse/HOMEWORK-945),
созданной в `Jira`, какие тест-кейсы были написаны в рамках задачи и результат их выполнения.

<img title="Jira" src="src/test/resources/screenshorts/011-jira.png" alt="Jira">

[Назад к содержанию](#Содержание)

### Уведомление в [Telegram](https://t.me/mobiletests)

После завершения сборки, автоматически отправляется отчет о результатах выполнения тестов в специально созданный `Telegram канал`.

<p align="center">
    <img title="Telegram" src="src/test/resources/screenshorts/005-telegram.png" alt="Telegram">
</p>

[Назад к содержанию](#Содержание)

### Примеры видео выполнения тестов на Browserstack

В отчетах Browserstack и Allure для каждого теста создается не только скриншот, но и видео его прохождения.

<p align="center">
    <img width="30%" title="Video" src="src/test/resources/screenshorts/delete_device.gif" alt="Video">
</p>

[Назад к содержанию](#Содержание)