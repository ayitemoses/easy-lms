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


5. Service — le contrat (interface)


6. ServiceImpl — la logique métier


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




