# Название проекта
Форум лаборатории высоковольтных испытаний. Преследует тренировочные цели

## Содержание
- [Технологии](#технологии)
- [Использование](#использование)
- [To do](#to-do)

## Технологии
- [Spring boot starter web](https://docs.spring.io/spring-boot/docs/current/reference/html/web.html)
- [Spring boot starter data jpa](https://spring.io/guides/gs/accessing-data-jpa)
- [Spring boot starter data rest](https://spring.io/projects/spring-data-rest)
- [Spring boot starter security](https://spring.io/projects/spring-security)
- [Springdoc openai starter WebMVC](https://springdoc.org/)
- [Java json web token](https://plugins.jenkins.io/jjwt-api/)
- [Postgresql](https://www.postgresql.org/)
- [Liquibase](https://docs.liquibase.com/home.html)
- [Project Lombok](https://projectlombok.org/)
- [Docker](https://www.docker.com/)

## Использование
Управление в консоли путем ввода цифры выбранного пункта меню.  
Обрабатывает запросы по endpoint:  
GET, POST /lvi/posts.  
GET, PUT, DELETE, PATCH /lvi/posts/{id}  
GET /lvi/posts/search/findByAuthor  
GET /lvi/posts/search/findByTopic  
GET, PUT, DELETE, PATCH /lvi/posts/{id}/topic  
GET, DELETE /lvi/posts/{id}/topic/{propertyId}  
GET /lvi/profile  
GET /lvi/profile/posts  
GET /lvi/profile/topics  
GET, POST /lvi/topics  
GET, PUT, DELETE, PATCH /lvi/topics/{id}  
GET /lvi/topics/search/findByAuthor  
GET /lvi/topics/search/findByName  
GET /lvi/topics/search/findByNameContainingIgnoreCase  
GET, PUT, DELETE, PATCH /lvi/topics/{id}/posts  
GET, DELETE /lvi/topics/{id}/posts/{propertyId}  

## To do
- [ ] Написать Unit-тесты
- [ ] Реализовать Spring security в полной мере

