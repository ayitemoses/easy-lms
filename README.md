# easy-lms
🎓 Projet : Gestion de formations en ligne | Learning Management System)




1. Entity — la représentation de la table BDD (Class)
Elle représente la table dans le SGBDR choisi. Rien d'autre — pas de logique métier ici.


2. Repository — l'accès aux données (Interface)

Spring Data JPA génère automatiquement le CRUD (save, findById, findAll, deleteById...). 
Tu ajoutes juste des méthodes custom si besoin, comme findByEmail.

3. DTO — ce qu'on expose à l'extérieur (classe)
Le DTO, c'est essentiellement le principe de séparation des responsabilités appliqué aux données : 
l'entité gère la persistance, le DTO gère la communication.

4. Mapper — conversion Entity ↔ DTO
Le problème que le Mapper résout
Tu as deux objets qui se ressemblent mais qui ne sont pas identiques :    Entity — représente la table BDD et DTO — représente ce qu'on échange avec le client
Sans Mapper, tu devrais écrire cette conversion partout où tu en as besoin : dans le Controller, dans le Service, dans chaque méthode... C'est là que ça devient un problème.
Le jour où tu ajoutes un champ phoneNumber à ton Employee et à ton EmployeeDTO, il faut retrouver tous les endroits où cette conversion se fait et les mettre à jour. C'est source d'oublis et de bugs.
Sans Mapper : le code dupliqué et fragile.
Avec Mapper : centralisé en un seul endroit

5. Service — le contrat (interface)
L'interface définit quoi faire, pas comment. 
Ça permet de changer l'implémentation sans toucher au reste (et facilite les tests avec des mocks)

6. ServiceImpl — la logique métier
C'est ici que se passe toute la logique : vérifications, transformations, appels au repository. 
Le Controller ne doit jamais parler directement au Repository.

7. Exception



8. Controller — l'exposition HTTP





User
├── id
├── name
├── email
├── password
└── role

Course
├── id
├── title
├── description
└── instructor_id

Lesson
├── id
├── title
├── content
├── order
└── course_id

Enrollment
├── id
├── student_id
└── course_id

LessonProgress
├── id
├── student_id
├── lesson_id
└── completed




