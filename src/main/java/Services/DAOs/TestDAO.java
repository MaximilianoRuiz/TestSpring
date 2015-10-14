package Services.DAOs;

import Services.Models.Test;

import java.sql.SQLException;
import java.util.List;

public interface TestDAO {

    public void add(Test test) throws SQLException;
    public List<Test> obtainAll() throws SQLException;
}
