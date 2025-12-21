package table;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.Customer;


public class TableCustomer extends AbstractTableModel {

    private List<Customer> customers;
    private final String[] columnNames = {
        "ID", "Nama", "Phone", "Email", "Tier"
    };

    public TableCustomer(List<Customer> customers) {
        this.customers = customers;
    }

    public int getRowCount() {
        return customers.size();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public Object getValueAt(int row, int col) {
        Customer c = customers.get(row);
        switch (col) {
            case 0: return c.getCustomerId();
            case 1: return c.getName();
            case 2: return c.getPhone();
            case 3: return c.getEmail();
            case 4: return c.getTier();
            default: return null;
        }
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }
}

