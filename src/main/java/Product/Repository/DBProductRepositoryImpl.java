package Product.Repository;

import Product.Controller.ProductDTO.ProductDTO;
import Product.Model.Product;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class DBProductRepositoryImpl implements ProductRepository {

    private final DataSource dataSource;

    public DBProductRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Product getById(Integer id) {
        return null;
    }

    @Override
    public Collection<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * from products");

            while (rs.next()) {
                Product product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void delete(Integer productId) {

    }

    @Override
    public Integer createProduct(Product productToCreate) {
        return null;
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> products = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {


           PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE name = ?");
           preparedStatement.setString(1, name);

           ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Product product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }




}
