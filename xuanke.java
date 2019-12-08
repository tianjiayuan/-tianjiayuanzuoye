//学生登陆界面
package pp;
import javax.swing.*;  
  
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
  
public class Login extends JFrame implements ActionListener {  
  
    //定义组件  
    JButton jb1,jb2=null;  
    JRadioButton jrb1,jrb2=null;  
    JPanel jp1,jp2,jp3,jp4=null;  
    JTextField jtf=null;  
    JLabel jlb1,jlb2,jlb3=null;  
    JPasswordField jpf=null;  
    ButtonGroup bg=null;  
          
    //设定用户名和密码  
    final String stu_name="6";  
    final String stu_pwd="1";  
    final String tea_name="5";  
    final String tea_pwd="1";  
      
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        Login  ms=new Login();  
    }  
    public Login()  
    {  
         //创建组件  
        jb1=new JButton("登录");  
        jb2=new JButton("重置");  
        //设置监听  
        jb1.addActionListener(this);  
        jb2.addActionListener(this);  
          
        jrb1=new JRadioButton("教师");  
        jrb2=new JRadioButton("学生");  
        bg=new ButtonGroup();  
        bg.add(jrb1);  
        bg.add(jrb2);  
        jrb2.setSelected(true);  
          
        jp1=new JPanel();  
        jp2=new JPanel();  
        jp3=new JPanel();  
        jp4=new JPanel();                 
          
        jlb1=new JLabel("用户名：");  
        jlb2=new JLabel("密    码：");  
        jlb3=new JLabel("权    限：");  
          
        jtf=new JTextField(10);  
        jpf=new JPasswordField(10);  
        //加入到JPanel中  
        jp1.add(jlb1);  
        jp1.add(jtf);  
          
        jp2.add(jlb2);  
        jp2.add(jpf);  
          
        jp3.add(jlb3);  
        jp3.add(jrb1);  
        jp3.add(jrb2);  
          
        jp4.add(jb1);  
        jp4.add(jb2);  
          
        //加入JFrame中  
        this.add(jp1);  
        this.add(jp2);  
        this.add(jp3);  
        this.add(jp4);  
        //设置布局管理器  
        this.setLayout(new GridLayout(4,1));  
        //给窗口设置标题  
        this.setTitle("学生成绩管理系统");  
        //设置窗体大小  
        this.setSize(300,200);  
        //设置窗体初始位置  
        this.setLocation(200, 150);  
        //设置当关闭窗口时，保证JVM也退出  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        //显示窗体  
        this.setVisible(true);  
        this.setResizable(true);  
          
    }  
    @Override  
    public void actionPerformed(ActionEvent e) {  
          
        if(e.getActionCommand()=="登录")  
        {  
            //如果选中教师登录  
            if(jrb1.isSelected())  
            {  
                  tealogin();  
            }else if(jrb2.isSelected()) //学生在登录系统  
            {  
                  stulogin();  
            }  
              
        }else if(e.getActionCommand()=="重置")  
        {  
                  clear();  
        }             
          
    }  
      
     //学生登录判断方法  
    public void stulogin()  
    {  
        if(stu_name.equals(jtf.getText())&&stu_pwd.equals(jpf.getText()))  
        {  
//          System.out.println("登录成功");  
            JOptionPane.showMessageDialog(null,"登录成功！","提示消息",JOptionPane.WARNING_MESSAGE);  
            clear();  
        }else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())  
        {  
            JOptionPane.showMessageDialog(null,"请输入用户名和密码！","提示消息",JOptionPane.WARNING_MESSAGE);  
        }else if(jtf.getText().isEmpty())  
        {  
            JOptionPane.showMessageDialog(null,"请输入用户名！","提示消息",JOptionPane.WARNING_MESSAGE);  
        }else if(jpf.getText().isEmpty())  
        {  
            JOptionPane.showMessageDialog(null,"请输入密码！","提示消息",JOptionPane.WARNING_MESSAGE);  
        }else  
        {  
            JOptionPane.showMessageDialog(null,"用户名或者密码错误！\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);  
            //清空输入框  
            clear();  
        }  
    }  
    //教师登录判断方法  
    public void tealogin()  
    {  
        if(tea_name.equals(jtf.getText())&&tea_pwd.equals(jpf.getText()))  
        {  
//          System.out.println("登录成功");  
             JOptionPane.showMessageDialog(null,"登录成功！","提示消息",JOptionPane.WARNING_MESSAGE);  
             clear();  
        }else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())  
        {  
            JOptionPane.showMessageDialog(null,"请输入用户名和密码！","提示消息",JOptionPane.WARNING_MESSAGE);  
        }else if(jtf.getText().isEmpty())  
        {  
            JOptionPane.showMessageDialog(null,"请输入用户名！","提示消息",JOptionPane.WARNING_MESSAGE);  
        }else if(jpf.getText().isEmpty())  
        {  
            JOptionPane.showMessageDialog(null,"请输入密码！","提示消息",JOptionPane.WARNING_MESSAGE);  
        }else  
        {  
            JOptionPane.showMessageDialog(null,"用户名或者密码错误！\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);  
            //清空输入框  
            clear();  
        }  
    }  
    //清空文本框和密码框  
    public  void clear()  
    {  
        jtf.setText("");  
        jpf.setText("");  
    }  
          
}  
//登录成功后进行选课
/*
 * CourseViewInterFrm.java
 *
 * Created on __DATE__, __TIME__
 */
