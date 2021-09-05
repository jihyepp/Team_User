import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class UI extends JFrame implements ActionListener {

	JPanel jp_id = new JPanel(); // id패널
	JPanel jp_pw = new JPanel(); // pw패널
	JPanel jp_pw2 = new JPanel(); // pw check 패널
	JPanel jp_nm = new JPanel(); // name 패널
	JPanel jp_b = new JPanel(); // dob select
	JPanel jp_g = new JPanel(); // gender select
	JPanel jp_m = new JPanel(); // mail select
	JPanel jp_p = new JPanel();
	JPanel jp_regi = new JPanel(); // regi btn
	// id panel
	JLabel label_id = new JLabel("ID 입력");
	JTextField txt_id = new JTextField("ID를 입력하세요", 15);
	JButton btn1 = new JButton("중복확인");
	// pw panel
	JLabel label_pw = new JLabel("비밀번호 입력");
	JLabel label_pw2 = new JLabel("비밀번호 확인");
	JTextField txt_pw = new JTextField(15);
	JTextField txt_pw2 = new JTextField(15);
	// name panel
	JLabel label_nm = new JLabel("이 름 ");
	JTextField txt_nm = new JTextField(15); // nm텍스트 입력
	// date panel
	JLabel label_b1 = new JLabel("생년월일");
	JTextField yy = new JTextField(5); // year
	JLabel label_b2 = new JLabel("년(4자)");
	JTextField dd = new JTextField(5);
	JLabel label_b3 = new JLabel("일");
	// email panel
	JLabel label_m = new JLabel("E-mail");
	JTextField txt_m = new JTextField(10);
	JLabel at = new JLabel("@");
	JButton btn2 = new JButton("중복확인");
	//gender panel
	JLabel label_g = new JLabel("성 별");
	
	// 회원가입 누를때마다 중복으로 창에 생겨나서 클래스안에 전역변수로 빼줌
	String[] m = { "Month", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
	JComboBox<String> mm = new JComboBox<String>(m); // combobox-
	
	String[] em = { "선택하세요", "gmail.com", "naver.com", "kakao.com" };
	JComboBox<String> mail = new JComboBox<String>(em);
	
	JRadioButton btnG1 = new JRadioButton("남", true);
	JRadioButton btnG2 = new JRadioButton("여", true);
	ButtonGroup grp = new ButtonGroup();
	// p_num
	JLabel label_p = new JLabel("휴대폰번호");
	JTextField txt_p = new JTextField(10);
	

	// register btn
	JButton regifin = new JButton("가입하기");

	DB check = new DB(); // DB.java 객체
	static Member member = new Member();


	public void LoginMain() {

		JFrame mainwindow = new JFrame(); // 컨테이너 mainwindow 생성
		JButton loginbutton = new JButton("로그인");
		JButton forgotID = new JButton("아이디 찾기");
		JButton forgotPW = new JButton("비밀번호 찾기");
		JButton register = new JButton("회원가입"); // 버튼
		JTextField inputID = new JTextField("ID를 입력하세요");
		JTextField inputPW = new JTextField("비밀번호를 입력하세요"); // 아이디 비밀번호 입력란
		JLabel ID = new JLabel("ID");
		JLabel PW = new JLabel("비밀번호"); // 레이블

		mainwindow.add(loginbutton);
		mainwindow.add(forgotID);
		mainwindow.add(forgotPW);
		mainwindow.add(register);
		mainwindow.add(inputID);
		mainwindow.add(inputPW);
		mainwindow.add(ID);
		mainwindow.add(PW);

		inputID.setForeground(Color.LIGHT_GRAY);
		inputPW.setForeground(Color.LIGHT_GRAY); // "입력하세요" 텍스트 회색으로. 클릭시 사라지면서 사용자가 값 입력
		mainwindow.setSize(420, 220);
		mainwindow.setLayout(null);

		forgotID.setBounds(30, 130, 120, 30);
		forgotPW.setBounds(180, 130, 120, 30);
		register.setBounds(280, 60, 90, 29);
		loginbutton.setBounds(280, 20, 90, 29);
		inputID.setBounds(100, 20, 150, 30);
		inputPW.setBounds(100, 60, 150, 30);
		ID.setBounds(80, 25, 20, 20);
		PW.setBounds(45, 65, 80, 20);
		// 위치 조정

		inputID.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if (inputID.getText().equals("ID를 입력하세요")) {
					inputID.setText("");
					inputID.setForeground(Color.black);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (inputID.getText().equals("")) {
					inputID.setForeground(Color.LIGHT_GRAY);
					inputID.setText("ID를 입력하세요");
				}
			}
		});

		inputPW.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if (inputPW.getText().equals("비밀번호를 입력하세요")) {
					inputPW.setText("");
					inputPW.setForeground(Color.black);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (inputPW.getText().equals("")) {
					inputPW.setForeground(Color.LIGHT_GRAY);
					inputPW.setText("비밀번호를 입력하세요");
				}
			}
		}); // 텍스트필드에 미리 회색으로 ID를 입력하세요라고 띄워놓고, 마우스를 클릭할시 사라지며 사용자가 입력할수있도록 바꿈

		forgotID.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FindMyID();
			}
		}); // ID찾기 누르면 FindMyID()메소드 호출

		forgotPW.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pwserchMain();
			}
		});

		register.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				regiMain();
			}
		});

		loginbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String yourID = inputID.getText();
				String yourPW = inputPW.getText();
				Func.logintest(yourID, yourPW);
				
				
				mainwindow.dispose();
			}
		});
		mainwindow.setTitle("로그인"); // 타이틀 설정
		mainwindow.setVisible(true);
		mainwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void FindMyID() {
		JFrame mainwindow = new JFrame();
		JButton withphone = new JButton("내 명의 핸드폰으로 찾기");
		JButton withemail = new JButton("내 정보에 등록된 Email로 찾기");
		JButton findPW = new JButton("PW 찾기");

		mainwindow.add(withphone);
		mainwindow.add(withemail);
		mainwindow.add(findPW);

		mainwindow.setSize(420, 220);
		mainwindow.setLayout(null);

		withphone.setBounds(70, 55, 250, 30);
		withemail.setBounds(70, 105, 250, 30);
		findPW.setBounds(290, 10, 90, 30);

		withphone.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FindMyIDwithphone();
				mainwindow.dispose();
			}
		});

		withemail.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FindMyIDwithemail();
				mainwindow.dispose();
			}
		});

		findPW.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pwserchMain();
				mainwindow.dispose();
			}
		});

		mainwindow.setTitle("ID찾기");
		mainwindow.setVisible(true);
		mainwindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void FindMyIDwithphone() {
		JFrame mainwindow = new JFrame();
		JLabel phonelabel = new JLabel("핸드폰 번호");
		JButton next = new JButton("다음");
		JTextField phonenum = new JTextField("핸드폰 번호를 입력하세요 ('-' 제외)");

		mainwindow.add(phonelabel);
		mainwindow.add(phonenum);
		mainwindow.add(next);

		phonenum.setForeground(Color.LIGHT_GRAY);

		mainwindow.setSize(420, 220);
		mainwindow.setLayout(null);

		phonelabel.setBounds(35, 75, 250, 30);
		phonenum.setBounds(120, 75, 230, 30);
		next.setBounds(300, 140, 90, 30);

		phonenum.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if (phonenum.getText().equals("핸드폰 번호를 입력하세요 ('-' 제외)")) {
					phonenum.setText("");
					phonenum.setForeground(Color.black);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (phonenum.getText().equals("")) {
					phonenum.setForeground(Color.LIGHT_GRAY);
					phonenum.setText("핸드폰 번호를 입력하세요 ('-' 제외)");
				}
			}
		});

		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				   if (phonenum.getText().equals("") || phonenum.getText().equals("번호를 입력하세요 ('-' 제외)")) {
	                    JOptionPane.showMessageDialog(null, "저장된 휴대폰 정보가 없습니다.");
	                } else {
	                String findpnum = phonenum.getText();
	                Func.foundpnum(findpnum);
	                }
			}
		});

		mainwindow.setTitle("내 명의 핸드폰으로 찾기");
		mainwindow.setVisible(true);
		mainwindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void FindMyIDwithemail() {
		JFrame mainwindow = new JFrame();
		JLabel emaillabel = new JLabel("이메일");
		JTextField emailtext = new JTextField("이메일을 입력하세요");
		JButton next = new JButton("다음");

		mainwindow.add(emaillabel);
		mainwindow.add(emailtext);
		mainwindow.add(next);

		emailtext.setForeground(Color.LIGHT_GRAY);

		mainwindow.setSize(420, 220);
		mainwindow.setLayout(null);

		emaillabel.setBounds(60, 75, 150, 30);
		emailtext.setBounds(120, 75, 230, 30);
		next.setBounds(300, 140, 90, 30);

		emailtext.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if (emailtext.getText().equals("이메일을 입력하세요")) {
					emailtext.setText("");
					emailtext.setForeground(Color.black);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (emailtext.getText().equals("")) {
					emailtext.setForeground(Color.LIGHT_GRAY);
					emailtext.setText("이메일을 입력하세요");
				}
			}
		});

		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				  if (emailtext.getText().equals("") || emailtext.getText().equals("이메일을 입력하세요")) {
	                    JOptionPane.showMessageDialog(null, "저장된 이메일 주소가 없습니다.");
	                } else {
	                String findemail = emailtext.getText();
	                Func.foundemail(findemail);
	                }
			}
		});

		mainwindow.setTitle("내 정보에 등록된 Email로 찾기");
		mainwindow.setVisible(true);
		mainwindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void FoundID(String getid) {
		JFrame mainwindow = new JFrame();
		JLabel yourIDis1 = new JLabel(" 회원님의 ID는");
		JLabel yourIDis2 = new JLabel(" 입니다.");
		JLabel yourID = new JLabel(getid);
		JButton gotoLoginMain = new JButton("로그인");
		JButton gotoFindPW = new JButton("비밀번호 찾기");

		mainwindow.add(yourIDis1);
		mainwindow.add(yourIDis2);
		mainwindow.add(yourID);
		mainwindow.add(gotoLoginMain);
		mainwindow.add(gotoFindPW);

		mainwindow.setSize(420, 220);
		mainwindow.setLayout(null);

		yourIDis1.setBounds(10, 65, 140, 30);
		yourIDis2.setBounds(335, 65, 50, 30);
		yourID.setBounds(100, 65, 230, 30);
		gotoLoginMain.setBounds(220, 130, 120, 30);
		gotoFindPW.setBounds(60, 130, 120, 30);

		gotoLoginMain.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainwindow.dispose();
			}
		});

		gotoFindPW.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pwserch();
			}
		});

		mainwindow.setVisible(true);
		mainwindow.setTitle("ID찾기 성공");
		mainwindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	
	
	
	
	public void modifyMyaccount() {
		JFrame mainwindow = new JFrame();
		JLabel addresslabel = new JLabel("주소");
		JLabel nicklabel = new JLabel("닉네임");
		JLabel emaillabel = new JLabel("이메일");
		JLabel newpwlabel = new JLabel("비밀번호");

		JTextField address = new JTextField("변경하실 주소를 입력하세요");
		JTextField nick = new JTextField("변경하실 닉네임을 입력하세요");
		JTextField email = new JTextField("변경하실 이메일을 입력하세요");
		JTextField newpw = new JTextField("변경하실 비밀번호를 입력하세요");
		JButton finish = new JButton("수정 완료");
		
		mainwindow.add(nicklabel);
		mainwindow.add(emaillabel);
		mainwindow.add(nick);
		mainwindow.add(email);
		mainwindow.add(finish);
		mainwindow.add(newpwlabel);
		mainwindow.add(newpw);
		mainwindow.add(addresslabel);
		mainwindow.add(address);

		nick.setForeground(Color.LIGHT_GRAY);
		email.setForeground(Color.LIGHT_GRAY);
		newpw.setForeground(Color.LIGHT_GRAY);
		address.setForeground(Color.LIGHT_GRAY);

		mainwindow.setSize(420, 250);
		mainwindow.setLayout(null);

		nicklabel.setBounds(20, 10, 250, 30);
		nick.setBounds(100, 10, 230, 30);
		emaillabel.setBounds(20, 50, 250, 30);
		email.setBounds(100, 50, 230, 30);
		newpwlabel.setBounds(20, 90, 250, 30);
		newpw.setBounds(100, 90, 230, 30);
		addresslabel.setBounds(20, 130, 250, 30);
		address.setBounds(100, 130, 230, 30);
		finish.setBounds(300, 170, 90, 30);

		nick.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if (nick.getText().equals("변경하실 닉네임을 입력하세요")) {
					nick.setText("");
					nick.setForeground(Color.black);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (nick.getText().equals("")) {
					nick.setForeground(Color.LIGHT_GRAY);
					nick.setText("변경하실 닉네임을 입력하세요");
				}
			}
		});
		
		email.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if (email.getText().equals("변경하실 이메일을 입력하세요")) {
					email.setText("");
					email.setForeground(Color.black);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (email.getText().equals("")) {
					email.setForeground(Color.LIGHT_GRAY);
					email.setText("변경하실 이메일을 입력하세요");
				}
			}
		});
		
		newpw.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if (newpw.getText().equals("변경하실 비밀번호를 입력하세요")) {
					newpw.setText("");
					newpw.setForeground(Color.black);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (newpw.getText().equals("")) {
					newpw.setForeground(Color.LIGHT_GRAY);
					newpw.setText("변경하실 비밀번호를 입력하세요");
				}
			}
		});
		
		address.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if (address.getText().equals("변경하실 주소를 입력하세요")) {
					address.setText("");
					address.setForeground(Color.black);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (address.getText().equals("")) {
					address.setForeground(Color.LIGHT_GRAY);
					address.setText("변경하실 주소를 입력하세요");
				}
			}
		});

		finish.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String yournick = nick.getText();
				String youremail = email.getText();
				String yournewpw = newpw.getText();
				String yournewaddress = address.getText();
				Func.modify(yournick, youremail, yournewpw, yournewaddress);
				mainwindow.dispose();
				LoginSuccessful();
			}
		});

		mainwindow.setTitle("내정보 수정");
		mainwindow.setVisible(true);
		mainwindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	public void LoginSuccessful() {
		JFrame mainwindow = new JFrame();
		JLabel welcome = new JLabel(" 님, 환영합니다.");
		Func.getemail();
		Func.getnick();
		JLabel preemail = new JLabel(Func.emailresult);
		JLabel yourNickname = new JLabel(Func.nickresult);
		JButton logout = new JButton("로그아웃");
		JButton modify = new JButton("내정보 수정");

		mainwindow.add(welcome);
		mainwindow.add(preemail);
		mainwindow.add(yourNickname);
		mainwindow.add(logout);
		mainwindow.add(modify);

		mainwindow.setSize(420, 220);
		mainwindow.setLayout(null);

		welcome.setBounds(190, 50, 120, 30);
		preemail.setBounds(80, 80, 140, 30);
		yourNickname.setBounds(80, 50, 120, 30);
		logout.setBounds(220, 130, 120, 30);
		modify.setBounds(60, 130, 120, 30);

		logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LoginMain();
				mainwindow.dispose();
			}
		});

		modify.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				modifyMyaccount();
				mainwindow.dispose();
			}
		});

		mainwindow.setTitle("로그인 성공");
		mainwindow.setVisible(true);
		mainwindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	// ----------------------------------------------------------------------------------------------------------------------------------------------------
	public void pwserchMain() {
		JFrame conta = new JFrame(); // 컨테이너 conta 만들어줌
		BorderLayout blay = new BorderLayout(); // 컨테이너에 border레이아웃 넣어주고 패널로 위치 넣어줌
		JPanel pan1 = new JPanel(); // 각 위치마다 넣을 패널 만들고 요소들 넣어줌
		JPanel pan2 = new JPanel();
		JPanel pan3 = new JPanel();
		JLabel idlabel1 = new JLabel("비밀번호를 찾으실 ID를 입력해주세요");
		JLabel idlabel2 = new JLabel("ID : ");
		JTextField idinput = new JTextField("ID를 입력하세요");
		JButton pwser = new JButton("PW 찾기");
		JButton idser = new JButton("ID 찾기");

		pan1.setBorder(new EmptyBorder(100, 5, 5, 5));
		pan2.setBorder(new EmptyBorder(5, 5, 5, 5));
		pan3.setBorder(new EmptyBorder(5, 5, 130, 5));

		pan1.add(idlabel1);
		pan2.add(idlabel2);
		pan2.add(idinput);
		pan3.add(pwser);
		pan3.add(idser);

		idinput.setForeground(Color.DARK_GRAY);
		idinput.setColumns(40);

		conta.setLayout(blay);
		conta.add(pan1, "North");
		conta.add(pan2, "Center");
		conta.add(pan3, "South");

		idinput.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if (idinput.getText().equals("ID를 입력하세요")) {
					idinput.setText("");
					idinput.setForeground(Color.black);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (idinput.getText().equals("")) {
					idinput.setForeground(Color.LIGHT_GRAY);
					idinput.setText("ID를 입력하세요");
				}
			}
		});

		pwser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (idinput.getText().equals("") || idinput.getText().equals("ID를 입력하세요")) {
					JOptionPane.showMessageDialog(null, "저장된 ID가 없습니다.");
				} else {
				String findid = idinput.getText();
				func.dbCheckID(findid); 
				//conta.dispose(); // 이렇게 안닫아주면 아이디 틀려도 계속 고치라고 알림창 뜸, 맞으면 다음창 넘어가고 이것도 안꺼짐
				}
			}
		});

		idser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("ID찾기 창으로 이동");
				FindMyID();
				conta.dispose();
			}
		});

		conta.setTitle("ID로 PW 찾기");
		conta.setSize(600, 400);
		conta.setVisible(true);
		conta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void pwserch() {
		JFrame conta = new JFrame();
		GridLayout glay = new GridLayout(2, 1);
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();

		JButton pnumser = new JButton("휴대폰 번호로 비밀번호 찾기"); // 같은 핸드폰번호 가진 정보있는지 확인 후 임시 비밀번호 만들어줌
		JButton emailser = new JButton("Email로 비밀번호 찾기"); // 같은 이메일 가진 정보있는지 확인 후 임시 비밀번호 만들어줌

		pan1.setBorder(new EmptyBorder(120, 5, 5, 5));

		pan1.add(pnumser);
		pan2.add(emailser);

		conta.setLayout(glay);
		conta.add(pan1);
		conta.add(pan2);

		pnumser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pwserchP();
				conta.dispose();

			}
		});

		emailser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pwserchE();
				conta.dispose();
			}
		});

		conta.setTitle("PW 찾기");
		conta.setSize(600, 400);
		conta.setVisible(true);
		conta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void pwserchP() {
		JFrame conta = new JFrame();
		BorderLayout blay = new BorderLayout();
		JPanel pan = new JPanel();

		JLabel plabel = new JLabel("휴대폰 번호 : ");
		JTextField pinput = new JTextField("번호를 입력하세요 ('-' 제외)"); 
		JButton find = new JButton("찾기");

		pan.setBorder(new EmptyBorder(150, 10, 10, 10));
		pan.add(plabel);
		pan.add(pinput);
		pan.add(find);

		pinput.setForeground(Color.DARK_GRAY);
		pinput.setColumns(15);

		conta.setLayout(blay);
		conta.add(pan, "Center");

		pinput.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if (pinput.getText().equals("번호를 입력하세요 ('-' 제외)")) {
					pinput.setText("");
					pinput.setForeground(Color.black);
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (pinput.getText().equals("")) {
					pinput.setForeground(Color.LIGHT_GRAY);
					pinput.setText("번호를 입력하세요 ('-' 제외)");
				}
			}
		});

		find.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (pinput.getText().equals("") || pinput.getText().equals("번호를 입력하세요 ('-' 제외)")) {
					JOptionPane.showMessageDialog(null, "저장된 휴대폰 정보가 없습니다.");
				} else {
				String findphone = pinput.getText();
				func.findpnum(findphone);
				//conta.dispose();
				}
			}
		});

		conta.setTitle("휴대폰 번호로 PW 찾기");
		conta.setSize(600, 400);
		conta.setVisible(true);
		conta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void pwserchE() {
		JFrame conta = new JFrame();
		BorderLayout blay = new BorderLayout();
		JPanel pan = new JPanel();

		JLabel elabel = new JLabel("Email 주소 : ");
		JTextField emainput = new JTextField("이메일 주소를 입력하세요");
		JButton find = new JButton("찾기");

		pan.setBorder(new EmptyBorder(150, 10, 10, 10));
		pan.add(elabel);
		pan.add(emainput);
		pan.add(find);

		emainput.setForeground(Color.DARK_GRAY);
		emainput.setColumns(50);

		conta.setLayout(blay);
		conta.add(pan, "Center");

		emainput.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if (emainput.getText().equals("이메일 주소를 입력하세요")) {
					emainput.setText("");
					emainput.setForeground(Color.black);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (emainput.getText().equals("")) {
					emainput.setForeground(Color.LIGHT_GRAY);
					emainput.setText("이메일 주소를 입력하세요");
				}
			}
		});

		find.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (emainput.getText().equals("") || emainput.getText().equals("이메일 주소를 입력하세요")) {
					JOptionPane.showMessageDialog(null, "저장된 Email 주소가 없습니다.");
				} else {
				String findema = emainput.getText();
				func.findemail(findema);
				//conta.dispose();
				}
			}
		});

		conta.setTitle("Email로 PW 찾기");
		conta.setSize(800, 400);
		conta.setVisible(true);
		conta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void pwTemporal(String tempw) {
		JFrame conta = new JFrame();
		GridLayout glay = new GridLayout(2, 1);
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();

		JLabel pwshow1 = new JLabel("회원님의 비밀번호는  ");
		JLabel pwshow2 = new JLabel(" 입니다.");
		JLabel pwtem = new JLabel(tempw);
		JLabel txtshow = new JLabel("로그인 후 My page에서 비밀번호를 수정하세요.");
		JButton login = new JButton("로그인");

		pan1.setBorder(new EmptyBorder(150, 5, 5, 5));
		pan2.setBorder(new EmptyBorder(5, 5, 100, 5));

		pan1.add(pwshow1);
		pan1.add(pwtem);
		pan1.add(pwshow2);
		pan2.add(txtshow);
		pan2.add(login);

		conta.setLayout(glay);
		conta.add(pan1);
		conta.add(pan2);

		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				conta.dispose();
			}
		});

		conta.setTitle("PW 찾기 성공");
		conta.setSize(600, 400);
		conta.setVisible(true);
		conta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------
	Func func = new Func();
	
	void regiMain() { // 회원가입 화면

		// ID(duplication check btn),PW,PW_check,name,dob(checkbox/lune click
		// btn),sex(checkbox),email,phonenum;

		// id panel
		label_id.setFont(new Font("HYGothic", Font.BOLD, 15));
		btn1.setFont(new Font("HYGothic", 10, 10));
		txt_id.setForeground(Color.LIGHT_GRAY);

		txt_id.addFocusListener(new FocusListener() {

			@Override // 커서 누르면 글씨 검정으로
			public void focusGained(FocusEvent arg0) {
				if (txt_id.getText().equals("ID를 입력하세요")) {
					txt_id.setText("");
					txt_id.setForeground(Color.BLACK);
					String id = txt_id.getText().trim();
				}
			}

			@Override // 커서 안누르면 id를 입력하세요 txt
			public void focusLost(FocusEvent e) {
				if (txt_id.getText().equals("")) {
					txt_id.setForeground(Color.LIGHT_GRAY);
					txt_id.setText("ID를 입력하세요");
				}

			}

		});

		// pw panel

		label_pw.setFont(new Font("HYGothic", Font.BOLD, 15));
		label_pw2.setFont(new Font("HYGothic", Font.BOLD, 15));
		txt_pw.setForeground(Color.LIGHT_GRAY);
		txt_pw2.setForeground(Color.LIGHT_GRAY);
		
		// pw 넣으면 색변경
		txt_pw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String pw = txt_pw.getText().trim();
			}
		});

		txt_pw2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String pw2 = txt_pw2.getText().trim();
				if(txt_pw2.getText().equals(txt_pw.getText())!=true) {
					JOptionPane.showMessageDialog(null, "비밀번호 불일치");
				}
			}
		});
		//pw2(비번확인)입력 시 pw와 동일한지 확인
		

		// nm panel
		label_nm.setFont(new Font("HYGothic", Font.BOLD, 15));

		// dob panel
		label_b1.setFont(new Font("HYGothic", Font.BOLD, 15));
		label_b2.setFont(new Font("HYGothic", 15, 15));
		//강사님께 제출하고 내가 수정함, 가입버튼 클릭 시 증식 오류 해결
	//	String[] m = { "Month", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
	//	JComboBox<String> mm = new JComboBox<String>(m); // combobox-
		label_b3.setFont(new Font("HYGothic", 15, 15));

		// gender panel - use radio button
		
		grp.add(btnG1);
		grp.add(btnG2);

		// email panel
		label_m.setFont(new Font("HYGothic", Font.BOLD, 15));
		label_m.setFont(new Font("HYGothic", 15, 15));
		//강사님께 제출하고 내가 수정함, 가입버튼 클릭 시 증식 오류 해결
	//	String[] em = { "선택하세요", "gmail.com", "naver.com", "kakao.com" };
	//	JComboBox<String> mail = new JComboBox<String>(em);

		btn2.setFont(new Font("HYGothic", 10, 10));

		// pnum panel
		label_p.setFont(new Font("HYGothic", Font.BOLD, 15));
		
		//중복확인
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("확인");
				func.checkID(txt_id.getText());
			}
		});

		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("확인");
				func.checkMail(txt_m.getText());
				
			}
		});

		// regi 버튼 액션
		regifin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("가입");

				member.setId(txt_id.getText());
				member.setPw(txt_pw.getText());
				member.setBirth(yy.getText() + (String) mm.getSelectedItem() + dd.getText());
				String gen = "";
				if (btnG1.isSelected()) {
					gen = "m";
					member.setGender(gen);
				} else if (btnG2.isSelected()) {
					gen = "w";
					member.setGender(gen);
				}
				member.setName(txt_nm.getText());
				member.setEmail(txt_m.getText() + "@" + (String) mail.getSelectedItem());
				member.setPhone(txt_p.getText());

				System.out.println(member.birth);
				// DB용클래스 하나 더 만들어서save
				func.save();

				// 가입완료 메세지 창
				JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
				dispose();
			}

			private Object getSelectedItem() {
				// TODO Auto-generated method stub
				return null;
			}
		});

		// add
		jp_id.add(label_id);
		jp_id.add(txt_id);
		jp_id.add(btn1);
		jp_pw.add(label_pw);
		jp_pw.add(txt_pw);
		jp_pw2.add(label_pw2);
		jp_pw2.add(txt_pw2);
		jp_nm.add(label_nm);
		jp_nm.add(txt_nm);
		jp_b.add(label_b1);
		jp_b.add(yy);
		jp_b.add(label_b2);
		jp_b.add(mm);
		jp_b.add(dd);
		jp_b.add(label_b3);
		jp_g.add(label_g);
		jp_g.add(btnG1);
		jp_g.add(btnG2);
		jp_m.add(label_m);
		jp_m.add(txt_m);
		jp_m.add(at);
		jp_m.add(mail);
		jp_m.add(btn2);
		jp_p.add(label_p);
		jp_p.add(txt_p);
		jp_regi.add(regifin);

		setTitle("회원가입");
		setLayout(new GridLayout(9, 1));
		// add- panel
		add(jp_id);
		add(jp_pw);
		add(jp_pw2);
		add(jp_nm);
		add(jp_b);
		add(jp_g);
		add(jp_m);
		add(jp_p);
		add(jp_regi);

		setSize(400, 600); // frame size
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}