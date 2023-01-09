DROP TABLE IF EXISTS genres CASCADE;

CREATE TABLE genres (
                        id int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                        name varchar NOT NULL UNIQUE
);

DROP TABLE IF EXISTS books CASCADE;

CREATE TABLE books (
       id int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
       name varchar NOT NULL UNIQUE,
       genre_id int NOT NULL REFERENCES genres(id) ON DELETE CASCADE,
       author varchar NOT NULL,
       year int NOT NULL check ( year > 0  AND year < 2050)
);

DROP TABLE IF EXISTS clients CASCADE;

CREATE TABLE clients (
     id int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
     name varchar NOT NULL UNIQUE,
     age int NOT NULL check (age > 0 AND age < 111),
     email varchar NOT NULL UNIQUE,
     sex varchar NOT NULL
);

DROP TABLE IF EXISTS library CASCADE;

CREATE TABLE tokens (
    id int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    client_id int NOT NULL UNIQUE REFERENCES clients(id) ON DELETE CASCADE,
    book_id int NOT NULL REFERENCES books(id) ON DELETE CASCADE,
    order_date date,
    return date
);

INSERT INTO genres (name) VALUES
    ('Роман'),
    ('Антиутопия'),
    ('Драма'),
    ('Сатира'),
    ('Фэнтези'),
    ('Ужасы'),
    ('Комедия');

INSERT INTO books (name, genre_id, author, year) VALUES
     ('Гордость и предубеждение', (SELECT id FROM genres WHERE name = 'Роман'), 'Джейн Остен', 1813),
     ('1984', (SELECT id FROM genres WHERE name = 'Антиутопия'), 'Джордж Оруэлл', 1948),
     ('Великий Гэтсби', (SELECT id FROM genres WHERE name = 'Драма'), 'Фрэнсис Скотт Фицджеральд', 1926),
     ('Маленькие женщины', (SELECT id FROM genres WHERE name = 'Драма'), 'Луиза Мэй Олкотт', 1868),
     ('Унесенные ветром', (SELECT id FROM genres WHERE name = 'Драма'), 'Маргарет Митчелл', 1936),
     ('Скотный двор', (SELECT id FROM genres WHERE name = 'Сатира'), 'Джордж Оруэлл', 1945),
     ('Над пропастью во ржи', (SELECT id FROM genres WHERE name = 'Роман'), 'Дж. Д. Сэлинджер', 1951),
     ('Приключения Гекльберри Финна', (SELECT id FROM genres WHERE name = 'Роман'), 'Марк Твен', 1884),
     ('Хроники Нарнии', (SELECT id FROM genres WHERE name = 'Фэнтези'), 'Клайв С.Л.', 1950);

INSERT INTO clients (name, age, email, sex) VALUES
    ('Березнев Никита', 20, 'bernikcooldude@yandex.ru', 'Мужчина'),
    ('Дин Норрис', 34, 'dnorris@yandex.ru', 'Мужчина'),
    ('Мишель Томпсон', 16, 'mthompson@yandex.ru', 'Женщина'),
    ('Дженнифер Лоуренз', 16, 'jlawrense@gmail.ru', 'Женщина'),
    ('Скарлетт Йохансон', 16, 'scarlet@gmail.ru', 'Женщина'),
    ('Крис Эванс', 35, 'kevans@gmail.ru', 'Мужчина'),
    ('Хью Джекман', 20, 'hughy@gmail.ru', 'Мужчина'),
    ('Мэтью Макконахи', 20, 'mattewmc@mail.ru', 'Мужчина');
