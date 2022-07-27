package kz.bitlab;

import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class DBUtil {
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java_pro_2_db", "postgres", "Bota1901");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Item> getAllItems() {
        ArrayList<Item> items = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM items ORDER BY id ASC");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getLong("id"));
                item.setName(resultSet.getString("name"));
                item.setPrice(resultSet.getInt("price"));
                item.setAmount(resultSet.getInt("amount"));
                items.add(item);
            }

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    public static void addItem(Item item) {
        try {

            PreparedStatement statement = connection.prepareStatement("" + "INSERT INTO  items (name , price , amount)"
                    + "VALUES (? , ? , ? )");
            statement.setString(1, item.getName());
            statement.setDouble(2, item.getPrice());
            statement.setInt(3, item.getAmount());

            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Item getItem(Long id) {
        Item item = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM items WHERE id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                item = new Item();
                item.setId(resultSet.getLong("id"));
                item.setName(resultSet.getString("name"));
                item.setPrice(resultSet.getDouble("price"));
                item.setAmount(resultSet.getInt("amount"));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    public static void updateUtil(Item item) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE items SET name = ?, price = ?, amount = ?" +
                    "WHERE id = ?");
            statement.setString(1, item.getName());
            statement.setDouble(2, item.getPrice());
            statement.setInt(3, item.getAmount());
            statement.setLong(4, item.getId());

            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteItem(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM items WHERE id = ?");
            statement.setLong(1,id);
            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}


