package com.company.Warehouse.service;

import com.company.Warehouse.dto.CWarehouseAmountReportDTO;
import com.company.Warehouse.entity.Product;
import com.company.Warehouse.entity.Warehouse;
import com.company.Warehouse.entity.WarehouseAmount;
import com.company.Warehouse.exception.ProductGroupNotFoundException;
import com.company.Warehouse.exception.ProductNotFoundException;
import com.company.Warehouse.exception.ProductTypeNotFoundException;
import com.company.Warehouse.exception.WarehouseNotFoundException;
import com.company.Warehouse.repository.ProductRepository;
import com.company.Warehouse.repository.ProductTypeRepository;
import com.company.Warehouse.repository.WarehouseAmountRepository;
import com.company.Warehouse.repository.WarehouseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class WarehouseAmountReportService {

    private final WarehouseAmountRepository warehouseAmountRepository;
    private final WarehouseRepository warehouseRepository;
    private final ProductRepository productRepository;
    private final ProductTypeRepository productTypeRepository;

    public List<CWarehouseAmountReportDTO> generateWarehouseAmountReport(
            Integer idWarehouse,
            Integer idProduct,
            Integer idProductGroup1,
            Integer idProductGroup2,
            Integer idProductGroup3,
            Integer idProductType) {

        validateParametersExist(idWarehouse,idProduct,idProductGroup1,idProductGroup2,idProductGroup3,idProductType);
        List<WarehouseAmount> warehouseAmounts = warehouseAmountRepository.getWarehouseAmount(idWarehouse,idProduct,idProductGroup1,idProductGroup2,idProductGroup3,idProductType);

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


    public void validateParametersExist(
            Integer idWarehouse,
            Integer idProduct,
            Integer idProductGroup1,
            Integer idProductGroup2,
            Integer idProductGroup3,
            Integer idProductType) {

        if (idWarehouse != null && !warehouseRepository.existsById(idWarehouse)) {
            throw new WarehouseNotFoundException("This warehouse does not exist with id: " + idWarehouse);
        }

        if (idProduct != null && !productRepository.existsById(idProduct)) {
            throw new ProductNotFoundException("This product does not exist with id: " + idProduct);
        }

        if (idProductGroup1 != null && productRepository.findByIdProductgroup1(idProductGroup1) <= 0) {
            throw new ProductGroupNotFoundException("Product group 1 does not exist with id: " + idProductGroup1);
        }

        if (idProductGroup2 != null && productRepository.findByIdProductgroup2(idProductGroup2) <= 0) {
            throw new ProductGroupNotFoundException("Product group 2 does not exist with id: " + idProductGroup2);
        }

        if (idProductGroup3 != null && productRepository.findByIdProductgroup3(idProductGroup3) <= 0) {
            throw new ProductGroupNotFoundException("Product group 3 does not exist with id: " + idProductGroup3);
        }

        if (idProductType != null && !productTypeRepository.existsById(idProductType)) {
            throw new ProductTypeNotFoundException("This product type does not exist with id: " + idProductType);
        }
    }







}
