package com.leetcode.designpatterns.corejava.structural.Facade;

public class OracleHelper {

	public static ConnectionInter getOracleDBConnection(){
		//get Oracle DB connection using connection parameters
		return null;
	}
	
	public void generateOraclePDFReport(String tableName, ConnectionInter con){
		//get data from table and generate pdf report
	}
	
	public void generateOracleHTMLReport(String tableName, ConnectionInter con){
		//get data from table and generate pdf report
	}
	
}