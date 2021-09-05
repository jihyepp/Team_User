import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class UI extends JFrame implements ActionListener {

	JPanel jp_id = new JPanel(); // id�뙣�꼸
	JPanel jp_pw = new JPanel(); // pw�뙣�꼸
	JPanel jp_pw2 = new JPanel(); // pw check �뙣�꼸
	JPanel jp_nm = new JPanel(); // name �뙣�꼸
	JPanel jp_b = new JPanel(); // dob select
	JPanel jp_g = new JPanel(); // gender select
	JPanel jp_m = new JPanel(); // mail select
	JPanel jp_p = new JPanel();
	JPanel jp_regi = new JPanel(); // regi btn
	// id panel
	JLabel label_id = new JLabel("ID �엯�젰");
	JTextField txt_id = new JTextField("ID瑜� �엯�젰�븯�꽭�슂", 15);
	JButton btn1 = new JButton("以묐났�솗�씤");
	// pw panel
	JLabel label_pw = new JLabel("鍮꾨�踰덊샇 �엯�젰");
	JLabel label_pw2 = new JLabel("鍮꾨�踰덊샇 �솗�씤");
	JTextField txt_pw = new JTextField(15);
	JTextField txt_pw2 = new JTextField(15);
	// name panel
	JLabel label_nm = new JLabel("�씠 由� ");
	JTextField txt_nm = new JTextField(15); // nm�뀓�뒪�듃 �엯�젰
	// date panel
	JLabel label_b1 = new JLabel("�깮�뀈�썡�씪");
	JTextField yy = new JTextField(5); // year
	JLabel label_b2 = new JLabel("�뀈(4�옄)");
	JTextField dd = new JTextField(5);
	JLabel label_b3 = new JLabel("�씪");
	// email panel
	JLabel label_m = new JLabel("E-mail");
	JTextField txt_m = new JTextField(10);
	JLabel at = new JLabel("@");
	JButton btn2 = new JButton("以묐났�솗�씤");
	//gender panel
	JLabel label_g = new JLabel("�꽦 蹂�");
	
	// �쉶�썝媛��엯 �늻瑜쇰븣留덈떎 以묐났�쑝濡� 李쎌뿉 �깮寃⑤굹�꽌 �겢�옒�뒪�븞�뿉 �쟾�뿭蹂��닔濡� 鍮쇱쨲
	String[] m = { "Month", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
	JComboBox<String> mm = new JComboBox<String>(m); // combobox-
	
	String[] em = { "�꽑�깮�븯�꽭�슂", "gmail.com", "naver.com", "kakao.com" };
	JComboBox<String> mail = new JComboBox<String>(em);
	
	JRadioButton btnG1 = new JRadioButton("�궓", true);
	JRadioButton btnG2 = new JRadioButton("�뿬", true);
	ButtonGroup grp = new ButtonGroup();
	// p_num
	JLabel label_p = new JLabel("�쑕���룿踰덊샇");
	JTextField txt_p = new JTextField(10);
	

	// register btn
	JButton regifin = new JButton("媛��엯�븯湲�");

	DB check = new DB(); // DB.java 媛앹껜
	static Member member = new Member();


	public void LoginMain() {

		JFrame mainwindow = new JFrame(); // 而⑦뀒�씠�꼫 mainwindow �깮�꽦
		JButton loginbutton = new JButton("濡쒓렇�씤");
		JButton forgotID = new JButton("�븘�씠�뵒 李얘린");
		JButton forgotPW = new JButton("鍮꾨�踰덊샇 李얘린");
		JButton register = new JButton("�쉶�썝媛��엯"); // 踰꾪듉
		JTextField inputID = new JTextField("ID瑜� �엯�젰�븯�꽭�슂");
		JTextField inputPW = new JTextField("鍮꾨�踰덊샇瑜� �엯�젰�븯�꽭�슂"); // �븘�씠�뵒 鍮꾨�踰덊샇 �엯�젰��
		JLabel ID = new JLabel("ID");
		JLabel PW = new JLabel("鍮꾨�踰덊샇"); // �젅�씠釉�

		mainwindow.add(loginbutton);
		mainwindow.add(forgotID);
		mainwindow.add(forgotPW);
		mainwindow.add(register);
		mainwindow.add(inputID);
		mainwindow.add(inputPW);
		mainwindow.add(ID);
		mainwindow.add(PW);

		inputID.setForeground(Color.LIGHT_GRAY);
		inputPW.setForeground(Color.LIGHT_GRAY); // "�엯�젰�븯�꽭�슂" �뀓�뒪�듃 �쉶�깋�쑝濡�. �겢由��떆 �궗�씪吏�硫댁꽌 �궗�슜�옄媛� 媛� �엯�젰
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
		// �쐞移� 議곗젙

		inputID.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if (inputID.getText().equals("ID瑜� �엯�젰�븯�꽭�슂")) {
					inputID.setText("");
					inputID.setForeground(Color.black);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (inputID.getText().equals("")) {
					inputID.setForeground(Color.LIGHT_GRAY);
					inputID.setText("ID瑜� �엯�젰�븯�꽭�슂");
				}
			}
		});

		inputPW.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if (inputPW.getText().equals("鍮꾨�踰덊샇瑜� �엯�젰�븯�꽭�슂")) {
					inputPW.setText("");
					inputPW.setForeground(Color.black);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (inputPW.getText().equals("")) {
					inputPW.setForeground(Color.LIGHT_GRAY);
					inputPW.setText("鍮꾨�踰덊샇瑜� �엯�젰�븯�꽭�슂");
				}
			}
		}); // �뀓�뒪�듃�븘�뱶�뿉 誘몃━ �쉶�깋�쑝濡� ID瑜� �엯�젰�븯�꽭�슂�씪怨� �쓣�썙�넃怨�, 留덉슦�뒪瑜� �겢由��븷�떆 �궗�씪吏�硫� �궗�슜�옄媛� �엯�젰�븷�닔�엳�룄濡� 諛붽퓞

		forgotID.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FindMyID();
			}
		}); // ID李얘린 �늻瑜대㈃ FindMyID()硫붿냼�뱶 �샇異�

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
		mainwindow.setTitle("濡쒓렇�씤"); // ���씠�� �꽕�젙
		mainwindow.setVisible(true);
		mainwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void FindMyID() {
		JFrame mainwindow = new JFrame();
		JButton withphone = new JButton("�궡 紐낆쓽 �빖�뱶�룿�쑝濡� 李얘린");
		JButton withemail = new JButton("�궡 �젙蹂댁뿉 �벑濡앸맂 Email濡� 李얘린");
		JButton findPW = new JButton("PW 李얘린");

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

		mainwindow.setTitle("ID李얘린");
		mainwindow.setVisible(true);
		mainwindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void FindMyIDwithphone() {
		JFrame mainwindow = new JFrame();
		JLabel phonelabel = new JLabel("�빖�뱶�룿 踰덊샇");
		JButton next = new JButton("�떎�쓬");
		JTextField phonenum = new JTextField("�빖�뱶�룿 踰덊샇瑜� �엯�젰�븯�꽭�슂 ('-' �젣�쇅)");

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
				if (phonenum.getText().equals("�빖�뱶�룿 踰덊샇瑜� �엯�젰�븯�꽭�슂 ('-' �젣�쇅)")) {
					phonenum.setText("");
					phonenum.setForeground(Color.black);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (phonenum.getText().equals("")) {
					phonenum.setForeground(Color.LIGHT_GRAY);
					phonenum.setText("�빖�뱶�룿 踰덊샇瑜� �엯�젰�븯�꽭�슂 ('-' �젣�쇅)");
				}
			}
		});

		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				   if (phonenum.getText().equals("") || phonenum.getText().equals("踰덊샇瑜� �엯�젰�븯�꽭�슂 ('-' �젣�쇅)")) {
	                    JOptionPane.showMessageDialog(null, "���옣�맂 �쑕���룿 �젙蹂닿� �뾾�뒿�땲�떎.");
	                } else {
	                String findpnum = phonenum.getText();
	                Func.foundpnum(findpnum);
	                }
			}
		});

		mainwindow.setTitle("�궡 紐낆쓽 �빖�뱶�룿�쑝濡� 李얘린");
		mainwindow.setVisible(true);
		mainwindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void FindMyIDwithemail() {
		JFrame mainwindow = new JFrame();
		JLabel emaillabel = new JLabel("�씠硫붿씪");
		JTextField emailtext = new JTextField("�씠硫붿씪�쓣 �엯�젰�븯�꽭�슂");
		JButton next = new JButton("�떎�쓬");

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
				if (emailtext.getText().equals("�씠硫붿씪�쓣 �엯�젰�븯�꽭�슂")) {
					emailtext.setText("");
					emailtext.setForeground(Color.black);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (emailtext.getText().equals("")) {
					emailtext.setForeground(Color.LIGHT_GRAY);
					emailtext.setText("�씠硫붿씪�쓣 �엯�젰�븯�꽭�슂");
				}
			}
		});

		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				  if (emailtext.getText().equals("") || emailtext.getText().equals("�씠硫붿씪�쓣 �엯�젰�븯�꽭�슂")) {
	                    JOptionPane.showMessageDialog(null, "���옣�맂 �씠硫붿씪 二쇱냼媛� �뾾�뒿�땲�떎.");
	                } else {
	                String findemail = emailtext.getText();
	                Func.foundemail(findemail);
	                }
			}
		});

		mainwindow.setTitle("�궡 �젙蹂댁뿉 �벑濡앸맂 Email濡� 李얘린");
		mainwindow.setVisible(true);
		mainwindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void FoundID(String getid) {
		JFrame mainwindow = new JFrame();
		JLabel yourIDis1 = new JLabel(" �쉶�썝�떂�쓽 ID�뒗");
		JLabel yourIDis2 = new JLabel(" �엯�땲�떎.");
		JLabel yourID = new JLabel(getid);
		JButton gotoLoginMain = new JButton("濡쒓렇�씤");
		JButton gotoFindPW = new JButton("鍮꾨�踰덊샇 李얘린");

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
		mainwindow.setTitle("ID李얘린 �꽦怨�");
		mainwindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	
	
	
	
	public void modifyMyaccount() {
		JFrame mainwindow = new JFrame();
		JLabel addresslabel = new JLabel("二쇱냼");
		JLabel nicklabel = new JLabel("�땳�꽕�엫");
		JLabel emaillabel = new JLabel("�씠硫붿씪");
		JLabel newpwlabel = new JLabel("鍮꾨�踰덊샇");

		JTextField address = new JTextField("蹂�寃쏀븯�떎 二쇱냼瑜� �엯�젰�븯�꽭�슂");
		JTextField nick = new JTextField("蹂�寃쏀븯�떎 �땳�꽕�엫�쓣 �엯�젰�븯�꽭�슂");
		JTextField email = new JTextField("蹂�寃쏀븯�떎 �씠硫붿씪�쓣 �엯�젰�븯�꽭�슂");
		JTextField newpw = new JTextField("蹂�寃쏀븯�떎 鍮꾨�踰덊샇瑜� �엯�젰�븯�꽭�슂");
		JButton finish = new JButton("�닔�젙 �셿猷�");
		
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
				if (nick.getText().equals("蹂�寃쏀븯�떎 �땳�꽕�엫�쓣 �엯�젰�븯�꽭�슂")) {
					nick.setText("");
					nick.setForeground(Color.black);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (nick.getText().equals("")) {
					nick.setForeground(Color.LIGHT_GRAY);
					nick.setText("蹂�寃쏀븯�떎 �땳�꽕�엫�쓣 �엯�젰�븯�꽭�슂");
				}
			}
		});
		
		email.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if (email.getText().equals("蹂�寃쏀븯�떎 �씠硫붿씪�쓣 �엯�젰�븯�꽭�슂")) {
					email.setText("");
					email.setForeground(Color.black);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (email.getText().equals("")) {
					email.setForeground(Color.LIGHT_GRAY);
					email.setText("蹂�寃쏀븯�떎 �씠硫붿씪�쓣 �엯�젰�븯�꽭�슂");
				}
			}
		});
		
		newpw.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if (newpw.getText().equals("蹂�寃쏀븯�떎 鍮꾨�踰덊샇瑜� �엯�젰�븯�꽭�슂")) {
					newpw.setText("");
					newpw.setForeground(Color.black);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (newpw.getText().equals("")) {
					newpw.setForeground(Color.LIGHT_GRAY);
					newpw.setText("蹂�寃쏀븯�떎 鍮꾨�踰덊샇瑜� �엯�젰�븯�꽭�슂");
				}
			}
		});
		
		address.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if (address.getText().equals("蹂�寃쏀븯�떎 二쇱냼瑜� �엯�젰�븯�꽭�슂")) {
					address.setText("");
					address.setForeground(Color.black);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (address.getText().equals("")) {
					address.setForeground(Color.LIGHT_GRAY);
					address.setText("蹂�寃쏀븯�떎 二쇱냼瑜� �엯�젰�븯�꽭�슂");
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

		mainwindow.setTitle("�궡�젙蹂� �닔�젙");
		mainwindow.setVisible(true);
		mainwindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	public void LoginSuccessful() {
		JFrame mainwindow = new JFrame();
		JLabel welcome = new JLabel(" �떂, �솚�쁺�빀�땲�떎.");
		Func.getemail();
		Func.getnick();
		JLabel preemail = new JLabel(Func.emailresult);
		JLabel yourNickname = new JLabel(Func.nickresult);
		JButton logout = new JButton("濡쒓렇�븘�썐");
		JButton modify = new JButton("�궡�젙蹂� �닔�젙");

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

		mainwindow.setTitle("濡쒓렇�씤 �꽦怨�");
		mainwindow.setVisible(true);
		mainwindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	// ----------------------------------------------------------------------------------------------------------------------------------------------------
	public void pwserchMain() {
		JFrame conta = new JFrame(); // 而⑦뀒�씠�꼫 conta 留뚮뱾�뼱以�
		BorderLayout blay = new BorderLayout(); // 而⑦뀒�씠�꼫�뿉 border�젅�씠�븘�썐 �꽔�뼱二쇨퀬 �뙣�꼸濡� �쐞移� �꽔�뼱以�
		JPanel pan1 = new JPanel(); // 媛� �쐞移섎쭏�떎 �꽔�쓣 �뙣�꼸 留뚮뱾怨� �슂�냼�뱾 �꽔�뼱以�
		JPanel pan2 = new JPanel();
		JPanel pan3 = new JPanel();
		JLabel idlabel1 = new JLabel("鍮꾨�踰덊샇瑜� 李얠쑝�떎 ID瑜� �엯�젰�빐二쇱꽭�슂");
		JLabel idlabel2 = new JLabel("ID : ");
		JTextField idinput = new JTextField("ID瑜� �엯�젰�븯�꽭�슂");
		JButton pwser = new JButton("PW 李얘린");
		JButton idser = new JButton("ID 李얘린");

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
				if (idinput.getText().equals("ID瑜� �엯�젰�븯�꽭�슂")) {
					idinput.setText("");
					idinput.setForeground(Color.black);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (idinput.getText().equals("")) {
					idinput.setForeground(Color.LIGHT_GRAY);
					idinput.setText("ID瑜� �엯�젰�븯�꽭�슂");
				}
			}
		});

		pwser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (idinput.getText().equals("") || idinput.getText().equals("ID瑜� �엯�젰�븯�꽭�슂")) {
					JOptionPane.showMessageDialog(null, "���옣�맂 ID媛� �뾾�뒿�땲�떎.");
				} else {
				String findid = idinput.getText();
				func.dbCheckID(findid); 
				//conta.dispose(); // �씠�젃寃� �븞�떕�븘二쇰㈃ �븘�씠�뵒 ���젮�룄 怨꾩냽 怨좎튂�씪怨� �븣由쇱갹 �쑙, 留욎쑝硫� �떎�쓬李� �꽆�뼱媛�怨� �씠寃껊룄 �븞爰쇱쭚
				}
			}
		});

		idser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("ID李얘린 李쎌쑝濡� �씠�룞");
				FindMyID();
				conta.dispose();
			}
		});

		conta.setTitle("ID濡� PW 李얘린");
		conta.setSize(600, 400);
		conta.setVisible(true);
		conta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void pwserch() {
		JFrame conta = new JFrame();
		GridLayout glay = new GridLayout(2, 1);
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();

		JButton pnumser = new JButton("�쑕���룿 踰덊샇濡� 鍮꾨�踰덊샇 李얘린"); // 媛숈� �빖�뱶�룿踰덊샇 媛�吏� �젙蹂댁엳�뒗吏� �솗�씤 �썑 �엫�떆 鍮꾨�踰덊샇 留뚮뱾�뼱以�
		JButton emailser = new JButton("Email濡� 鍮꾨�踰덊샇 李얘린"); // 媛숈� �씠硫붿씪 媛�吏� �젙蹂댁엳�뒗吏� �솗�씤 �썑 �엫�떆 鍮꾨�踰덊샇 留뚮뱾�뼱以�

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

		conta.setTitle("PW 李얘린");
		conta.setSize(600, 400);
		conta.setVisible(true);
		conta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void pwserchP() {
		JFrame conta = new JFrame();
		BorderLayout blay = new BorderLayout();
		JPanel pan = new JPanel();

		JLabel plabel = new JLabel("�쑕���룿 踰덊샇 : ");
		JTextField pinput = new JTextField("踰덊샇瑜� �엯�젰�븯�꽭�슂 ('-' �젣�쇅)"); 
		JButton find = new JButton("李얘린");

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
				if (pinput.getText().equals("踰덊샇瑜� �엯�젰�븯�꽭�슂 ('-' �젣�쇅)")) {
					pinput.setText("");
					pinput.setForeground(Color.black);
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (pinput.getText().equals("")) {
					pinput.setForeground(Color.LIGHT_GRAY);
					pinput.setText("踰덊샇瑜� �엯�젰�븯�꽭�슂 ('-' �젣�쇅)");
				}
			}
		});

		find.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (pinput.getText().equals("") || pinput.getText().equals("踰덊샇瑜� �엯�젰�븯�꽭�슂 ('-' �젣�쇅)")) {
					JOptionPane.showMessageDialog(null, "���옣�맂 �쑕���룿 �젙蹂닿� �뾾�뒿�땲�떎.");
				} else {
				String findphone = pinput.getText();
				func.findpnum(findphone);
				//conta.dispose();
				}
			}
		});

		conta.setTitle("�쑕���룿 踰덊샇濡� PW 李얘린");
		conta.setSize(600, 400);
		conta.setVisible(true);
		conta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void pwserchE() {
		JFrame conta = new JFrame();
		BorderLayout blay = new BorderLayout();
		JPanel pan = new JPanel();

		JLabel elabel = new JLabel("Email 二쇱냼 : ");
		JTextField emainput = new JTextField("�씠硫붿씪 二쇱냼瑜� �엯�젰�븯�꽭�슂");
		JButton find = new JButton("李얘린");

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
				if (emainput.getText().equals("�씠硫붿씪 二쇱냼瑜� �엯�젰�븯�꽭�슂")) {
					emainput.setText("");
					emainput.setForeground(Color.black);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (emainput.getText().equals("")) {
					emainput.setForeground(Color.LIGHT_GRAY);
					emainput.setText("�씠硫붿씪 二쇱냼瑜� �엯�젰�븯�꽭�슂");
				}
			}
		});

		find.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (emainput.getText().equals("") || emainput.getText().equals("�씠硫붿씪 二쇱냼瑜� �엯�젰�븯�꽭�슂")) {
					JOptionPane.showMessageDialog(null, "���옣�맂 Email 二쇱냼媛� �뾾�뒿�땲�떎.");
				} else {
				String findema = emainput.getText();
				func.findemail(findema);
				//conta.dispose();
				}
			}
		});

		conta.setTitle("Email濡� PW 李얘린");
		conta.setSize(800, 400);
		conta.setVisible(true);
		conta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void pwTemporal(String tempw) {
		JFrame conta = new JFrame();
		GridLayout glay = new GridLayout(2, 1);
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();

		JLabel pwshow1 = new JLabel("�쉶�썝�떂�쓽 鍮꾨�踰덊샇�뒗  ");
		JLabel pwshow2 = new JLabel(" �엯�땲�떎.");
		JLabel pwtem = new JLabel(tempw);
		JLabel txtshow = new JLabel("濡쒓렇�씤 �썑 My page�뿉�꽌 鍮꾨�踰덊샇瑜� �닔�젙�븯�꽭�슂.");
		JButton login = new JButton("濡쒓렇�씤");

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

		conta.setTitle("PW 李얘린 �꽦怨�");
		conta.setSize(600, 400);
		conta.setVisible(true);
		conta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------
	Func func = new Func();
	
	void regiMain() { // �쉶�썝媛��엯 �솕硫�

		// ID(duplication check btn),PW,PW_check,name,dob(checkbox/lune click
		// btn),sex(checkbox),email,phonenum;

		// id panel
		label_id.setFont(new Font("HYGothic", Font.BOLD, 15));
		btn1.setFont(new Font("HYGothic", 10, 10));
		txt_id.setForeground(Color.LIGHT_GRAY);

		txt_id.addFocusListener(new FocusListener() {

			@Override // 而ㅼ꽌 �늻瑜대㈃ 湲��뵪 寃��젙�쑝濡�
			public void focusGained(FocusEvent arg0) {
				if (txt_id.getText().equals("ID瑜� �엯�젰�븯�꽭�슂")) {
					txt_id.setText("");
					txt_id.setForeground(Color.BLACK);
					String id = txt_id.getText().trim();
				}
			}

			@Override // 而ㅼ꽌 �븞�늻瑜대㈃ id瑜� �엯�젰�븯�꽭�슂 txt
			public void focusLost(FocusEvent e) {
				if (txt_id.getText().equals("")) {
					txt_id.setForeground(Color.LIGHT_GRAY);
					txt_id.setText("ID瑜� �엯�젰�븯�꽭�슂");
				}

			}

		});

		// pw panel

		label_pw.setFont(new Font("HYGothic", Font.BOLD, 15));
		label_pw2.setFont(new Font("HYGothic", Font.BOLD, 15));
		txt_pw.setForeground(Color.LIGHT_GRAY);
		txt_pw2.setForeground(Color.LIGHT_GRAY);
		
		// pw �꽔�쑝硫� �깋蹂�寃�
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
					JOptionPane.showMessageDialog(null, "鍮꾨�踰덊샇 遺덉씪移�");
				}
			}
		});
		//pw2(鍮꾨쾲�솗�씤)�엯�젰 �떆 pw�� �룞�씪�븳吏� �솗�씤
		

		// nm panel
		label_nm.setFont(new Font("HYGothic", Font.BOLD, 15));

		// dob panel
		label_b1.setFont(new Font("HYGothic", Font.BOLD, 15));
		label_b2.setFont(new Font("HYGothic", 15, 15));
		//媛뺤궗�떂猿� �젣異쒗븯怨� �궡媛� �닔�젙�븿, 媛��엯踰꾪듉 �겢由� �떆 利앹떇 �삤瑜� �빐寃�
	//	String[] m = { "Month", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
	//	JComboBox<String> mm = new JComboBox<String>(m); // combobox-
		label_b3.setFont(new Font("HYGothic", 15, 15));

		// gender panel - use radio button
		
		grp.add(btnG1);
		grp.add(btnG2);

		// email panel
		label_m.setFont(new Font("HYGothic", Font.BOLD, 15));
		label_m.setFont(new Font("HYGothic", 15, 15));
		//媛뺤궗�떂猿� �젣異쒗븯怨� �궡媛� �닔�젙�븿, 媛��엯踰꾪듉 �겢由� �떆 利앹떇 �삤瑜� �빐寃�
	//	String[] em = { "�꽑�깮�븯�꽭�슂", "gmail.com", "naver.com", "kakao.com" };
	//	JComboBox<String> mail = new JComboBox<String>(em);

		btn2.setFont(new Font("HYGothic", 10, 10));

		// pnum panel
		label_p.setFont(new Font("HYGothic", Font.BOLD, 15));
		
		//以묐났�솗�씤
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("�솗�씤");
				func.checkID(txt_id.getText());
			}
		});

		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("�솗�씤");
				func.checkMail(txt_m.getText());
				
			}
		});

		// regi 踰꾪듉 �븸�뀡
		regifin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("媛��엯");

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
				// DB�슜�겢�옒�뒪 �븯�굹 �뜑 留뚮뱾�뼱�꽌save
				func.save();

				// 媛��엯�셿猷� 硫붿꽭吏� 李�
				JOptionPane.showMessageDialog(null, "�쉶�썝媛��엯�씠 �셿猷뚮릺�뿀�뒿�땲�떎.");
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

		setTitle("�쉶�썝媛��엯");
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