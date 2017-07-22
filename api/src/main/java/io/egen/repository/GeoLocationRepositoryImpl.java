package io.egen.repository;


import io.egen.entity.GeoLocation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class GeoLocationRepositoryImpl implements GeoLocationRepository{

    @PersistenceContext
    private EntityManager entityManager;


//    private JdbcTemplate jdbcTemplate;
//
//    public JdbcTemplate getJdbcTemplate() {
//        return jdbcTemplate;
//    }
//
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public List<GeoLocation> getLocation() {
//
//        return jdbcTemplate.query("SELECT r.vin, r.latitude,r.longitude,r.timestamp FROM  veh_db.reading as r where r.timestamp >(current_timestamp- 30)",new RowMapper<GeoLocation>(){
//            public GeoLocation mapRow(ResultSet rs, int rownumber) throws SQLException {
//               GeoLocation geo=new GeoLocation();
//                geo.setVin(rs.getString(1));
//                geo.setLatitude(rs.getDouble(2));
//                geo.setLongitude(rs.getDouble(3));
//                return geo;
//            }
//        });
//    }

    public List<GeoLocation> getGeo() {
        TypedQuery<GeoLocation> query = entityManager.createNamedQuery("GeoLocation.getGeo", GeoLocation.class);
        return query.getResultList();
    }

    public List<GeoLocation> findGeo(String vin) {
        TypedQuery<GeoLocation> query = entityManager.createNamedQuery("GeoLocation.findGeo", GeoLocation.class);
        query.setParameter("paramVin", vin);
        List<GeoLocation> resutList = query.getResultList();
        if(resutList!= null){
            return resutList;
        }
        else {
            return null;
        }
    }

    public String create(GeoLocation geoLocation) {
        entityManager.persist(geoLocation);
        return "";
    }
}
