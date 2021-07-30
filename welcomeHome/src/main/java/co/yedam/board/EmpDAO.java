package co.yedam.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.DAO;

public class EmpDAO extends DAO {

	// 전체사원리스트
	public List<Employee> getEmpList() {
		connect(); // DB연결 위해 Connection객체 생성.
		List<Employee> empList = new ArrayList<Employee>();
		try {
			pstmt = conn.prepareStatement("select * from emp_temp");
			rs = pstmt.executeQuery(); // 실행한 결과 받아옴.
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));// rs => 조회해온 데이터
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setHireDate(rs.getString("hire_date"));
				emp.setSalary(rs.getInt("salary"));
				emp.setJobId(rs.getString("job_id"));

				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return empList;
	}
}
