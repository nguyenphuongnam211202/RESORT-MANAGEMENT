package m3.furama.repository;

import m3.furama.model.CustomerType;
import m3.furama.util.paging.Page;
import m3.furama.util.paging.Pageable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepository implements BaseRepository<CustomerType>{
    private static final String SELECT_ALL = "select * from customer_type";

    @Override
    public List<CustomerType> findAll() {
        List<CustomerType> result = new ArrayList<>();

        try(PreparedStatement st = DBConnection.getConnection().prepareStatement(SELECT_ALL)) {
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                result.add(new CustomerType(id, name));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Page<CustomerType> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public int save(CustomerType customerType) {
        return 0;
    }

    @Override
    public List<CustomerType> find(String q) {
        return null;
    }
}
