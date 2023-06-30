package ru.skypro.homework_4_2_database_schema_management.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.skypro.homework_4_2_database_schema_management.model.Avatar;

import java.util.Optional;

public interface AvatarRepository extends PagingAndSortingRepository<Avatar, Long> {

    Optional<Avatar> findByStudentId(Long studentId);
}
