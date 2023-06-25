package m3.furama.repository;

import m3.furama.model.Service;
import m3.furama.util.paging.Page;
import m3.furama.util.paging.PageHelper;
import m3.furama.util.paging.Pageable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository implements BaseRepository<Service>{
    private final String FIND_ALL = "select * from service s join rent_type r on s.rent_type_id = r.id order by s.id desc";
    private final String FIND_ALL_PAGING = "select * from service s join rent_type r on s.rent_type_id = r.id order by s.id desc limit ?lim offset ?off";
    private static final String INSERT = "insert into service (name, area, price, max_people, standar_room" +
            ", description_other_convinience, pool_area, floor_number, service_type_id, rent_type_id) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String DELETE = "delete from service where id = ?";

    @Override
    public List<Service> findAll() {
        return findAll(FIND_ALL);
    }

    @Override
    public Page<Service> findAll(Pageable pageable) {
        int offset = (pageable.getPageNum() - 1) * pageable.getPageSize();
        String query = FIND_ALL_PAGING.replace("?lim", String.valueOf(pageable.getPageSize()));
        List<Service> services = findAll(query.replace("?off", String.valueOf(offset)));
        PageHelper<Service> helper = new PageHelper<>();
        return helper.listToPage(services, findAll().size(), pageable);
    }

    @Override
    public int save(Service service) {
        try (PreparedStatement st = DBConnection.getConnection().prepareStatement(INSERT)) {
            st.setString(1, service.getName());
            st.setInt(2, service.getArea());
            st.setDouble(3, service.getPrice());
            st.setInt(4, service.getMaxPeople());
            st.setString(5, service.getStandarRoom());
            st.setString(6, service.getDescription());
            st.setInt(7, service.getPoolArea());
            st.setInt(8, service.getFloorNumber());
            st.setInt(9, service.getServiceTypeId());
            st.setInt(10, service.getRentTypeId());

            return st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public List<Service> find(String q) {
        return null;
    }

    private Service getService(ResultSet rs) throws SQLException {
        int id = rs.getInt(1);
        String name = rs.getString(2);
        int area = rs.getInt(3);
        Double price = rs.getDouble(4);
        int maxPeople = rs.getInt(5);
        String standarRoom = rs.getString(6);
        String description = rs.getString(7);
        int poolArea = rs.getInt(8);
        int floorNumber = rs.getInt(9);
        int serviceTypeId = rs.getInt(10);
        int rentTypeId = rs.getInt(11);
        String rentType = rs.getString(13);

        return new Service(id, name, area, price, maxPeople, standarRoom, description, poolArea, floorNumber, serviceTypeId, rentTypeId, rentType);
    }

    private List<Service> findAll(String query) {
        List<Service> result = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement st = connection.prepareStatement(query)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                result.add(getService(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
