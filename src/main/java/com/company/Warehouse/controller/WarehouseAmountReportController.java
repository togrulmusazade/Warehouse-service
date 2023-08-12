package com.company.Warehouse.controller;

import com.company.Warehouse.dto.CWarehouseAmountReportDTO;
import com.company.Warehouse.service.WarehouseAmountReportService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.HttpStatus.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/reports")
@AllArgsConstructor
public class WarehouseAmountReportController {
    private final WarehouseAmountReportService reportService;


    @GetMapping("/warehouse-amount")
    public ResponseEntity<List<CWarehouseAmountReportDTO>> getCurrentWarehouseAmountReport(
            @RequestParam(value = "idWarehouse", required = false) Integer idWarehouse,
            @RequestParam(value = "idProduct", required = false) Integer idProduct,
            @RequestParam(value = "idProductGroup1", required = false) Integer idProductGroup1,
            @RequestParam(value = "idProductGroup2", required = false) Integer idProductGroup2,
            @RequestParam(value = "idProductGroup3", required = false) Integer idProductGroup3,
            @RequestParam(value = "idProductType", required = false) Integer idProductType) {

        List<CWarehouseAmountReportDTO> report = reportService.generateWarehouseAmountReport(
                idWarehouse, idProduct, idProductGroup1, idProductGroup2, idProductGroup3, idProductType);

        return new ResponseEntity<>(report, OK);
    }


}