/**
 * @author www.hiai.top
 */
package top.hiai.view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import top.hiai.dao.CourseDao;
import top.hiai.model.Course;
import top.hiai.util.DbUtil;

/**
 *
 * @author  __USER__
 */
public class CourseViewInterFrm extends javax.swing.JInternalFrame {
	DbUtil dbUtil = new DbUtil();
	CourseDao courseDao = new CourseDao();

	/** Creates new form CourseViewInterFrm */
	public CourseViewInterFrm() {
		initComponents();
		this.setLocation(200, 50);
		this.fillTable(new Course());
	}

	private void fillTable(Course course) {
		DefaultTableModel dtm = (DefaultTableModel) courseTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = courseDao.courseList(con, course);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("courseId"));
				v.add(rs.getString("courseName"));
				v.add(rs.getString("courseTime"));
				v.add(rs.getString("courseTeacher"));
				v.add(rs.getString("capacity"));
				v.add(rs.getString("numSelected"));
				dtm.addRow(v);

			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
//GEN-BEGIN:initComponents
// <editor-fold defaultstate="collapsed" desc="Generated Code">
private void initComponents() {

jScrollPane1 = new javax.swing.JScrollPane();
courseTable = new javax.swing.JTable();

setClosable(true);
setIconifiable(true);
setTitle("\u8bfe\u7a0b\u67e5\u770b");

courseTable.setModel(new javax.swing.table.DefaultTableModel(
	new Object [][] {
		
	},
	new String [] {
		"课程编号", "课程名称", "上课时间", "任课老师", "课程容量", "已选人数"
	}
) {
	boolean[] canEdit = new boolean [] {
		false, false, false, false, false, false
	};

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return canEdit [columnIndex];
	}
});
jScrollPane1.setViewportView(courseTable);

javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
getContentPane().setLayout(layout);
layout.setHorizontalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addContainerGap()
.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
.addContainerGap())
);
layout.setVerticalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addContainerGap()
.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
.addContainerGap())
);

pack();
}// </editor-fold>
//GEN-END:initComponents

//GEN-BEGIN:variables
// Variables declaration - do not modify
private javax.swing.JTable courseTable;
private javax.swing.JScrollPane jScrollPane1;
// End of variables declaration//GEN-END:variables

}
//查看已选课程并退课
/*
 * SelectedViewInterFrm.java
 *
 * Created on __DATE__, __TIME__
 */
/**
 * @author www.hiai.top
 */
package top.hiai.view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import top.hiai.dao.SelectionDao;
import top.hiai.model.Course;
import top.hiai.model.Selection;
import top.hiai.util.DbUtil;

/**
 *
 * @author  __USER__
 */
public class SelectedViewInterFrm extends javax.swing.JInternalFrame {
	DbUtil dbUtil = new DbUtil();
	SelectionDao selectionDao = new SelectionDao();
	private int courseId=-1;

	/** Creates new form SelectedViewInterFrm */
	public SelectedViewInterFrm() {
		initComponents();
		this.setLocation(200, 50);
		this.fillTable(new Course());
	}

