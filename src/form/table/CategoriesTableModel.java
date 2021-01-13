/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.table;

import entity.TblCategory;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CategoriesTableModel extends AbstractTableModel {

    private List<TblCategory> categories;

    public CategoriesTableModel(List<TblCategory> categories) {
        this.categories = categories;
        if (this.categories == null) {
            this.categories = new ArrayList<>();
        }
    }

    @Override
    public int getRowCount() {
        return categories.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TblCategory category = categories.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return category.getCategoryId();
            case 1:
                return category.getName();
            case 2:
                return category.getDescription();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        String name = "";
        switch (column) {
            case 0:
                name = "Id";
                break;
            case 1:
                name = "Name";
                break;
            case 2:
                name = "Description";
                break;
        }
        return name;
    }

    /**
     * @return the categories
     */
    public List<TblCategory> getCategories() {
        return categories;
    }

    /**
     * @param categories the categories to set
     */
    public void setCategories(List<TblCategory> categories) {
        this.categories = categories;
    }

}
