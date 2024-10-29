API REST de Gestion d'un Forum

Ce projet a pour objectif de développer une API REST pour la gestion d'un forum en utilisant le framework Spring Boot.

Prérequis
Java 17 : L'API est développée en Java.
Maven : Pour la gestion des dépendances.
Spring Boot - Framework pour créer l'API
Spring Data JPA - Couche ORM pour l'interaction avec la base de données
MapStruct : Pour le mappage de nos entités en DTO
slugify : Pour le generation des slug

Base de données : MySQL or ( PostgreSQL ) pour stocker les données.<br>
Lombok -    pour réduire le code passe-partout
Swagger- pour la documentation
L'API sera disponible sur http://localhost:8080
Vous pouvez tester l'API à l'aide de Postman .

Accédé a la documentation via : https://documenter.getpostman.com/view/27883695/2sAXqnfkBc

Installation
On va dans ressources puis application poperties pous la configution de notre base de données
spring.application.name=api_rest_forum

        --MYSQL--
spring.datasource.url=jdbc:mysql://localhost:3306/db_forums
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=create_drop

        --POSTGRESQL--
spring.datasource.url=jdbc:postgresql://localhost:5432/db_forums
spring.datasource.username=postgres
spring.datasource.password=root
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=create-drop


Étape 1 : Fonctionnalités de base du forum
Objectifs

Implémenter les fonctionnalités de base d'un forum sans gestion des utilisateurs.
Se familiariser avec Spring Boot et les principes RESTful.

1. Entités à implémenter

Forum : Représente un forum dans lequel les sujets sont créés.
Sujet : Représente un sujet dans un forum.
Message : Représente un message dans un sujet.

2. Fonctionnalités requises

Gestion des forums

Création d'un nouveau forum : L'utilisateur peut créer un nouveau forum.
Endpoint : POST /api/forums

Liste des forums existants : Récupérer la liste de tous les forums disponibles.
Endpoint : GET /forums

Récupération des détails d'un forum : Obtenir les détails d'un forum spécifique.
Endpoint : GET /forums/{Id}

Gestion des sujets

Création d'un nouveau sujet dans un forum : L'utilisateur peut ajouter un sujet à un forum spécifique.
Endpoint : POST /api/sujets

Liste des sujets d'un forum : Récupérer la liste de tous les sujets d'un forum spécifique.
Endpoint : GET /api/sujets/forums/{Id}

Récupération des détails d'un sujet : Obtenir les détails d'un sujet spécifique.
Endpoint : GET /api/sujets/{Id}

Gestion des messages

Création d'un nouveau message dans un sujet : L'utilisateur peut ajouter un message dans un sujet.
Endpoint : POST /api/message

Liste des messages d'un sujet : Récupérer tous les messages d'un sujet spécifique.
Endpoint : GET /api/message/{id}