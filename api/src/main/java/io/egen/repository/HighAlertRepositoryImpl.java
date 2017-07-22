package io.egen.repository;

import io.egen.entity.HighAlert;
import io.egen.entity.Reading;
import io.egen.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

//--------------An implementation of Reading Repository interface--------------//

public class HighAlertRepositoryImpl implements HighAlertRepository {



    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<HighAlert> getAHighAlerts() {

        return jdbcTemplate.query("SELECT v.vin,count(*) as count FROM veh_db.alert as a, veh_db.vehicle as v, veh_db.reading as r where a.rin=r.rin and v.vin=r.vin and a.priority='HIGH' and a.datetime>=SUBDATE( CURRENT_TIMESTAMP , INTERVAL 2 HOUR) group by v.vin",new RowMapper<HighAlert>(){
                public HighAlert mapRow(ResultSet rs, int rownumber) throws SQLException {
                HighAlert alert=new HighAlert();
                alert.setVin(rs.getString(1));
                alert.setCount(rs.getInt(2));
                return alert;
            }
        });
    }
}