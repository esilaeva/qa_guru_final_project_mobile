# Проект по автоматизации тестирования для мобильного приложения мессенджера Wire

<p align="center">
    <a href="https://www.wire.com/">
      <img width="75%" title="Java" src="src/test/resources/icons/logo.png" align="center">
    </a>
</p>

> Просто самый безопасный мессенджер/  
> Самые требовательные организации в мире полагаются на Wire с его постоянным шифрованием для чатов, голосовых и видеоконференций.

### Содержание
[Технологии и инструменты](#Технологии-и-инструменты)  
[Реализованные проверки](#Реализованные-проверки)  
[Локальный запуск тестов из терминала](#Локальный-запуск-тестов-из-терминала)  
[Сборка в Jenkins](#Сборка-в-Jenkins)  
[Удаленный запуск из терминала](#Команда-для-удаленного-запуска-автотестов-из-терминала)   
[Интеграция с Allure Report](#Интеграция-с-Allure-Report)  
[Интеграция с Allure TestOps](#Интеграция-с-Allure-TestOps)  
[Интеграция с Jira](#Интеграция-с-Jira)  
[Уведомление в Telegram](#Уведомление-в-Telegram)  
[Примеры видео выполнения тестов на Browserstack](#Примеры-видео-выполнения-тестов-на-Browserstack)


### Технологии и инструменты

Автотесты написаны на языке `Java` с использованием `JUnit 5`, `Selenide`. Запуск браузера осуществляется в `Browserstack`.
Сборщик проекта - `Gradle`. Для удаленного запуска реализована задача в `Jenkins` с формированием `Allure-отчета` и
отправкой результатов в `Telegram` при помощи бота. Так же осуществлена интеграция с `Allure TestOps` и `Jira`.

<p>
<a href="https://www.java.com/">
  <img width="7%" title="Java" src="src/test/resources/icons/java-original.svg">
</a>
<a href="https://www.jetbrains.com/">
  <img width="7%" title="IntelliJ IDEA" src="src/test/resources/icons/Idea.svg">
</a>
<a href="https://gradle.org/">
  <img width="7%" title="Gradle" src="src/test/resources/icons/gradle-plain.svg">
</a>
<a href="https://junit.org/junit5/">
  <img width="7%" title="JUnit5" src="src/test/resources/icons/Junit5.svg">
</a>
<a href="https://github.com/">
  <img width="7%" title="GitHub" src="src/test/resources/icons/github-mark-white.svg">
</a>
<a href="https://selenide.org/">
  <img width="7%" title="Selenide" src="src/test/resources/icons/Selenide.svg">
</a>
<a href="https://developer.android.com/studio">
  <img width="7%" title="Selenoid" src="src/test/resources/icons/android_studio.png">
</a>
<a href="https://appium.io/">
  <img width="7%" title="Selenoid" src="src/test/resources/icons/appium.svg">
</a>
<a href="https://www.browserstack.com/">
  <img width="7%" title="Selenoid" src="src/test/resources/icons/browserstack.svg">
</a>
<a href="https://qameta.io/allure-report/">
  <img width="7%" title="Allure Report" src="src/test/resources/icons/Allure.svg">
</a>
<a href="https://www.jenkins.io/">
  <img width="7%" title="Jenkins" src="src/test/resources/icons/jenkins-original.svg">
</a>
<a href="https://telegram.org/">
  <img width="7%" title="Telegram" src="src/test/resources/icons/Telegram.svg">
</a>
<a href="https://qameta.io/">
  <img width="7%" title="Allure TestOps" src="src/test/resources/icons/Allure_TO.svg">
</a>
<a href="https://www.atlassian.com/software/jira">
  <img width="7%" title="Jira" src="src/test/resources/icons/Jira.svg">
</a>
</p>

### Реализованные проверки
- Успешная/неуспешная авторизация пользователя
- Удаление старых, уже не используемых устройств, из списка, подключенных к Wire
- Создание группы для общения 

### Сборка в Jenkins
Для запуска сборки необходимо перейти на страницу проекта [qa_guru_21_final_project_mobile](https://jenkins.autotests.cloud/job/qa_guru_21_final_project_mobile/)
в `Jenkins`, далее в раздел `Build with Parameters`, выбрать необходимые параметры и нажать
кнопку `Build`.

<p>
<img width="100%" title="Jenkins" src="src/test/resources/screenshorts/006-jenkins.png">
</p>

### Интеграция с Allure Report
При удаленном запуске тестов в `Jenkins`, автоматически генерируется [Allure Report](https://jenkins.autotests.cloud/job/qa_guru_21_final_project_mobile/allure/)

##### [Overview](https://jenkins.autotests.cloud/job/qa_guru_21_final_project_mobile/allure/#)

<img width="100%" title="Allure Report" src="src/test/resources/screenshorts/004-allureReport.png">

##### [Test details](https://jenkins.autotests.cloud/job/qa_guru_21_final_project_mobile/allure/#behaviors/7f547f5110b277a0267f688d919be626/eea69086d2f9ea02/)

<img width="100%" title="Allure Report" src="src/test/resources/screenshorts/008-allureReport.png">

### Интеграция с Allure TestOps

В отчете [Allure TestOps](https://allure.autotests.cloud/project/3766/test-cases/27033?treeId=0) можно:

- просматривать созданные тест-кейсы и чек-листы,
- запускать ручные и автоматические тестовые прогоны,
- заводить дефекты,
- собирать статистику о проделанной работе.

##### [Allure TestOps Dashboard](https://allure.autotests.cloud/project/3766/dashboards)

<img width="100%" title="Allure TestOps" src="src/test/resources/screenshorts/009-testOps_dashboards.png">

##### [Ручные и автоматические тест-кейсы](https://allure.autotests.cloud/project/3766/test-cases?treeId=0)

<img width="100%" title="Allure TestOps" src="src/test/resources/screenshorts/010-testOps_testCase.png">

### Интеграция с Jira

Интеграция `Allure TestOps` с `Jira`, позволяет отображать в [задаче](https://jira.autotests.cloud/browse/HOMEWORK-945), открытой в `Jira`, какие тест-кейсы были написаны в
рамках задачи и результат их выполнения.

<img width="100%" title="Jira" src="src/test/resources/screenshorts/011-jira.png">

### Уведомление в Telegram

После завершения сборки, автоматически отправляется отчет о результатах выполнения тестов в специально созданный `Telegram канал`.

<img width="40%" title="Jira" src="src/test/resources/screenshorts/005-telegram.png">

### Примеры видео выполнения тестов на Browserstack

В отчетах Browserstack и Allure для каждого теста создается не только скриншот, но и видео его прохождения.

<p>
<img width="30%" title="Selenoid Video" src="src/test/resources/screenshorts/delete_device.gif">
</p>