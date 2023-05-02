package com.excelToDatabase.Controller;

import com.excelToDatabase.DTO.ExcelDto;
import com.excelToDatabase.Entity.ExcerlEntity;
import com.excelToDatabase.Service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("upload")
public class ExcelController{

    @Autowired
    ExcelService excelService;

    @PostMapping("/excel")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        excelService.save(file);
        return ResponseEntity.status(HttpStatus.CREATED).body("file is created");
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll()
    {
        List<ExcerlEntity> all = excelService.getAll();
        return ResponseEntity.status(HttpStatus.FOUND).body(all);
    }
    @PutMapping("/update/{studentid}")
    public ResponseEntity<?> updateData(@RequestBody ExcelDto excelDto,@PathVariable("studentid")Integer studentid) {
        ExcerlEntity update = excelService.update(excelDto,studentid);
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("file is updated");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please enter valid id");
        }
        }
}