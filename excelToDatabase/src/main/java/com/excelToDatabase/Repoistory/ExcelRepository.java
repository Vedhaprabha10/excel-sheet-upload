package com.excelToDatabase.Repoistory;

import com.excelToDatabase.Entity.ExcerlEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExcelRepository extends JpaRepository<ExcerlEntity,Integer> {
}
