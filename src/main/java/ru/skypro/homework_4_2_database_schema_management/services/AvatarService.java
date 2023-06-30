package ru.skypro.homework_4_2_database_schema_management.services;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework_4_2_database_schema_management.model.Avatar;

import java.io.IOException;
import java.util.List;

public interface AvatarService {
    Avatar findAvatar(Long studentId);

    Avatar findOrCreateAvatar(Long studentId);

    void uploadAvatar(Long studentId, MultipartFile avatarFile) throws IOException;

    List<Avatar> getPage(Integer pageNumber, Integer pageSize);
}