	private void fillTable(Course course) {
		DefaultTableModel dtm = (DefaultTableModel) courseTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		int currentSno = LogOnFrm.currentStudent.getSno();
		try {
			con = dbUtil.getCon();
			ResultSet rs = selectionDao.SelectedList(con, currentSno);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("courseId"));
				v.add(rs.getString("courseName"));
				v.add(rs.getString("courseTime"));
				v.add(rs.getString("courseTeacher"));
				dtm.addRow(v);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		courseTable = new javax.swing.JTable();
		jb_selectionCancel = new javax.swing.JButton();

		setClosable(true);
		setIconifiable(true);
		setTitle("\u5df2\u9009\u8bfe\u7a0b\u67e5\u770b");

		courseTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "课程编号", "课程名称", "上课时间", "任课老师" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		courseTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				courseTableMousePressed(evt);
			}
		});
		jScrollPane1.setViewportView(courseTable);

		jb_selectionCancel.setText("\u9000\u9009");
		jb_selectionCancel
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						jb_selectionCancelActionPerformed(evt);
					}
				});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				jScrollPane1,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				602,
																				Short.MAX_VALUE))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(
																				272,
																				272,
																				272)
																		.addComponent(
																				jb_selectionCancel)))
										.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addContainerGap().addComponent(
						jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,
						205, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18,
						18, 18).addComponent(jb_selectionCancel)
						.addContainerGap(14, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void courseTableMousePressed(java.awt.event.MouseEvent evt) {
		int row = courseTable.getSelectedRow();
		courseId = Integer.parseInt((String) courseTable.getValueAt(row, 0));
	}

	private void jb_selectionCancelActionPerformed(
			
			java.awt.event.ActionEvent evt) {
		if (courseId==-1) {
			JOptionPane.showMessageDialog(this, "请选择一门课程！");
			return;
		}
		int n = JOptionPane.showConfirmDialog(this, "确定要退选该门课程吗?");
		if (n == 0) {
			Connection con = null;
			int currentSno = LogOnFrm.currentStudent.getSno();
			Selection selection = new Selection(courseId, currentSno);
			try {
				con = dbUtil.getCon();
				int selectionNum = selectionDao.SelectionCancel(con, selection);
				int selectedNum = selectionDao.NumSelectedMinus(con, courseId);
				if (selectionNum == 1 && selectedNum == 1) {
					JOptionPane.showMessageDialog(this, "退选成功!");
					this.fillTable(new Course());
				} else {
					JOptionPane.showMessageDialog(this, "退选失败!");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(this, "退选失败!");
			} finally {
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JTable courseTable;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JButton jb_selectionCancel;
	// End of variables declaration//GEN-END:variables

}
//退出系统
package top.hiai.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * @author www.hiai.top
 */
/**
 *
 * @author  __USER__
 */
public class MainFrm_student extends javax.swing.JFrame {

	/** Creates new form MainFrm */
	public MainFrm_student() {
		initComponents();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		table = new javax.swing.JDesktopPane();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenu3 = new javax.swing.JMenu();
		jmiSelectCourse = new javax.swing.JMenuItem();
		jmiSelectedView = new javax.swing.JMenuItem();
		jMenu4 = new javax.swing.JMenu();
		jmiPasswordModify = new javax.swing.JMenuItem();
		jmiSelfInfo = new javax.swing.JMenuItem();
		jmiExit = new javax.swing.JMenuItem();
		jMenu2 = new javax.swing.JMenu();
		jMenuItem6 = new javax.swing.JMenuItem();
		jMenuItem7 = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("\u5b66\u751f\u9009\u8bfe\u7cfb\u7edf\u4e3b\u754c\u9762_\u5b66\u751f\u7aef");

		jMenu1
				.setIcon(new javax.swing.ImageIcon(
						"D:\\Workspaces\\MyEclipse 8.5\\CourseSys\\src\\com\\jakey\\view\\image\\base.png")); // NOI18N
		jMenu1.setText("\u57fa\u672c\u64cd\u4f5c");

		jMenu3
				.setIcon(new javax.swing.ImageIcon(
						"D:\\Workspaces\\MyEclipse 8.5\\CourseSys\\src\\com\\jakey\\view\\image\\course.png")); // NOI18N
		jMenu3.setText("\u9009\u8bfe");

		jmiSelectCourse
				.setIcon(new javax.swing.ImageIcon(
						"D:\\Workspaces\\MyEclipse 8.5\\CourseSys\\src\\com\\jakey\\view\\image\\course.png")); // NOI18N
		jmiSelectCourse.setText("\u9009\u62e9\u672a\u9009\u8bfe\u7a0b");
		jmiSelectCourse.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jmiSelectCourseActionPerformed(evt);
			}
		});
		jMenu3.add(jmiSelectCourse);

		jmiSelectedView
				.setIcon(new javax.swing.ImageIcon(
						"D:\\Workspaces\\MyEclipse 8.5\\CourseSys\\src\\com\\jakey\\view\\image\\course.png")); // NOI18N
		jmiSelectedView.setText("\u67e5\u770b\u5df2\u9009\u8bfe\u7a0b");
		jmiSelectedView.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jmiSelectedViewActionPerformed(evt);
			}
		});
		jMenu3.add(jmiSelectedView);

		jMenu1.add(jMenu3);

		jMenu4
				.setIcon(new javax.swing.ImageIcon(
						"D:\\Workspaces\\MyEclipse 8.5\\CourseSys\\src\\com\\jakey\\view\\image\\userName.png")); // NOI18N
		jMenu4.setText("\u4e2a\u4eba\u4fe1\u606f");

		jmiPasswordModify
				.setIcon(new javax.swing.ImageIcon(
						"D:\\Workspaces\\MyEclipse 8.5\\CourseSys\\src\\com\\jakey\\view\\image\\password.png")); // NOI18N
		jmiPasswordModify.setText("\u4fee\u6539\u5bc6\u7801");
		jmiPasswordModify
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						jmiPasswordModifyActionPerformed(evt);
					}
				});
		jMenu4.add(jmiPasswordModify);

		jmiSelfInfo
				.setIcon(new javax.swing.ImageIcon(
						"D:\\Workspaces\\MyEclipse 8.5\\CourseSys\\src\\com\\jakey\\view\\image\\student.png")); // NOI18N
		jmiSelfInfo.setText("\u5b66\u7c4d\u4fe1\u606f");
		jmiSelfInfo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jmiSelfInfoActionPerformed(evt);
			}
		});
		jMenu4.add(jmiSelfInfo);

		jMenu1.add(jMenu4);

		jmiExit
				.setIcon(new javax.swing.ImageIcon(
						"D:\\Workspaces\\MyEclipse 8.5\\CourseSys\\src\\com\\jakey\\view\\image\\exit.png")); // NOI18N
		jmiExit.setText("\u9000\u51fa\u7cfb\u7edf");
		jmiExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jmiExitActionPerformed(evt);
			}
		});
		jMenu1.add(jmiExit);

		jMenuBar1.add(jMenu1);

		jMenu2
				.setIcon(new javax.swing.ImageIcon(
						"D:\\Workspaces\\MyEclipse 8.5\\CourseSys\\src\\com\\jakey\\view\\image\\help.png")); // NOI18N
		jMenu2.setText("\u5e2e\u52a9");

		jMenuItem6
				.setIcon(new javax.swing.ImageIcon(
						"D:\\Workspaces\\MyEclipse 8.5\\CourseSys\\src\\com\\jakey\\view\\image\\help.png")); // NOI18N
		jMenuItem6.setText("\u64cd\u4f5c\u6307\u5357");
		jMenu2.add(jMenuItem6);

		jMenuItem7
				.setIcon(new javax.swing.ImageIcon(
						"D:\\Workspaces\\MyEclipse 8.5\\CourseSys\\src\\com\\jakey\\view\\image\\phone.png")); // NOI18N
		jMenuItem7.setText("\u8054\u7cfb\u7ba1\u7406\u5458");
		jMenu2.add(jMenuItem7);

		jMenuBar1.add(jMenu2);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(table,
				javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(table,
				javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jmiSelfInfoActionPerformed(java.awt.event.ActionEvent evt) {
		SelfInfoInterFrm selfInfoInterFrm = new SelfInfoInterFrm();
		selfInfoInterFrm.setVisible(true);
		this.table.add(selfInfoInterFrm);
	}

	private void jmiPasswordModifyActionPerformed(java.awt.event.ActionEvent evt) {
		PasswordModifyInterFrm passwordModifyInterFrm = new PasswordModifyInterFrm();
		passwordModifyInterFrm.setVisible(true);
		this.table.add(passwordModifyInterFrm);
	}

	private void jmiSelectedViewActionPerformed(java.awt.event.ActionEvent evt) {
		SelectedViewInterFrm selectedViewInterFrm = new SelectedViewInterFrm();
		selectedViewInterFrm.setVisible(true);
		this.table.add(selectedViewInterFrm);
	}

	private void jmiSelectCourseActionPerformed(java.awt.event.ActionEvent evt) {
		SelectCourseInterFrm selectCourseInterFrm = new SelectCourseInterFrm();
		selectCourseInterFrm.setVisible(true);
		this.table.add(selectCourseInterFrm);
	}

	private void jmiExitActionPerformed(java.awt.event.ActionEvent evt) {
		int result = JOptionPane.showConfirmDialog(this, "是否退出系统?");
		if (result == 0) {
			this.dispose();
		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainFrm_student().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenu jMenu4;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem6;
	private javax.swing.JMenuItem jMenuItem7;
	private javax.swing.JMenuItem jmiExit;
	private javax.swing.JMenuItem jmiPasswordModify;
	private javax.swing.JMenuItem jmiSelectCourse;
	private javax.swing.JMenuItem jmiSelectedView;
	private javax.swing.JMenuItem jmiSelfInfo;
	private javax.swing.JDesktopPane table;
	// End of variables declaration//GEN-END:variables

}
