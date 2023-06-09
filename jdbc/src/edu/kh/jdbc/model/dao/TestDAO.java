package edu.kh.jdbc.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.jdbc.common.JDBCTemplate;
import edu.kh.jdbc.model.vo.TestVO;

public class TestDAO {

	// DAO(Data Access Object) : 데이터가 저장된 DB에 접근하는 객체
	//							-> SQL 수행, 결과 반환 받는 기능을 수행
	
	// JDBC 객체를 참조하기 위한 참조변수 선언
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	//XML 로 SQL을 다룰 예정 ->Properties객체 사용
	private Properties prop;
	
	
	
	public TestDAO() {
		// TestDAO객체 생성 시 바로 실행 하려고 
		//				기본생성자를 사용
		// test-query.xml 파일의 내용을 읽어와
		// Properties 객체에 저장
		try {
			prop= new Properties();
			prop.loadFromXML(new FileInputStream("test-query.xml"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 1행 삽입 DAO
	 * @param conn
	 * @param vo1
	 * @return
	 */
	public int insert(Connection conn, TestVO vo1) throws Exception {
		
		// 1. 결과 저장용 변수 선언
		int result = 0;
		
		try {
			
			// 2. SQL 작성(test-query.xml에 작성된 sql얻어오기)
			// --> prop이 저장중
			String sql = prop.getProperty("insert");
			
			// 3. PreparedStatement객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 4. ?(위치홀더)에 알맞은 값 세팅
			pstmt.setInt(1, vo1.getTestNo());
			pstmt.setString(2, vo1.getTestTitle());
			pstmt.setString(3, vo1.getTestContent());
			
			// 5. SQL수행 후 결과 반환 받기
			result =  pstmt.executeUpdate(); //1or0으로 반환
			// executeQuery(); ->SELECT 수행, ResultSet
			// executeUpdate(); -> DML수행, 반영된 행의 갯수(int) 반환
			
			
			
		}finally {
			// 6. 사용한 JDBC객체 자원 반환
			JDBCTemplate.close(pstmt);
		}
		
		// 7. SQL 수행 결과 반환
		return result;
	}

	public int update(Connection conn, TestVO vo) throws Exception {
		int result =0;
		try {
		String sql = prop.getProperty("update");
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, vo.getTestTitle());
		pstmt.setString(2, vo.getTestContent());
		pstmt.setInt(3, vo.getTestNo());
		
		result = pstmt.executeUpdate();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
		
	}

	

}
