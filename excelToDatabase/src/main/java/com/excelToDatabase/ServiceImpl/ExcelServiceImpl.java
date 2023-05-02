package com.excelToDatabase.ServiceImpl;

import com.excelToDatabase.DTO.ExcelDto;
import com.excelToDatabase.Entity.ExcerlEntity;
import com.excelToDatabase.Helper.Helper;
import com.excelToDatabase.Repoistory.ExcelRepository;
import com.excelToDatabase.Service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Service
public class ExcelServiceImpl implements ExcelService {
    @Autowired
    ExcelRepository excellRepo;
    @Override
    public void save(MultipartFile file) {
        try {
            List<ExcerlEntity> excerlEntities = Helper.convertExcelToListOfEntity(file.getInputStream());
            excellRepo.saveAll(excerlEntities);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<ExcerlEntity> getAll() {
        List<ExcerlEntity> all = excellRepo.findAll();
        return all;
    }

    @Override
    public ExcerlEntity update(ExcelDto excelDto,Integer studentid) {
    ExcerlEntity ec = new ExcerlEntity();
    ec.setStudentid(excelDto.getStudentid());
    ec.setFirstname(excelDto.getFirstname());
    ec.setLastname(excelDto.getLastname());
    ec.setAddress(excelDto.getAddress());
    ec.setPhone(excelDto.getPhone());
    ec.setEmail(excelDto.getEmail());
     return excellRepo.save(ec);
    }
}
