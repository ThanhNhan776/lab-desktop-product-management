/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.table;

import entity.TblProduct;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProductsTableModel extends AbstractTableModel {

    private List<TblProduct> products;

    public ProductsTableModel(List<TblProduct> products) {
        this.products = products;
    }

    @Override
    public int getRowCount() {
        return products.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TblProduct product = products.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return product.getProductId();
            case 1:
                return product.getName();
            case 2:
                return product.getUnit();
            case 3:
                return product.getPrice();
            case 4:
                return product.getQuantity();
            case 5:
                return product.getCategoryId();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id";
            case 1:
                return "Name";
            case 2:
                return "Unit";
            case 3:
                return "Price";
            case 4:
                return "Quantity";
            case 5:
                return "Category Id";
        }
        return null;
    }

    /**
     * @return the products
     */
    public List<TblProduct> getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(List<TblProduct> products) {
        this.products = products;
    }

}
