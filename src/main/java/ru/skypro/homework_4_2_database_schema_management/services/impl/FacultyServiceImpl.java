package ru.skypro.homework_4_2_database_schema_management.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.skypro.homework_4_2_database_schema_management.exceptions.EntityNotFoundException;
import ru.skypro.homework_4_2_database_schema_management.exceptions.IncorrectArgumentException;
import ru.skypro.homework_4_2_database_schema_management.model.Faculty;
import ru.skypro.homework_4_2_database_schema_management.repository.FacultyRepository;
import ru.skypro.homework_4_2_database_schema_management.services.FacultyService;

import java.util.Collection;
import java.util.Optional;

@Service
public class FacultyServiceImpl implements FacultyService {
    private final FacultyRepository repository;

    public FacultyServiceImpl(FacultyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Faculty add(Faculty faculty) {
        return repository.save(faculty);
    }

    @Override
    public Faculty remove(Long id) {
        Faculty faculty = get(id);
        repository.deleteById(id);
        return faculty;
    }

    @Override
    public Faculty update(Faculty faculty) {
        Faculty existedFaculty = get(faculty.getId());
        return repository.save(faculty);
    }

    @Override
    public Faculty get(Long id) {
        Optional<Faculty> faculty = repository.findById(id);

        if (faculty.isPresent()) {
            return faculty.get();
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public Collection<Faculty> getByNameOrColor(String name, String color) {
        if (!StringUtils.hasText(name) && !StringUtils.hasText(color)) {
            throw new IncorrectArgumentException("Некорректное наименование и цвет факультета");
        }
        return repository.findFacultiesByNameIgnoreCaseOrColorIgnoreCase(name, color);
    }

    @Override
    public Collection<Faculty> getAll() {
        return repository.findAll();
    }
}
