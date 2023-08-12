package com.company.Warehouse.service;

import com.company.Warehouse.dto.CWarehouseAmountReportDTO;
import com.company.Warehouse.entity.Product;
import com.company.Warehouse.entity.Warehouse;
import com.company.Warehouse.entity.WarehouseAmount;
import com.company.Warehouse.repository.WarehouseAmountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class WarehouseAmountReportService {

    private final WarehouseAmountRepository warehouseAmountRepository;

    public List<CWarehouseAmountReportDTO> generateWarehouseAmountReport(
            Integer idWarehouse,
            Integer idProduct,
            Integer idProductGroup1,
            Integer idProductGroup2,
            Integer idProductGroup3,
            Integer idProductType) {

        List<WarehouseAmount> warehouseAmounts = warehouseAmountRepository.getWarehouseAmount(idWarehouse,idProduct,
                idProductGroup1,idProductGroup2,idProductGroup3,idProductType);

        return generateReportDTO(warehouseAmounts);
    }


    private List<CWarehouseAmountReportDTO> generateReportDTO(List<WarehouseAmount> warehouseAmounts){
        List<CWarehouseAmountReportDTO> reportDTOs = new ArrayList<>();

        for (WarehouseAmount warehouseAmount : warehouseAmounts) {
            CWarehouseAmountReportDTO reportDTO = new CWarehouseAmountReportDTO();

            Product product = warehouseAmount.getProductByIdproduct();
            Warehouse warehouse = warehouseAmount.getWarehouseByIdwarehouse();

            reportDTO.setIdProduct(product.getId());
            reportDTO.setProductCode(product.getCode());
            reportDTO.setProductName(product.getName());
            reportDTO.setIdWarehouse(warehouse.getId());
            reportDTO.setWarehouseName(warehouse.getName());
            reportDTO.setCurrentAmount(warehouseAmount.getCurrentamount());
            reportDTO.setIdProductType(product.getProducttypeByIdproducttype().getId());

            reportDTOs.add(reportDTO);
        }

        return reportDTOs;
}







}
