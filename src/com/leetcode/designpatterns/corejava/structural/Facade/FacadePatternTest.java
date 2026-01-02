package com.leetcode.designpatterns.corejava.structural.Facade;
public class FacadePatternTest {

/*
 * Facade Design Pattern is one of the Structural design patterns (such as Adapter pattern and Decorator pattern).
 *  Facade design pattern is used to help client applications to easily interact with the system.
 *  
 *  Provide a unified interface to a set of interfaces in a subsystem. Facade Pattern defines a higher-level 
 *  interface that makes the subsystem easier to use.

Suppose we have an application with set of interfaces to use MySql/Oracle database and to
 generate different types of reports, such as HTML report, PDF report etc.

So we will have different set of interfaces to work with different types of database.
 Now a client application can use these interfaces to get the required database connection and generate reports.
 
 But when the complexity increases or the interface behavior names are confusing, 
 client application will find it difficult to manage it.

So we can apply Facade design pattern here and provide a wrapper interface on top of the existing interface 
to help client application.


	As you can see that using Facade pattern interface is a lot easier and cleaner way to avoid having a lot of logic at client side.
	 JDBC Driver Manager class to get the database connection is a wonderful example of facade design pattern.
 */
	public static void main(String[] args) {
		String tableName="Employee";
		
		//generating MySql HTML report and Oracle PDF report without using Facade
		ConnectionInter con = MySqlHelper.getMySqlDBConnection();
		MySqlHelper mySqlHelper = new MySqlHelper();
		mySqlHelper.generateMySqlHTMLReport(tableName, con);
		
		ConnectionInter con1 = OracleHelper.getOracleDBConnection();
		OracleHelper oracleHelper = new OracleHelper();
		oracleHelper.generateOraclePDFReport(tableName, con1);
		
		//generating MySql HTML report and Oracle PDF report using Facade
		HelperFacade.generateReport(HelperFacade.DBTypes.MYSQL, HelperFacade.ReportTypes.HTML, tableName);
		HelperFacade.generateReport(HelperFacade.DBTypes.ORACLE, HelperFacade.ReportTypes.PDF, tableName);
	}

}