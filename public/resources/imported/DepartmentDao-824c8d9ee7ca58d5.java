package example.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class DepartmentDao implements 
DaoInterface<Department, Integer>{

	@Override
	public void create(Department newDept) {
		String sqlQuery = "insert into dept values(?,?,?)";
		try(
				Connection dbConnection = JdbcUtils.buildConnection();
				PreparedStatement pstmt = 
						dbConnection.prepareStatement(sqlQuery)
					){
			int deptNo = newDept.getDeptNo();
			String deptName = newDept.getName();
			String deptLoc = newDept.getLocation();
			
			pstmt.setInt(1, deptNo);
			pstmt.setString(2, deptName);
			pstmt.setString(3, deptLoc);
			
			int updateCount = pstmt.executeUpdate();//Modifies DB state
			System.out.println(updateCount + " record inserted.");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public Collection<Department> retrieveAll() {
		Collection<Department> allDepartments = new ArrayList<>();
		String sqlQuery = "select dname, loc, deptno from dept";
		try(
				Connection dbConnection = JdbcUtils.buildConnection();
				Statement stmt = dbConnection.createStatement();
				ResultSet recordSet = stmt.executeQuery(sqlQuery) 
			){
			while(recordSet.next()) {
				String deptName = recordSet.getString(1);
				String deptLoc = recordSet.getString(2);
				int deptNo = recordSet.getInt(3);
				Department dept = new Department(deptNo, deptName, deptLoc);
				allDepartments.add(dept);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return allDepartments;
	}

	@Override
	public Department retrieveById(Integer departmentNo) {
		Department foundDept = null;
		String sqlQuery = 
		"select dname, loc, deptno from dept where deptno = ?";
		try(
			Connection dbConnection = JdbcUtils.buildConnection();
			PreparedStatement pstmt = 
					dbConnection.prepareStatement(sqlQuery)
				){
			pstmt.setInt(1, departmentNo);
			ResultSet recordSet = pstmt.executeQuery();
			if(recordSet.next()) {
				String deptName = recordSet.getString(1);
				String deptLoc = recordSet.getString(2);
				int deptNo = recordSet.getInt(3);
				foundDept = new Department(deptNo, deptName, deptLoc);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return foundDept;
	}

	@Override
	public void update(Department updatedDept) {
		String sqlQuery = 
		"update dept set dname = ?, loc = ? where deptno = ?";
		try(
				Connection dbConnection = JdbcUtils.buildConnection();
				PreparedStatement pstmt = 
						dbConnection.prepareStatement(sqlQuery)
					){
			int deptNo = updatedDept.getDeptNo();
			String deptName = updatedDept.getName();
			String deptLoc = updatedDept.getLocation();
			
			pstmt.setInt(3, deptNo);
			pstmt.setString(1, deptName);
			pstmt.setString(2, deptLoc);
			
			int updateCount = pstmt.executeUpdate();//Modifies DB state
			System.out.println(updateCount + " record updated.");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public void deleteById(Integer deptNo) {
		String sqlQuery = "delete from dept where deptno = ?";
		try(
				Connection dbConnection = JdbcUtils.buildConnection();
				PreparedStatement pstmt = 
						dbConnection.prepareStatement(sqlQuery)
					){
			pstmt.setInt(1, deptNo);
			int updateCount = pstmt.executeUpdate();
			System.out.println(updateCount + " record deleted");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}










