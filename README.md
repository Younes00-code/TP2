Ce projet de la video 1 met en œuvre : 
*Une relation OneToOne entre deux entités. 
*Une relation OneToMany (par exemple : un client possédant plusieurs commandes ou articles)

Ce projet de la video 2 met en oeuvre : 
*Une relation ManyToMany entre deux entités

Technologies utilisées Langage : Java 21

Frameworks : Spring Boot Spring Data JPA Hibernate ORM

Outils : base de donnée h2 puis migration ver bd mysql Lombok (annotations pour réduire le code boilerplate) jpa web spring initializer

Chaque projet contient : 
*Des entités JPA bien annotées (avec @Entity, @Table, @Id, etc.).
*Les relations gérées via @OneToOne, @OneToMany, @ManyToMany, avec les attributs appropriés (cascade, fetch, mappedBy, etc.).
*Des repositories étendant JpaRepository pour les opérations de base. 
*Des services pour centraliser la logique métier. 
*Un fichier CommandLineRunner pour initialiser et tester les données au lancement de l’application.
*Un exemple de structure REST avec les endpoints d’insertion et de récupération des données.

![image](https://github.com/user-attachments/assets/0203cc69-6c2b-4767-8872-0172992ba6f7)
