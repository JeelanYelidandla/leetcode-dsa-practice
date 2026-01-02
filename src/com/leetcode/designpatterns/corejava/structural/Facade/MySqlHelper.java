package com.leetcode.designpatterns.corejava.structural.Facade;
public class MySqlHelper {
	
	public static ConnectionInter getMySqlDBConnection(){
		//get MySql DB connection using connection parameters
		return null;
	}
	
	public void generateMySqlPDFReport(String tableName, ConnectionInter con){
		//get data from table and generate pdf report
	}
	
	public void generateMySqlHTMLReport(String tableName, ConnectionInter con){
		//get data from table and generate pdf report
	}
}