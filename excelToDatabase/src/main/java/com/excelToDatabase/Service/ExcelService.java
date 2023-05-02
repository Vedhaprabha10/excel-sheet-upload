package com.excelToDatabase.Service;

import com.excelToDatabase.DTO.ExcelDto;
import com.excelToDatabase.Entity.ExcerlEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ExcelService {
    void save(MultipartFile file);
    List<ExcerlEntity> getAll();

    ExcerlEntity update(ExcelDto excelDto,Integer studentid);
}
