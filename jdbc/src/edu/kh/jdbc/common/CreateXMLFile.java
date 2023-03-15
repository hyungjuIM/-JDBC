package edu.kh.jdbc.common;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Scanner;


public class CreateXMLFile {

	public static void main(String[] args) {

		// XML은 key:value, String형식
		// * properties 컬렉션 객체
		// - Map의 후손클래스
		// - Key, Value 모두 String 형식
		// - XML 파일 읽고, 쓰는데 특화된 메서드 제공
		try {
			Scanner sc =new Scanner(System.in);
			
			//properties 객체생성
			Properties prop = new Properties();
			System.out.print("생성할 파일 이름: ");
			String fileName = sc.nextLine();
			
			//fileOutputStream 생성
			FileOutputStream fos = new FileOutputStream(fileName+".xml");
			
			//properties 객체를 이용해서 XML파일생성
			prop.storeToXML(fos, fileName +".xml file");
			System.out.println(fileName+".xml 파일 생성완료");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
