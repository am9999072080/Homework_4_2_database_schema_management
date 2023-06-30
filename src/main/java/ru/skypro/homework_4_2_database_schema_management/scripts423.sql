-- Составить первый JOIN-запрос, чтобы получить информацию обо всех студентах (достаточно получить только имя и возраст студента)
-- школы Хогвартс вместе с названиями факультетов.
select s.name, s.age, f.name
from students s
join faculties f on s.faculty_id = f.id;

-- Составить второй JOIN-запрос, чтобы получить только тех студентов, у которых есть аватарки.
select s.name, a.file_path
from students s
         join avatar a on a.student_id = s.id;