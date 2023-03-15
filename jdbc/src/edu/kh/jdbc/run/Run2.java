package edu.kh.jdbc.run;

import edu.kh.jdbc.model.service.TestService;
import edu.kh.jdbc.model.vo.TestVO;

public class Run2 {
	public static void main(String[] args) {
		
		TestService service = new TestService();
		
		
		TestVO vo2 = new TestVO(2,"제목2","내용2");
		TestVO vo3 = new TestVO(3,"제목3","내용3");
		TestVO vo4 = new TestVO(4,"제목4","내용4");
		
		try {
			int result = service.insert(vo2); //1 or 0
			int result2 = service.insert(vo3); //1 or 0
			int result3 = service.insert(vo4); //1 or 0
			
			if(result >0) {
				System.out.println("insert 성공");
			}else {
				System.out.println("insert 실패");
			}
			
		} catch (Exception e) {
			System.out.println("[SQL수행 중 오류발생]");
			e.printStackTrace();
		}
	}
}
