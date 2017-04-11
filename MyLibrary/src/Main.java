import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class Main {
	 static Connection myConn = null;
	 static Statement myState = null;
	 static Statement myState2 = null;
	 static Statement myState3 = null;
	 static JFrame MyFrm=new JFrame("Library");
	 
	 static JFrame CreateFrm=new JFrame("Create New Borrower");
	 
	 static DefaultListModel MyModel=new DefaultListModel();
	 static JList MyList=new JList();
	 static JScrollPane scrlpane=new JScrollPane(MyList);
	 
	 static String[] ColName={"Isbn","Title","Authors"};
	 static DefaultTableModel MyDTM=new DefaultTableModel(null,ColName);
	 static JTable MyTable=new JTable();
	 static JScrollPane MyJSP=new JScrollPane(MyTable);
	 
	 static String[] CopyColName={"Isbn","Library","No_of_copies","availabe"};
	 static DefaultTableModel CopyDTM=new DefaultTableModel(null,CopyColName);
	 static JTable CopyTable=new JTable();
	 static JScrollPane CopyJSP=new JScrollPane(CopyTable);
	 
	 static String[] LoanColName={"Loan_id","Name","Card_no","Book_id"};
	 static DefaultTableModel LoanDTM=new DefaultTableModel(null,LoanColName);
	 static JTable LoanTable=new JTable();
	 static JScrollPane LoanJSP=new JScrollPane(LoanTable);
	 
	 static String[] FineColName={"Card_no","Amt","Paid"};
	 static DefaultTableModel FineDTM=new DefaultTableModel(null,FineColName);
	 static JTable FineTable=new JTable();
	 static JScrollPane FineJSP=new JScrollPane(FineTable);
	 
	 static String book_idStr="";
     static String branch_idStr="";
     static String no_of_copyStr="";
     static String no_of_available="";
     
     static String loan_id_Str="";
     
     static String card_no_Str="";
     /**
      * @param args
     * @throws SQLException 
     * @throws ClassNotFoundException 
      */
/**************************************  Main *****************************************/
     public static void main(String[] args) throws SQLException  {
		//ExampleSql();
    	 connectSQL();
    	 
    	 createInterface();
    	 
     }
     
/**************************************  Interface *****************************************/
     
     public static void createInterface(){
    	/********************Frame****************/
         
    	MyFrm.setSize(1350,650);
    	MyFrm.setLocation(0,0);
    	//MyFrm.setResizable(false);
    	MyFrm.setVisible(true);
    	
    	//MyFrm.setLayout(new BorderLayout());
    	//MyFrm.setLayout(new FlowLayout());
       //MyFrm.pack();
    	
    	
  	   
  	  /********************TextField****************/

       final JTextField isbnTxt=new JTextField();
       isbnTxt.setVisible(true);
       MyFrm.add(isbnTxt);
       isbnTxt.setSize(180, 30);
       isbnTxt.setLocation(60, 5);
       
       JTextField label1=new JTextField("Isbn");
       MyFrm.add(label1);
       label1.setEditable(false);
       label1.setBorder(null);
       label1.setSize(180, 30);
       label1.setLocation(20, 5);
       
       final JTextField titleTxt=new JTextField();
       titleTxt.setVisible(true);
       MyFrm.add(titleTxt);
       titleTxt.setSize(570, 30);
       titleTxt.setLocation(310, 5);
       
       JTextField label2=new JTextField("Title");
       MyFrm.add(label2);
       label2.setEditable(false);
       label2.setBorder(null);
       label2.setSize(180, 30);
       label2.setLocation(265, 5);
       
       final JTextField auTxt1=new JTextField();
       auTxt1.setVisible(true);
       MyFrm.add(auTxt1);
       auTxt1.setSize(180, 30);
       auTxt1.setLocation(60, 40);
       
       JTextField label3=new JTextField("Author1");
       MyFrm.add(label3);
       label3.setEditable(false);
       label3.setBorder(null);
       label3.setSize(180, 30);
       label3.setLocation(10, 40);
       
       final JTextField auTxt2=new JTextField();
       auTxt2.setVisible(true);
       MyFrm.add(auTxt2);
       auTxt2.setSize(180, 30);
       auTxt2.setLocation(310, 40);
       
       JTextField label4=new JTextField("Author2");
       MyFrm.add(label4);
       label4.setEditable(false);
       label4.setBorder(null);
       label4.setSize(180, 30);
       label4.setLocation(260, 40);
       
       final JTextField auTxt3=new JTextField();
       auTxt3.setVisible(true);
       MyFrm.add(auTxt3);
       auTxt3.setSize(180, 30);
       auTxt3.setLocation(560, 40);
       
       JTextField label5=new JTextField("Author3");
       MyFrm.add(label5);
       label5.setEditable(false);
       label5.setBorder(null);
       label5.setSize(180, 30);
       label5.setLocation(510, 40);
       
       JTextField label6=new JTextField("card_no");
       MyFrm.add(label6);
       label6.setEditable(false);
       label6.setBorder(null);
       label6.setSize(70, 30);
       label6.setLocation(820, 200);
       
       final JTextField cardNoTxt=new JTextField();
       MyFrm.add(cardNoTxt);
       cardNoTxt.setSize(170, 30);
       cardNoTxt.setLocation(890, 200);
       
       JTextField label7=new JTextField("brw_name");
       MyFrm.add(label7);
       label7.setEditable(false);
       label7.setBorder(null);
       label7.setSize(70, 30);
       label7.setLocation(820, 240);
       
       final JTextField brwNameTxt=new JTextField();
       MyFrm.add(brwNameTxt);
       brwNameTxt.setSize(170, 30);
       brwNameTxt.setLocation(890, 240);
       
       JTextField label8=new JTextField("book_id");
       MyFrm.add(label8);
       label8.setEditable(false);
       label8.setBorder(null);
       label8.setSize(70, 30);
       label8.setLocation(820, 280);
       

       final JTextField bookIdTxt=new JTextField();
       MyFrm.add(bookIdTxt);
       bookIdTxt.setSize(170, 30);
       bookIdTxt.setLocation(890, 280);
       
       JTextField label9=new JTextField("SSN");
       MyFrm.add(label9);
       label9.setEditable(false);
       label9.setBorder(null);
       label9.setSize(40, 30);
       label9.setLocation(10, 550);
       

       final JTextField ssnTxt=new JTextField();
       MyFrm.add(ssnTxt);
       ssnTxt.setSize(130, 30);
       ssnTxt.setLocation(50, 550);
       
       JTextField label10=new JTextField("FName");
       MyFrm.add(label10);
       label10.setEditable(false);
       label10.setBorder(null);
       label10.setSize(40, 30);
       label10.setLocation(200, 550);
       

       final JTextField fnameTxt=new JTextField();
       MyFrm.add(fnameTxt);
       fnameTxt.setSize(130, 30);
       fnameTxt.setLocation(250, 550);
       
       JTextField label11=new JTextField("LName");
       MyFrm.add(label11);
       label11.setEditable(false);
       label11.setBorder(null);
       label11.setSize(40, 30);
       label11.setLocation(400, 550);
       

       final JTextField lnameTxt=new JTextField();
       MyFrm.add(lnameTxt);
       lnameTxt.setSize(130, 30);
       lnameTxt.setLocation(450, 550);
       
       JTextField label12=new JTextField("Address");
       MyFrm.add(label12);
       label12.setEditable(false);
       label12.setBorder(null);
       label12.setSize(40, 30);
       label12.setLocation(600, 550);
       

       final JTextField addrTxt=new JTextField();
       MyFrm.add(addrTxt);
       addrTxt.setSize(130, 30);
       addrTxt.setLocation(650, 550);
       
       JTextField label13=new JTextField("phone");
       MyFrm.add(label13);
       label13.setEditable(false);
       label13.setBorder(null);
       label13.setSize(40, 30);
       label13.setLocation(810, 550);
       

       final JTextField phoneTxt=new JTextField();
       MyFrm.add(phoneTxt);
       phoneTxt.setSize(130, 30);
       phoneTxt.setLocation(850, 550);
       
       final JTextField msgTxt=new JTextField();
       MyFrm.add(msgTxt);
       msgTxt.setSize(420, 65);
       msgTxt.setLocation(900, 5);
       msgTxt.setBorder(null);
       msgTxt.setBackground(new Color(1.0f,1.0f,0.0f));
       
       /********************Button****************/
       
       ////////////////////////////Search//////////////////////////////
       JButton SearchButton = new JButton("Search");
                 
       MyFrm.add(SearchButton);
       SearchButton.setSize(120, 30);
       SearchButton.setLocation(760,40);
       
  	   ActionListener searchBookEvent = new ActionListener() {

  		public void actionPerformed(ActionEvent arg0) {
  			//System.out.println("welcome");
  			
  			String isbn=isbnTxt.getText();
  			if(isbn.trim().equals(""))isbn="";
  			String title=titleTxt.getText();
  			if(title.trim().equals(""))title="";
  			String au1=auTxt1.getText();
  			if(au1.trim().equals(""))au1="";
  			String au2=auTxt2.getText();
  			if(au2.trim().equals(""))au2="";
  			String au3=auTxt3.getText();
  			if(au3.trim().equals(""))au3="";
  			try {
  				msgTxt.setText(searchBook(isbn,title,au1,au2,au3));
				//searchBook(isbn,title,au1,au2,au3);
			} catch (SQLException e) {
				e.printStackTrace();
			}
  			} 
       };
       SearchButton.addActionListener(searchBookEvent); 
       
       
       ////////////////////////////////check out////////////////////////////
       JButton CheckOutButton = new JButton("Check Out");
       
       MyFrm.add(CheckOutButton);
       CheckOutButton.setSize(100,30);
       CheckOutButton.setLocation(1070,200);
       
       ActionListener checkOutEvent = new ActionListener() {

     		public void actionPerformed(ActionEvent arg0) {
     		 
            
      			
      			try {;
   				//checkout("","","");
   				//String isbn,String branch_id,String card_no
   				String cardNoStr=cardNoTxt.getText();
   				if(cardNoStr.trim().equals(""))cardNoStr="";
   				
   				msgTxt.setText(checkout(book_idStr,branch_idStr,cardNoStr));
   			} catch (SQLException e) {
   		        System.out.println(e.getErrorCode());
   		        //integrity constraints 1062
   				
   			}
     		  
     		}
          };
       CheckOutButton.addActionListener(checkOutEvent);
          
          
       //////////////////////////////get loan/////////////////////////////
       JButton SearchLoanButton = new JButton("Get Loans");
       
       MyFrm.add(SearchLoanButton);
       SearchLoanButton.setSize(100,30);
       SearchLoanButton.setLocation(1070,240);
       
       ActionListener getLoanEvent = new ActionListener() {

     		public void actionPerformed(ActionEvent arg0) {
     		 
     			String bookid=bookIdTxt.getText();
      			if(bookid.trim().equals(""))bookid="";
      			String cardno=cardNoTxt.getText();
      			if(cardno.trim().equals(""))cardno="";
      			String name=brwNameTxt.getText();
      			if(name.trim().equals(""))name="";
     		  
     		  try {
				msgTxt.setText(getLoan(bookid,cardno,name));
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
     		}
          };
       SearchLoanButton.addActionListener(getLoanEvent);
       
       
       ////////////////////////////////check In////////////////////////////
       
       JButton CheckInButton = new JButton("Check In");
       
       MyFrm.add(CheckInButton);
       CheckInButton.setSize(100,30);
       CheckInButton.setLocation(1070,280);
       
       ActionListener checkInEvent = new ActionListener() {

    		public void actionPerformed(ActionEvent arg0) {
    			try {
					
					msgTxt.setText(checkIn(loan_id_Str));
				} catch (SQLException e) {
					e.printStackTrace();
				}
    		  
    		}
         };
       CheckInButton.addActionListener(checkInEvent);
       ////////////////////Create New//////////////////
       
       
       JButton createButton = new JButton("Create New");
       
       MyFrm.add(createButton);
       createButton.setSize(150,30);
       createButton.setLocation(1010,550);
       
       ActionListener createEvent = new ActionListener() {

    		public void actionPerformed(ActionEvent arg0) {
    			String ssn=ssnTxt.getText();
      			if(ssn.trim().equals(""))ssn="";
      			String addr=addrTxt.getText();
      			if(addr.trim().equals(""))addr="";
      			String fname=fnameTxt.getText();
      			if(fname.trim().equals(""))fname="";
      			String lname=lnameTxt.getText();
      			if(lname.trim().equals(""))lname="";
      			String phone=phoneTxt.getText();
      			if(phone.trim().equals(""))phone="";
    			
      			try {
      				msgTxt.setText(CreateNew(ssn,fname,lname,addr,phone));
				} catch (SQLException e) {
					e.printStackTrace();
				}
    		}
         };
       createButton.addActionListener(createEvent);
       /////////////////////update////////////////////////
       JButton updateButton = new JButton("UpdateFines");
       
       MyFrm.add(updateButton);
       updateButton.setSize(120,20);
       updateButton.setLocation(1200,535);
       
       ActionListener updateEvent = new ActionListener() {

    		public void actionPerformed(ActionEvent arg0) {
    			try {
					//insertFines();
    				msgTxt.setText(UpdateFines());
				} catch (SQLException e) {
					e.printStackTrace();
				}
    			
    		}
         };
       updateButton.addActionListener(updateEvent);
       /////////////////////paid///////////////////////////
       JButton payButton = new JButton("payFines");
       
       MyFrm.add(payButton);
       payButton.setSize(120,20);
       payButton.setLocation(1200,560);
       
       ActionListener payEvent = new ActionListener() {

    		public void actionPerformed(ActionEvent arg0) {
    			
    			
    			try {
					msgTxt.setText(SetPaid(card_no_Str));
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
    		}
         };
       payButton.addActionListener(payEvent);
  	  
         
       /********************List****************/
       
       /*MyFrm.add(scrlpane);
       MyList.setModel(MyModel);
       scrlpane.setSize(400, 200);
       scrlpane.setLocation(600,200);*/
       
       /********************Table****************/
       MyFrm.add(MyJSP);
       MyTable.setModel(MyDTM);
       MyJSP.setSize(800,450);
       MyJSP.setLocation(10,80);

       MyTable.getColumnModel().getColumn(0).setPreferredWidth(80);
       MyTable.getColumnModel().getColumn(1).setPreferredWidth(350);
       MyTable.getColumnModel().getColumn(2).setPreferredWidth(370);
       
       MyFrm.add(CopyJSP);
       CopyTable.setModel(CopyDTM);
       CopyJSP.setSize(350,105);
       CopyJSP.setLocation(820,80);
       
       MyFrm.add(LoanJSP);
       LoanTable.setModel(LoanDTM);
       LoanJSP.setSize(350,210);
       LoanJSP.setLocation(820,320);
       LoanTable.getColumnModel().getColumn(0).setPreferredWidth(80);
       LoanTable.getColumnModel().getColumn(1).setPreferredWidth(110);
       LoanTable.getColumnModel().getColumn(2).setPreferredWidth(80);
       LoanTable.getColumnModel().getColumn(3).setPreferredWidth(80);
       
       MyFrm.add(FineJSP);
       FineTable.setModel(FineDTM);
       FineJSP.setSize(150,450);
       FineJSP.setLocation(1180,80);
       FineTable.getColumnModel().getColumn(0).setPreferredWidth(80);
       FineTable.getColumnModel().getColumn(1).setPreferredWidth(40);
       FineTable.getColumnModel().getColumn(2).setPreferredWidth(30);
       try {
    	//insertFines();
		UpdateFines();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
       MouseListener tableListener=new MouseListener(){

		public void mouseClicked(MouseEvent arg0) {
			int rowCount=MyTable.rowAtPoint(arg0.getPoint());
			
			String tempIsbn=MyDTM.getValueAt(rowCount, 0).toString();
			
			String nameStr =MyDTM.getValueAt(rowCount, 1).toString();
			
			msgTxt.setText("Book "+nameStr+" is selected");	
			try {
				getCopy(tempIsbn);
			} catch (SQLException e) {
					e.printStackTrace();
			}
		}

		public void mouseEntered(MouseEvent arg0) {

		}

		public void mouseExited(MouseEvent arg0) {

		}

		public void mousePressed(MouseEvent arg0) {
			
		}

		public void mouseReleased(MouseEvent arg0) {
			
		}

       };

       MyTable.addMouseListener(tableListener);
       
       /////////////////////////copy table//////////////////////////
       MouseListener copyTableListener=new MouseListener(){

   		public void mouseClicked(MouseEvent arg0) {
   		    int rowCount=CopyTable.rowAtPoint(arg0.getPoint());
   		    
			book_idStr=CopyDTM.getValueAt(rowCount, 0).toString();
		    branch_idStr=CopyDTM.getValueAt(rowCount, 1).toString();
			no_of_copyStr=CopyDTM.getValueAt(rowCount, 2).toString();
			no_of_available=CopyDTM.getValueAt(rowCount, 3).toString();
			
			//System.out.println(book_idStr+branch_idStr+no_of_copyStr);
			msgTxt.setText("book id is "+book_idStr+", branch_id is "+branch_idStr);
   		}

   		public void mouseEntered(MouseEvent arg0) {

   		}

   		public void mouseExited(MouseEvent arg0) {

   		}

   		public void mousePressed(MouseEvent arg0) {
   			
   		}

   		public void mouseReleased(MouseEvent arg0) {
   			
   		}

       };
       
        CopyTable.addMouseListener(copyTableListener);
        
       ////////////////////////////loanTable///////////////////////
        MouseListener loanTableListener=new MouseListener(){

       		public void mouseClicked(MouseEvent arg0) {
       			int rowCount2=LoanTable.rowAtPoint(arg0.getPoint());
       			loan_id_Str=LoanDTM.getValueAt(rowCount2, 0).toString();
       			msgTxt.setText("loan_id selected is "+loan_id_Str);
       		}

       		
       		public void mouseEntered(MouseEvent arg0) {

       		}

       		public void mouseExited(MouseEvent arg0) {

       		}

       		public void mousePressed(MouseEvent arg0) {
       			
       		}

       		public void mouseReleased(MouseEvent arg0) {
       			
       		}

           };
           
        LoanTable.addMouseListener(loanTableListener);
       ////////////////Fine_Table/////////////////////////////
        MouseListener fineTableListener=new MouseListener(){

           		public void mouseClicked(MouseEvent arg0) {
           			int rowCount=FineTable.rowAtPoint(arg0.getPoint());
           			card_no_Str=FineDTM.getValueAt(rowCount, 0).toString();
           			msgTxt.setText("card_no selected is "+card_no_Str);
           		}

           		
           		public void mouseEntered(MouseEvent arg0) {

           		}

           		public void mouseExited(MouseEvent arg0) {

           		}

           		public void mousePressed(MouseEvent arg0) {
           			
           		}

           		public void mouseReleased(MouseEvent arg0) {
           			
           		}

               };
               
        FineTable.addMouseListener(fineTableListener); 
        
        JTextField background=new JTextField();
        MyFrm.add(background);
        background.setEditable(false);
        background.setBorder(null);
        background.setSize(1, 1);
        background.setLocation(10000, 0);
     }
     
/************************************  connectSever  *************************************/
     public static void connectSQL() throws SQLException{
    	 myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");

    	 myState = myConn.createStatement();
    	 
    	 myState2 =myConn.createStatement();
    	 
    	 myState3 =myConn.createStatement();
     }
/************************************  getCopy  * @throws SQLException ******************************************/  
     public static void
     getCopy(String isbn) throws SQLException{
    	 if(isbn!=""){
    		 myState.execute("use library;");
    		 
        	 //blank is needed
    		 
    		 //book available???????????????????????????????????
    		 
        	 String selectStr="SELECT Book_id,Branch_name,No_of_copies ";
        	 String fromStr="FROM BOOK_COPIES,LIBRARY_BRANCH ";
        	 String whereStr="WHERE BOOK_COPIES.branch_id=LIBRARY_BRANCH.branch_id and Book_id='"+isbn+"'";
        	 
        	 ResultSet rst = myState.executeQuery(selectStr+fromStr+whereStr+";");
        	 
        	 
        	 
        	 while(CopyDTM.getRowCount()!=0){
        		 CopyDTM.removeRow(0);
        	 }
        	 while (rst.next()){
        		 String book_id=rst.getString(1);
        		 String branch_id=rst.getString(2);
        		 int no_of_copy=rst.getInt(3);
        		 int loanNumber=0;
        		 //not return
        		 ResultSet arst = myState2.executeQuery("select count(*) "
             	 		+ "from book_loans "
             	 		+ "where date_in is null and branch_id='"
             	 		+ branch_id
             	 		+ "' and isbn='"
             	 		+ book_id
             	 		+ "';");
        		 while(arst.next())loanNumber=arst.getInt(1);
        		 int available=no_of_copy-loanNumber;
        		 String []rowValues = {book_id,branch_id,String.valueOf(no_of_copy),String.valueOf(available)};
        		 CopyDTM.addRow(rowValues);
        	 }
        	 
        	 
    	 }
     }

/************************************  CheckOut  * @throws SQLException 
 * @return ***************************************/
     public static String checkout(String isbn,String branch_id,String card_no) throws SQLException{
    	 if(isbn==""||branch_id=="")return("You didn't select any book!");
    	 if(card_no=="")return("Card number is not input!");
    	 
    	 myState.execute("use library;");
    	 ResultSet CNRst = myState.executeQuery("select count(*) "
					+ "from BORROWER "
					+ "where Card_no='"
					+card_no
					+"';");
    	 while(CNRst.next()){
    		 int cnrNumber=CNRst.getInt(1);
    		 if(cnrNumber!=1)return("Wrong card!");
    	 }
    	 
    	 
    	 
    	 //check loans number of a card_no=3 and not returned
    	 ResultSet LNRst= myState.executeQuery("select count(*) "
    	 										+ "from book_loans "
    	 										+ "where date_in is null AND Card_no='"
    	 										+card_no
    	 										+"';");
    	 while(LNRst.next()){
    		 int loanNumber=LNRst.getInt(1);
    		 if(loanNumber==3)return("You have three loans,check out denied.");
    	 }
    	
    	 
    	 //if available copy is 0
		 
    	 int inavailable=0;
		 ResultSet arst = myState2.executeQuery("select count(*) "
     	 		+ "from book_loans "
     	 		+ "where date_in is null and branch_id='"
     	 		+ branch_id
     	 		+ "' and isbn='"
     	 		+ isbn
     	 		+ "';");
		 while(arst.next())inavailable=arst.getInt(1);
		 int available=Integer.parseInt(no_of_copyStr)-inavailable;
    	 if(available==0)return("No availableb book in this branch!");
    	 
    	 
    	 //Create a loan_id by count(*)
    	 ResultSet CountRst = myState.executeQuery("select count(*) from book_loans;");
    	 String loan_id = ""; 
    	 while(CountRst.next()){
    		int loanId=CountRst.getInt(1)+1;
    		loan_id=String.valueOf(loanId);
    	 }
    	 
    	 //date_out
    	 String date_out = "" ;
    	 ResultSet dateRst = myState.executeQuery("select current_date();");
    	  
    	 while(dateRst.next()){
    		date_out=dateRst.getString(1);
    	 }
    	 //System.out.println(date_out);
    	 
    	 //date_due=date_out+14
    	 String date_due="";
    	 dateRst = myState.executeQuery("select date_add(current_date(),interval 14 day);");
    	 while(dateRst.next()){
     		date_due=dateRst.getString(1);
     	 }
    	 System.out.println(date_due);
    	 //date_in= null
    	 
    	 myState.executeUpdate("INSERT INTO BOOK_LOANS VALUES ('"
    	 		+ loan_id
    	 		+ "','"
    	 		+ isbn
    	 		+ "','"
    	 		+ branch_id
    	 		+ "','"
    	 		+ card_no
    	 		+ "','"
    	 		+ "current_date()"
    	 		+ ","
    	 		+ "date_add(current_date(),interval 14 day)"
    	 		+ ","
    	 		+ null
    	 		+ ");");
    	 //getCopy(book_idStr);
    	 
    	 /*book_idStr="";
    	 branch_idStr="";*/
    	 return("Check out successfully!");
     }
     
/************************************  SearchBook  ***************************************/
     public static String 
     searchBook(String isbn,String title,String au1,String au2,String au3) throws SQLException{

    	 if(isbn==""&&title==""&&au1==""&&au2==""&&au3==""){
    		 return("All blanks are empty!");
    	 }
    	 myState.execute("use library;");
    	 //blank is needed
    	 String selectStr="SELECT BOOK.Isbn,BOOK.Title,AUTHORS.Fullname ";
    	 String fromStr="FROM BOOK,BOOK_AUTHORS,AUTHORS ";
    	 String whereStr="WHERE BOOK.Isbn=BOOK_AUTHORS.Isbn AND BOOK_AUTHORS.Author_id=AUTHORS.Author_id";
    	 
    	 
         if(isbn!=""){
        	 System.out.println("isbn is "+isbn);
    		 whereStr+=" AND BOOK.Isbn='"+isbn+"'";
    	 }
    	 if(title!=""){
    		 whereStr+=" AND BOOK.Title like'%"+title+"%'";
    	 }
    	 
    	 if(au1!=""&&au2==""&&au3==""){
    		 whereStr+=" AND AUTHORS.FullName LIKE '%"+au1+"%'";
    	 }
    	 if(au1==""&&au2!=""&&au3==""){
    		 whereStr+=" AND AUTHORS.FullName LIKE '%"+au2+"%'";
    	 }
    	 if(au1==""&&au2==""&&au3!=""){
    		 whereStr+=" AND AUTHORS.FullName LIKE '%"+au3+"%'";
    	 }
    	 
    	 if(au1!=""&&au2!=""&&au3==""){
    		 whereStr+=" AND (AUTHORS.FullName LIKE '%"+au1+"%'"
 				       	+" OR AUTHORS.FullName LIKE '%"+au2+"%')";
    	 }
    	 if(au1!=""&&au2==""&&au3!=""){
    		 whereStr+=" AND (AUTHORS.FullName LIKE '%"+au1+"%'"
 				       	+" OR AUTHORS.FullName LIKE '%"+au3+"%')";
    	 }
    	 if(au1==""&&au2!=""&&au3!=""){
    		 whereStr+=" AND (AUTHORS.FullName LIKE '%"+au2+"%'"
 				       	+" OR AUTHORS.FullName LIKE '%"+au3+"%')";
    	 }
    	 
    	 
    	 
    	 if(au1!=""&&au2!=""&&au3!=""){
    		 whereStr+=" AND (AUTHORS.FullName LIKE '%"+au1+"%'"
    				    +" OR AUTHORS.FullName LIKE '%"+au2+"%'"
    				    +" OR AUTHORS.FullName LIKE '%"+au3+"%')";
    	 }
    	 
    	 ResultSet rst = myState.executeQuery(selectStr+fromStr+whereStr+";");

    	 int count=0;
    	 int rowCount=0;
    	 
    	 //remove all rows
    	 while(MyDTM.getRowCount()!=0){
    		 MyDTM.removeRow(0);
    	 }
    	 
         String lastIsbn="";
         String isbnStr="";
		 String titleStr="";
		 String nameStr="";
    	 while(rst.next()){
    		 if(count==0){
    			 isbnStr=rst.getString("Isbn");
    			 titleStr=rst.getString("Title");
    			 nameStr+=rst.getString("Fullname");
    			 lastIsbn=isbnStr;
    		 }
    		 if(count>0){
    			 isbnStr=rst.getString("Isbn");
    			 if(isbnStr.equals(lastIsbn)){
    				 nameStr+=" , "+rst.getString("Fullname");
    			 }
    			 if(isbnStr.equals(lastIsbn)==false){
    				 String []rowValues = {lastIsbn,titleStr,nameStr};
    				 rowCount++;
    				 MyDTM.addRow(rowValues);
    				 
    				 titleStr=rst.getString("Title");
    				 nameStr="";
        			 nameStr+=rst.getString("Fullname");
        			 lastIsbn=isbnStr;
    			 }
    		 }
     		 count++;
    	 }
    	 if(count!=0){
    		 String []rowValues = {lastIsbn,titleStr,nameStr};
		     rowCount++;
		     MyDTM.addRow(rowValues);
    	 }
    	 
    	 return("Number of result is "+rowCount);
    		
     }
/************************************  GetLoan  * @throws SQLException ***************************************/ 
     public static String getLoan(String book_id,String card_no,String name) throws SQLException{
    	 myState.execute("use library;");
		 
    	 if(book_id==""&&card_no==""&&name==""){
    		 return("three blanks are all empty!");
    	 }
    	 
    	 //books which are not returned
		 
    	 String selectStr="SELECT Fname,Lname,BORROWER.Card_no,Isbn,Loan_id ";
    	 String fromStr="FROM BORROWER,BOOK_LOANS ";
    	 String whereStr="WHERE BOOK_LOANS.Date_in is null AND BORROWER.Card_no=BOOK_LOANS.Card_no";
    	 //
    	 if(book_id!=""){
    		 whereStr+=" AND Isbn='"+book_id+"'";
    	 }
    	 if(card_no!=""){
    		 whereStr+=" AND BORROWER.Card_no='"+card_no+"'";
    	 }
    	 if(name!=""){
    		 whereStr+=" AND (Fname LIKE '%"
    				 	+name
    				 	+"%' OR Lname LIKE '%"
    				 	+name
    				 	+"%')";
    	 }
    	 
    	 ResultSet rst = myState.executeQuery(selectStr+fromStr+whereStr+";");
    	 
    	 while(LoanDTM.getRowCount()!=0){
    		 LoanDTM.removeRow(0);
    	 }
    	 //if(rst.next()==false)return("No result");
    	 
    	 int rowCount=0;
    	 while(rst.next()){
    		 String nameStr=rst.getString(1)+" "+rst.getString(2);
    		 
    		 String bookidStr=rst.getString(3);
    		 String cardnoStr=rst.getString(4);
    		 
    		 String loanidStr=rst.getString(5);
    		 
    		 String[] values={loanidStr,nameStr,bookidStr,cardnoStr};
    		 
    		 LoanDTM.addRow(values);
    		 rowCount++;
    	 }
    	 return("Number of result is "+rowCount);
     }
/************************************  CheckIn  * @throws SQLException ***************************************/ 
     public static String checkIn(String loanId) throws SQLException{

    	 //blank is needed
		 if(loanId=="")return("No book is selected!");
		 
		 myState.execute("use library;");
		 
    	 String updateStr="UPDATE BOOK_LOANS ";
    	 String setStr="SET Date_in=current_date() ";
    	 String whereStr="WHERE Date_in is null and Loan_id="+loanId;
    	
    	 if(myState.executeUpdate(updateStr+setStr+whereStr+";")==0){
    		 //return("Check in fails,it is already returned");
    	 };
    	 
    	 //check fines by loan_id to get card_no
    	 ResultSet dateRst=myState.executeQuery("Select current_date()>Due_date "
    	 		+ "from book_loans "
    	 		+ "where loan_id='"
    	 		+ loanId
    	 		+ "';");
    	 
    	 int hasFines=0;
    	 while(dateRst.next()){
    		 hasFines=dateRst.getInt(1); 
    	 }
    	 
    	 
    	 /*ResultSet fineRst = myState.executeQuery("select datediff(date_in,due_date) "
    	 		+ "from book_loans "
    	 		+ "where loan_id='"
    	 		+ loanId
    	 		+ "' and date_in>due_date;");
    	 
    	 int dateDiff=0;
    	 while(fineRst.next()){
    		 dateDiff=fineRst.getInt(1);
    	 }*/
    	 //float amt=(float) (dateDiff*0.25);
    	//dateDiff>0 means has fines!
    	 
    	//Insert or update based on if loan_id is in fines;
    	 
    	 /*ResultSet existSet=myState2.executeQuery("select * from fines where loan_id='"
 		 		+ loan_id +"'");
 		 if(existSet.first()==false){
 			 myState3.executeUpdate("insert into fines values('"
 	    		 		+ loan_id+"','"+ amt+ "','0');"
 	    		 		);
 		 };
 		 if(existSet.first()==true){
 			 myState3.executeUpdate("update fines "
 		 		+ "Set Fine_amt='"+ amt+ "' "
 		 		+ "WHERE loan_id='"+loan_id+"';"
 		 		);
 		 }*/
    	 
    	 if(hasFines==1){
    		     /*myState.executeUpdate("INSERT into FINES Values('"
    		    		+ loanId
    		     		+ "','"
    		     		+ amt
    		     		+ "','0')");*/
    			 UpdateFines();
    			 return("Check in successfully! But you have fines, please pay it.");
    		 };
    	 //update loan
    	 
    	 loan_id_Str="";
    	 
    	 return("Check in successfully!");
     }

     
/************************************  CreateNew  * @throws SQLException **************************************/
     public static String CreateNew(String tempssn,String fname,String lname,String addr,String tempphone) throws SQLException{
    	 if(tempssn==""||tempssn.length()!=9||addr==""){
    		 //error msg
    		 if(tempssn=="")return ("Ssn is empty!");
    		 if(tempssn.length()!=9)return("Ssn format is not right!");
    		 if(addr=="")return("Address is empty!");
    	 }
    	 myState.execute("use library;");
    	 
    	 //card_no
    	 
    	 ResultSet rst = myState.executeQuery("select count(*) from borrower;");
    	 String card_no = "ID";
    	 String tempStr = "";
    	 int cardId=0;
    	 while(rst.next()){
    		cardId=rst.getInt(1)+1;
    		tempStr=String.valueOf(cardId);
    	 }
    	 for(int i=0;i<6-tempStr.length();i++){
    		 card_no+="0";
    	 }
    	 card_no+=tempStr;
    	 
    	 //ssn 9 bit1! 890-98-8765
    	 
    	 String ssn="";
    	 if(tempssn!=""&&tempssn.length()==9){
    		 ssn= tempssn.substring(0, 3)
    			  +"-"
    			  +tempssn.substring(3, 5)
    			  +"-"
    			  +tempssn.substring(5, 9);
    		 System.out.println(ssn);
    	 }
    	 
    	//ssn not unique!
    	 ResultSet ssnRst = myState.executeQuery("select count(*) from borrower "
    	 		+ "where ssn='"
    			+ ssn
    			+"';");
    	 while(ssnRst.next()){
    		 if(ssnRst.getInt(1)==1)return("Ssn exists!");
    	 }
    	 
    	 //fname
    	 if(fname=="")fname="NULL";
    	 else if(fname!="")fname="'"+fname+"'";
    	 System.out.println("f "+fname);
    	 
    	 //lname
    	 if(lname=="")lname="NULL";
    	 else if(lname!="")lname="'"+lname+"'";
    	 System.out.println("l "+lname);
    	 //address
    	 
    	 //phone (878)864-9404 10bits!
    	 String phone="NULL";
    	 if(tempphone!=""&&tempphone.length()!=10){
    		 return("Phone format is wrong!");
    	 }
    	 if(tempphone!=""&&tempphone.length()==10){
    		 phone="'("
    			  +tempphone.substring(0, 3)
    			  +") "
    			  +tempphone.substring(3, 6)
    			  +"-"
    			  +tempphone.substring(6, 10)
    			  +"'";
    		 System.out.println(phone);
    	 }

    	 myState.executeUpdate("INSERT INTO BORROWER VALUES ('"
     	 		+ card_no
     	 		+ "','"
     	 		+ ssn
     	 		+ "',"
     	 		+ fname
     	 		+ ","
     	 		+ lname
     	 		+ ",'"
     	 		+ addr
     	 		+ "',"
     	 		+ phone
     	 		+ ");");
    	 return ("Create new borrower successfully! Your card number is "+card_no);
    	 
     }
     
/************************************** insertFines* @throws SQLException ***********************************************/
     public static void insertFines() throws SQLException{
    	 myState.execute("use library;");
    	 myState2.execute("use library;");
    	 ResultSet rst = myState.executeQuery("select loan_id,datediff(date_in,due_date) from book_loans where date_in>due_date;");
    	 
    	 while(rst.next()){
    		 String loan_id=rst.getString(1);
    		 int dayDiff=rst.getInt(2);
    		 float fine_amt=(float) ((float)dayDiff*0.25);
    		 //all is paid
    		 myState2.executeUpdate("INSERT INTO FINES VALUES ('"
    	     	 		+ loan_id
    	     	 		+ "','"
    	     	 		+ fine_amt
    	     	 		+ "','"
    	     	 		+ "0"
    	     	 		+ "');");
    	 }
     }
/************************************  UpdateFine  * @throws SQLException ************************************/
     public static String UpdateFines() throws SQLException{
    	 //display not paid
    	 myState.execute("use library;");
    	 //select loan_id which is over due
    	 
    	 //loan_id exists in fines
    	 
    	 //loan_id doesn't exist in fines, then insert
    	 
    	 //date_in is null and current_date()>due_date
    	 ResultSet rst1 = myState.executeQuery("select 0.25*datediff(current_date(),due_date),loan_id "
     	 		+ "from book_loans "
     	 		+ "where date_in is null and current_date()>due_date;");
    	 

    	 while(rst1.next()){
    		 float amt=rst1.getFloat(1);
    		 String loan_id=rst1.getString(2);
    		 //loan_id in or not in fines
    		 
    		 ResultSet existSet=myState2.executeQuery("select * from fines where loan_id='"
    		 		+ loan_id +"'");
    		 if(existSet.first()==false){
    			 myState3.executeUpdate("insert into fines values('"
    	    		 		+ loan_id+"','"+ amt+ "','0');"
    	    		 		);
    		 };
    		 if(existSet.first()==true){
    			 myState3.executeUpdate("update fines "
    		 		+ "Set Fine_amt='"+ amt+ "' "
    		 		+ "WHERE loan_id='"+loan_id+"';"
    		 		);
    		 }
    	 }
    	 
    	 ResultSet rst = myState.executeQuery("select Card_no,SUM(Fine_amt),Paid "
    	 		+ "from fines,book_loans "
    	 		+ "where fines.loan_id=book_loans.loan_id AND Paid='0'"
    	 		+ "group by Card_no;");
    	 while(FineDTM.getRowCount()!=0){
    		 FineDTM.removeRow(0);
    	 }
    	 
    	 while(rst.next()){
    		 String cd=rst.getString(1);
    		 String amt=rst.getString(2);
    		 String paid=rst.getString(3);
    		 String[] values={cd,amt,paid};
    		 FineDTM.addRow(values);
    	 }
    	 
    	 return("Update Successfully!");
     }
/************************************  SetPaid  * @throws SQLException 
 * @return ***************************************/
     public static  String SetPaid(String cardno) throws SQLException{
    	 //card_no_Str
         myState.execute("use library;");
         if(cardno=="")return("No selection,setpaid error");
         //Paid should be 0, then it can be set to 1
         ResultSet rst=myState.executeQuery("SELECT Date_in "
         		+ "from FINES,BOOK_LOANS "
         		+ "where FINES.loan_id=BOOK_LOANS.loan_id AND Card_no='"+cardno+"'");
         rst.next();
         if(rst.getString(1)==null){
        	 return("Book is not returned,payment fails.");
         }
         
    	 String updateStr="UPDATE FINES,BOOK_LOANS ";
    	 String setStr="SET Paid= '1' ";
    	 String whereStr="WHERE FINES.loan_id=BOOK_LOANS.loan_id AND Card_no='"+cardno+"'";
    	 
    	 myState.executeUpdate(updateStr+setStr+whereStr+";");
    	 UpdateFines();
    	 return("Pay Successfully");
     }
	}
