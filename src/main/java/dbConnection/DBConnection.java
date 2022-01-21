package dbConnection;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Skin;
import pojo.HealthCare;
import pojo.Medicine;
import pojo.SkinCare;

import java.sql.*;

public class DBConnection {

    private static final String DATABASE_URL = "jdbc:mysql://localhost/drugstore";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection conn = null;


    //Connect to DB
    public static Connection dbConnect() {
        try {
            conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;

    }


    public ObservableList<Medicine> getAllMedicines() {
        conn = dbConnect();
        ObservableList<Medicine> medicines = FXCollections.observableArrayList();
        try (Statement stm = conn.createStatement();
             ResultSet fullRs = stm.executeQuery("SELECT * FROM medicines")
        ) {
            while (fullRs.next()) {
                Medicine med = new Medicine( Integer.parseInt(fullRs.getString("id")),
                        fullRs.getString("name"),
                        Float.parseFloat(fullRs.getString("dosage")),
                        Double.parseDouble(fullRs.getString("price")),
                        Integer.parseInt(fullRs.getString("stock"))
                );
                if (med.getStock() > 0) {
                    medicines.add(med);
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return medicines;
    }


    public ObservableList<HealthCare> getAllHProducts() {
        conn = dbConnect();
        ObservableList<HealthCare> hProducts = FXCollections.observableArrayList();
        try (Statement stm = conn.createStatement();
             ResultSet fullRs = stm.executeQuery("SELECT * FROM healthcare;")
        ) {
            while (fullRs.next()) {
                HealthCare hProd = new HealthCare(Integer.parseInt(fullRs.getString("id")),
                        fullRs.getString("name"),
                        Float.parseFloat(fullRs.getString("dosage")),
                        Double.parseDouble(fullRs.getString("price")),
                        Integer.parseInt(fullRs.getString("stock"))
                );
                if (hProd.getStock() > 0) {
                    hProducts.add(hProd);
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return hProducts;
    }

    public ObservableList<SkinCare> getAllScProducts() {
        conn = dbConnect();
        ObservableList<SkinCare> scProds = FXCollections.observableArrayList();
        try (Statement stm = conn.createStatement();
             ResultSet fullRs = stm.executeQuery("SELECT * FROM skincare;")
        ) {
            while (fullRs.next()) {
                SkinCare scProd = new SkinCare(Integer.parseInt(fullRs.getString("id")),
                        fullRs.getString("name"),
                        Float.parseFloat(fullRs.getString("dosage")),
                        Double.parseDouble(fullRs.getString("price")),
                        Integer.parseInt(fullRs.getString("stock"))
                );
                if (scProd.getStock() > 0) {
                    scProds.add(scProd);
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return scProds;
    }


    public void buyProduct(int id) throws SQLException {
        conn = dbConnect();
        try {
            String decrementQuery = "UPDATE medicines SET stock = GREATEST(0,stock-1) where id = ?;";
            PreparedStatement dps = conn.prepareStatement(decrementQuery);
            dps.setInt(1, id);
            dps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }

}
