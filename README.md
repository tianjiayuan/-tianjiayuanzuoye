
                                        字符串实验

1.实验目的：
   分析学生选课系统，并用GUI实现窗体界面，应用文件保存读取数据，处理相应的异常。

2.要求：  
    为学生创建属性方法，以及角色分配和相应的功能实现。
    
3.过程：
   首先用GUI创建一个可登陆的登录界面，在入口分为学生和管理员，选择不同的身份进入不同的功能页面，拿学生为例，此时我们把学生名单放在数据库中，不同学生登录对应相应的学号密码即可，成功登陆后进入到可选课程页面，选择完毕后，进入到已选页面，对其课程可以进行退课操作，选课完成后退出系统。
4.核心代码
           
	courseTable.setModel(new javax.swing.table.DefaultTableModel(
	new Object [][] {
		
	},
	new String [] {
		"课程编号", "课程名称", "上课时间", "任课老师", "课程容量", "已选人数"
	}
) 
       
       {boolean[] canEdit = new boolean [] {
		false, false, false, false, false, false
	};

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return canEdit [columnIndex];
	}
      });jScrollPane1.setViewportView(courseTable);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup()}
    
    //退课系统
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
    //退出系统
    private void jmiExitActionPerformed(java.awt.event.ActionEvent evt) {
		int result = JOptionPane.showConfirmDialog(this, "是否退出系统");
		if (result == 0) {
			this.dispose();
		}
	}
5.编程感想：
  本次设计做的是Java的学生选课系统的设计与实现，在软件开发设计过程中，让我对Java有了进一步的了解，极大提高了编程能力。在设计中我深知自己掌握的知识远远不够，掌握的一些理论知识应用到实践中去，总会出现这样或那样的问题，日后我要把学到的知识应用到实际中，多做多练。
