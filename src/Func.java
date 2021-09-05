
import java.sql.ResultSet;
import javax.swing.JOptionPane;
//import javax.swing.JTextField;

public class Func {

	static DB dbconn = new DB();
	static UI ui = new UI();
	static String IDresult; // 로그인완료창에 띄우기위한아이디
	static String nickresult; // 로그인완료창에 띄우기위한닉네임
	static String emailresult; // 로그인완료창에 띄우기위한이메일
	Func() {
		dbconn.DBLogin();
	}

	public void dbCheckID(String findid) { // pw찾기 시 ID있는지 확인

		try {
			ResultSet rs = dbconn.statedb.executeQuery("select * from client where ID='" + findid + "';");
			
				if(rs.next()) { 
					ui.pwserch(); 
				} else {
					JOptionPane.showMessageDialog(null, "저장된 ID가 없습니다.");
				}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean checkID(String id) { // ID중복확인
		try {
			ResultSet rs = dbconn.statedb.executeQuery("select * from client where ID='" + id + "';");
			System.out.println(rs);
			while (rs.next()) {
				if (id.equals(rs.getString("ID"))) {

					JOptionPane.showMessageDialog(null, "이미 사용중인 아이디입니다.");
				} else {
					JOptionPane.showMessageDialog(null, "사용가능.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public static boolean checkMail(String mail) { // mail중복확인
		try {
			ResultSet rs = dbconn.statedb.executeQuery("select * from client where email='" + mail + "';");
			while (rs.next()) {
				if (mail.equals(rs.getString("EMAIL"))) {
					JOptionPane.showMessageDialog(null, "이미 등록된 메일입니다.");
				} else {
					JOptionPane.showMessageDialog(null, "사용가능.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	  public static void foundpnum(String findpnum) { //ID찾기시 pnum 확인 메소드
	        try {
	            ResultSet rs = dbconn.statedb.executeQuery("select * from client where pnum='" +findpnum+ "';");
	            
	            if(rs.next()) {
	            	findpnum.equals(rs.getString("pnum"));
	            	String getid = rs.getString("ID");
                    ui.FoundID(getid);
	            } else {
	            	JOptionPane.showMessageDialog(null, "찾으시는 휴대폰 번호가 없습니다."); 
	            }
	           
	            // 이렇게 했을 때 else문이 안돌아가서 위에 처럼 고침
	          /*  while (rs.next()) {
	                if (findpnum.equals(rs.getString("pnum"))) { 
	                    String getid = rs.getString("ID");
	                    ui.FoundID(getid);
	                } else {
	                    JOptionPane.showMessageDialog(null, "찾으시는 휴대폰 번호가 없습니다."); //  while문 돌리니까 else문만 안돌아감
	                }
	            } */
	            
	        } catch (Exception e) {
	            // TODO: handle exception
	        }
	    }
	    public static void foundemail(String findemail) { //ID찾기 email확인 메소드
	        try {
	            ResultSet rs = dbconn.statedb.executeQuery("select * from client where email='" +findemail+ "';");
	            
	            if(rs.next()) {
	            	findemail.equals(rs.getString("email"));
	            	String getid = rs.getString("ID");
                    ui.FoundID(getid);
	            } else {
	            	JOptionPane.showMessageDialog(null, "찾으시는 이메일 주소가 없습니다."); 
	            }
	            
	        } catch (Exception e) {
	            // TODO: handle exception
	        }
	    }
	
	public void findpnum(String findphone) {

		try {
			ResultSet rs = dbconn.statedb.executeQuery("select * from client where pnum='" + findphone + "';");
			
			 if(rs.next()) {
				 	findphone.equals(rs.getString("pnum"));
				 	String tempw = makeTempw(10);
					dbconn.statedb.executeUpdate("update client set PW='" + tempw + "' where pnum='" + findphone + "';");
					ui.pwTemporal(tempw); 
	            } else {
	            	JOptionPane.showMessageDialog(null, "찾으시는 휴대폰 번호가 없습니다."); 
	            }

			 // 이렇게 하면 돌아가긴 하는데 다른 사람의 핸드폰번호를 쳐도 그사람의 비번이 바뀜
			/* while (rs.next()) {
				if (findphone.equals(rs.getString("pnum"))) { // next()하면 다른 컬럼들이랑 값이 같아도 비번이 수정돼서 이렇게 바꿔줌
					String tempw = makeTempw(10);
					dbconn.statedb.executeUpdate("update client set PW='" + tempw + "' where pnum='" + findphone + "';");
					ui.pwTemporal(tempw); 
				} else {
					JOptionPane.showMessageDialog(null, "찾으시는 휴대폰 번호가 없습니다."); //  while문 돌리니까 else문만 안돌아감
				}
			} 
			*/
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void findemail(String findema) {

		try {
			ResultSet rs = dbconn.statedb.executeQuery("select * from client where email='" + findema + "';");
			
			 if(rs.next()) {
				 	findema.equals(rs.getString("email"));
				 	String tempw = makeTempw(10);
					dbconn.statedb.executeUpdate("update client set PW='" + tempw + "' where email='" + findema + "';");
					ui.pwTemporal(tempw); 
	            } else {
	            	JOptionPane.showMessageDialog(null, "찾으시는 이메일 주소가 없습니다."); 
	            }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static String makeTempw(int len) { // 임시비번 만드는 메소드
		// 영어+숫자 섞인 임시비번 만들고 pwtemporal() 실행하면서 JLabel에 값보내줌
		StringBuffer buffer = new StringBuffer();
		int tempw = 0;

		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
				'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a',
				'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
				'w', 'x', 'y', 'z' };

		for (int i = 0; i < len; i++) {
			tempw = (int) (charSet.length * Math.random());
			buffer.append(charSet[tempw]);
		}

		return buffer.toString();
	}

	public static void logintest(String yourID, String yourPW) {


		UI ui = new UI();
		boolean IDaccess = false;
		boolean PWaccess = false;

		try {
			ResultSet rs = dbconn.statedb.executeQuery("select ID from client where ID='" + yourID + "';");

			while (rs.next()) {
				if (yourID.equals(rs.getString("ID"))) {
					IDaccess = true;
				}
			}
		} catch (Exception E) {
		} // 1차적으로 ID존재 여부 확인

		try {
			ResultSet rs = dbconn.statedb.executeQuery("select ID from client where PW='" + yourPW + "';");

			while (rs.next()) {
				if (yourID.equals(rs.getString("ID"))) {
					PWaccess = true;
				}
			}
		} catch (Exception E) {

		} // 2차적으로 입력한 PW가 ID와 매칭되는지 확인

		if (IDaccess == true && PWaccess == true) {
			JOptionPane.showMessageDialog(null, "로그인 성공");
			IDresult = yourID;
			ui.LoginSuccessful();
		} else {
			JOptionPane.showMessageDialog(null, "입력하신 아이디 정보가 없거나, 비밀번호가 일치하지 않습니다.");
		}

	}

	
	public static void modify(String yournick,String youremail,String yournewpw, String yournewaddress) {
		
		try {
			dbconn.statedb.executeUpdate("update client set nick = '" + yournick +"' where ID = '" + IDresult +"'" );
			dbconn.statedb.executeUpdate("update client set email = '" + youremail +"' where ID = '" + IDresult +"'" );
			dbconn.statedb.executeUpdate("update client set PW = '" + yournewpw +"' where ID = '" + IDresult +"'" );
			dbconn.statedb.executeUpdate("update client set home = '" + yournewaddress +"' where ID = '" + IDresult +"'" );
		}catch(Exception E) {}
	}
	
public static void getemail() {
	
	try {
		ResultSet rs = dbconn.statedb.executeQuery("select email from client where ID='" + IDresult + "';");
		
		while(rs.next()) {
			emailresult =  rs.getString("email");
		}
	}
	catch(Exception e) {}
	
}

public static void getnick() {
	
	try {
		ResultSet rs = dbconn.statedb.executeQuery("select nick from client where ID='" + IDresult + "';");
		
		while(rs.next()) {
			nickresult =  rs.getString("nick");
		}
	}
	catch(Exception e) {}
	
}

	/*
	 * 
	 * public String dbCheckPW (String pw) { String findpw = null;
	 * 
	 * try { Class.forName("com.mysql.jdbc.Driver"); conn =
	 * DriverManager.getConnection(
	 * "jdbc:mysql://localhost:3306/site?characterEncoding=utf8", "root", "9697aa");
	 * st = conn.createStatement(); ResultSet rs =
	 * statedb.executeQuery("select * from client where PW='"+pw+"';");
	 * 
	 * while (rs.next()) { findpw = rs.getString("PW"); } } catch (Exception e) {
	 * e.printStackTrace(); } finally { try { if(st!=null) { statedb.close(); }
	 * }catch (Exception e) { } try { if(conn!=null) { conn.close(); } }catch
	 * (Exception e) { } } return findpw; }
	 * 
	 * public String dbCheckEmail(String email) { String findemail = null;
	 * 
	 * try { Class.forName("com.mysql.jdbc.Driver"); conn =
	 * DriverManager.getConnection(
	 * "jdbc:mysql://localhost:3306/site?characterEncoding=utf8", "root", "9697aa");
	 * st = conn.createStatement(); ResultSet rs =
	 * statedb.executeQuery("select * from client where email='"+email+"';");
	 * 
	 * while (rs.next()) { findemail = rs.getString("email"); } } catch (Exception
	 * e) { e.printStackTrace(); } finally { try { if(st!=null) { statedb.close(); }
	 * }catch (Exception e) { } try { if(conn!=null) { conn.close(); } }catch
	 * (Exception e) { } } return findemail;
	 * 
	 * }
	 * 
	 * public void dbinsert() { try { Class.forName("com.mysql.jdbc.Driver"); conn =
	 * DriverManager.getConnection(
	 * "jdbc:mysql://localhost:3306/site?characterEncoding=utf8", "root", "9697aa");
	 * st = conn.createStatement();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } finally { try { if(st!=null) {
	 * statedb.close(); } }catch (Exception e) { } try { if(conn!=null) {
	 * conn.close(); } }catch (Exception e) { } } }
	 * 
	 * public void dbselet(String id) { try {
	 * Class.forName("com.mysql.jdbc.Driver"); conn = DriverManager.getConnection(
	 * "jdbc:mysql://localhost:3306/site?characterEncoding=utf8", "root", "9697aa");
	 * st = conn.createStatement(); ResultSet rs =
	 * statedb.executeQuery("select * from client where ID='"+id+"';");
	 * 
	 * while (rs.next()) { // 정보 가져옴 } } catch (Exception e) { e.printStackTrace();
	 * } finally { try { if(st!=null) { statedb.close(); } }catch (Exception e) { }
	 * try { if(conn!=null) { conn.close(); } }catch (Exception e) { } } }
	 * 
	 * }
	 */
	void save() {
		UI hello = new UI();
		try {

			String sql = "insert into client(ID,PW,dob,sex,email,name,pnum,cmail) values('" + hello.member.getId()
					+ "','" + hello.member.getPw() + "','" + hello.member.getBirth() + "','" + hello.member.getGender()
					+ "','" + hello.member.getEmail() + "','" + hello.member.getName() + "','" + hello.member.getPhone()
					+ "','" + hello.member.getId() + "');";

			dbconn.statedb.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 발생 유무에 관계없이 파일은 닫아야하니까
			try {
				if (dbconn.statedb != null) {
					dbconn.statedb.close(); // statement 닫아주기
				}
			} catch (Exception e) {

			}
			try {
				if (dbconn.conndb != null) {
					dbconn.conndb.close(); // 커넥션도 닫아주기
				}
			} catch (Exception e) {

			}
		}
	}
}