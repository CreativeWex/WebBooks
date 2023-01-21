# Реализованный функционал

1) Страницы добавления, изменения и удаления человека.
   2)

# TODO

## Главная страница

- Переходы по разделам
    - Клиенты
    - Жанры
    - Авторы
    - Книги
    - Букинг
- Страница с контактами библиотеки
- Возможность авторизации пользователей
- Роли
  - **гость** - просматривает книги и жанры
  - **пользователь** - предыдущее + просматривает собственную информацию
  - **редактор** - предыдущее + просматривает всех пользователей, записывает / снимает запись книг на пользователей
  - **старший редактор** - предыдущее + добавляет / редактирует / удаляет информацию
  - **администратор** - предыдушее + выдает роль "редактор", доступ к логам
- Логи
  - информация о входе / выходе пользователей
  - информация о действиях всех ролей
---

## Клиенты

- ✅ CRUD 
- Возможность загрузки фотографии
- ✅ Spring Validator
- Добавить поля
  - список взятых книг
  - количество взятых книг
  - ✅ адрес 
  - ✅ (уникальное) телефонный номер 
  - ✅ (опциональное) описание 
  - ✅ (опциональное) любимый жанр
- Возможность сортировки
  - по алфавиту (возрастание, убывание)
  - количеству взятых книг (возрастание, убывание)

---

## Жанры

- ✅ CRUD
- Возможность загрузки фотографии
- ✅ Spring Validator
- ✅ Количество пользователей, у которых данный жанр находится в избранном
- Просмотр пользователя, который взял больше всего книг в данном жанре
- ✅Список книг в данном жанре

## Авторы

- ✅ CRUD
- не работает редактирование
- Возможность загрузки фотографии
- ✅ Spring Validator
- ✅отбражение у каждого автора списка написанных книг

# Книги
- ✅ CRUD
- Возможность загрузки фотографии
- ✅ Spring Validator
- Страница книги, на которой показаны значения полей этой книги и имя человека,
  который взял эту книгу. Если эта книга не была никем взята, должен быть текст "Эта
  книга свободна".