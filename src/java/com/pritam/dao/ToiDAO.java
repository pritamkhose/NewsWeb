package com.pritam.dao;

import com.pritam.web.AppConstant;
import com.pritam.web.model.NewsList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ToiDAO {

	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;

	public ToiDAO() {
		this.jdbcURL = AppConstant.jdbcURL;
		this.jdbcUsername = AppConstant.jdbcUsername;
		this.jdbcPassword = AppConstant.jdbcPassword;
	}

	protected void connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName(AppConstant.jdbcClass);
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(
					jdbcURL, jdbcUsername, jdbcPassword);
		}
	}

	protected void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}



	public void insertNewTOIline(ArrayList<HashMap<String, Object>> aList) throws SQLException {
		// TODO Auto-generated method stub

		connect();
		PreparedStatement statement = null;
		for(int i = 0;i < aList.size();i++)
		{
			HashMap<String,Object> hm = aList.get(i);

			String sql = "SELECT id FROM NewsWeb.TOI where articlelink ='"+hm.get("articlelink").toString()+"'and heading1 ='"+hm.get("heading1").toString()+"' ";;
			Statement stat = jdbcConnection.createStatement();
			ResultSet resultSet = stat.executeQuery(sql);
			Double id = 0.0d;
			while (resultSet.next()) {
				id =  resultSet.getDouble("id");
			}

			if(id > 0){

				String image = hm.get("image").toString();
				if(!(image != null && image.length() > 2 )){
					image = "";
				}
				String data = hm.get("data").toString();
				if(!(data != null && data.length() > 0 )){
					data = "";
				}
				String cat = hm.get("cat").toString();
				if(!(cat != null && cat.length() > 0 )){
					cat = "";
				}
				String auth_detail = hm.get("auth_detail").toString();
				if(!(auth_detail != null && auth_detail.length() > 0 )){
					auth_detail = "";
				}
				String time_cptn = hm.get("time_cptn").toString();
				if(!(time_cptn != null && time_cptn.length() > 0 )){
					time_cptn = "";
				}

				sql = " UPDATE NewsWeb.TOI SET image = ? , cat = ? , data = ?, auth_detail=? , time_cptn = ? where id = ? ";		

				System.out.println("UPDATE--> "+i + " "+id + " " +sql);

				//PreparedStatement pstmt
				statement = jdbcConnection.prepareStatement(sql);
				statement.setString(1, image ); 
				statement.setString(2, cat ); 
				statement.setString(3, data ); 
				statement.setString(4, auth_detail ); 
				statement.setString(5, time_cptn ); 
				statement.setDouble(6, id); 
				boolean rowUpdated = statement.executeUpdate() > 0;
				statement.close();

			} else {
				sql = "INSERT INTO `NewsWeb`.`TOI` (`articlelink`, `heading1`, `image`, `data`, `cat`, `auth_detail`, `time_cptn`, `timestamp`) VALUES ( ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP )";
				//		+ " ON DUPLICATE KEY UPDATE articlelink ='"+hm.get("articlelink").toString()+"', heading1 ='"+hm.get("heading1").toString()+"' ";

				System.out.println("INSERT--> "+i + " "+id + " " +sql);

				statement = jdbcConnection.prepareStatement(sql);
				statement.setString(1, hm.get("articlelink").toString());
				statement.setString(2,hm.get("heading1").toString());
				String s = hm.get("image").toString();
				if(s != null && s.length() > 2 ){
					statement.setString(3, s);
				} else {
					statement.setString(3, null);
				}
				statement.setString(4, hm.get("data").toString());
				s = hm.get("cat").toString();
				if(s != null && s.length() > 0 ){
					statement.setString(5, s);
				} else {
					statement.setString(5, "");
				}
				s = hm.get("auth_detail").toString();
				if(s != null && s.length() > 0 ){
					statement.setString(6, s);
				} else {
					statement.setString(6, "");
				}
				s = hm.get("time_cptn").toString();
				if(s != null && s.length() > 0 ){
					statement.setString(7, s);
				} else {
					statement.setString(7, "");
				}

				boolean rowInserted = statement.executeUpdate() > 0;
				statement.close();
			}


		}

		disconnect();
	}


    public void insertNewTOI(ArrayList<HashMap<String, Object>> aList) throws SQLException {
		// TODO Auto-generated method stub

		connect();
		PreparedStatement statement = null;
		for(int i = 0;i < aList.size();i++)
		{
			HashMap<String,Object> hm = aList.get(i);

			String sql = "SELECT id FROM NewsWeb.TOI where articlelink ='"+hm.get("articlelink").toString()+"'and heading1 ='"+hm.get("heading1").toString()+"' ";;
			Statement stat = jdbcConnection.createStatement();
			ResultSet resultSet = stat.executeQuery(sql);
			Double id = 0.0d;
			while (resultSet.next()) {
				id =  resultSet.getDouble("id");
			}

			if(id > 0){

                                try{
                                    
				String image = hm.get("image").toString();
				if(!(image != null && image.length() > 2 )){
					image = "";
				}
				String data = hm.get("data").toString();
				if(!(data != null && data.length() > 0 )){
					data = "";
				}
				String cat = hm.get("cat").toString();
				if(!(cat != null && cat.length() > 0 )){
					cat = "";
				}
				String auth_detail = hm.get("auth_detail").toString();
				if(!(auth_detail != null && auth_detail.length() > 0 )){
					auth_detail = "";
				}
				String time_cptn = hm.get("time_cptn").toString();
				if(!(time_cptn != null && time_cptn.length() > 0 )){
					time_cptn = "";
				}

				sql = " UPDATE NewsWeb.TOI SET image = ? , cat = ? , data = ?, auth_detail=? , time_cptn = ? , time_date = ? where id = ? ";		

				System.out.println("UPDATE--> "+i + " "+id + " " +sql);

				//PreparedStatement pstmt
				statement = jdbcConnection.prepareStatement(sql);
				statement.setString(1, image ); 
				statement.setString(2, cat ); 
				statement.setString(3, data ); 
				statement.setString(4, auth_detail ); 
				statement.setString(5, time_cptn ); 
				statement.setString(6, hm.get("time_date").toString() ); 
				statement.setDouble(7, id); 
				boolean rowUpdated = statement.executeUpdate() > 0;
				statement.close();
                                 } catch(Exception e){
                                    System.out.println("\n"+i + " --> "+e.toString());
                                }

			} else {
				
                                try{
                                sql = "INSERT INTO `NewsWeb`.`TOI` (`articlelink`, `heading1`, `image`, `data`, `cat`, `auth_detail`, `time_cptn`, `time_date` , `timestamp`) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP )";
				//		+ " ON DUPLICATE KEY UPDATE articlelink ='"+hm.get("articlelink").toString()+"', heading1 ='"+hm.get("heading1").toString()+"' ";

				System.out.println("INSERT--> "+i + " "+id + " " +sql);

				statement = jdbcConnection.prepareStatement(sql);
				statement.setString(1, hm.get("articlelink").toString());
				statement.setString(2,hm.get("heading1").toString());
				String s = hm.get("image").toString();
				if(s != null && s.length() > 2 ){
					statement.setString(3, s);
				} else {
					statement.setString(3, null);
				}
				statement.setString(4, hm.get("data").toString());
				s = hm.get("cat").toString();
				if(s != null && s.length() > 0 ){
					statement.setString(5, s);
				} else {
					statement.setString(5, "");
				}
				s = hm.get("auth_detail").toString();
				if(s != null && s.length() > 0 ){
					statement.setString(6, s);
				} else {
					statement.setString(6, "");
				}
				s = hm.get("time_cptn").toString();
				if(s != null && s.length() > 0 ){
					statement.setString(7, s);
				} else {
					statement.setString(7, "");
				}

				statement.setString(8, hm.get("time_date").toString() ); 
				
				boolean rowInserted = statement.executeUpdate() > 0;
				statement.close();
                                } catch(Exception e){
                                    System.out.println("\n"+i + " --> "+e.toString());
                                }
			}


		}

		disconnect();
	}


    public ArrayList<HashMap<String,Object>> listAllTOI(String search) throws SQLException {
		ArrayList<HashMap<String,Object>>  alist = new ArrayList<>();

		String sql = "SELECT * FROM NewsWeb.TOI ";
		if (search != null && search.length() > 0){
			sql += " where cat = '"+search+"' ORDER BY time_date DESC ";
		}

		connect();

		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		// ResultSetMetaData rsmd = resultSet.getMetaData();
		while (resultSet.next()) {

			HashMap<String,Object> hm = new HashMap<>();
			hm.put("id", resultSet.getDouble("id"));
			hm.put("articlelink", resultSet.getString("articlelink"));
			hm.put("heading1", resultSet.getString("heading1"));
			String s = resultSet.getString("image");
			if(s != null && s.length() > 2){
				//        		 JsonParser parser = new JsonParser();
				//        		 s= "["+s+"]"; 
				//        	 
				//        	       JsonElement jElement = parser.parse(s);
				//        	       JsonArray jArray = jElement.getAsJsonArray();
				hm.put("image", s);
			}else{
				hm.put("image", null);
			}
			hm.put("data", resultSet.getString("data"));
			hm.put("cat", resultSet.getString("cat"));
			hm.put("auth_detail", resultSet.getString("auth_detail"));
			hm.put("time_cptn", resultSet.getString("time_cptn"));
			hm.put("time_date", resultSet.getDate("time_date"));
			hm.put("timestamp", resultSet.getString("timestamp"));
			alist.add(hm);
		}

		resultSet.close();
		statement.close();

		disconnect();

		return alist;
	}
   
    
    public List<String> listAllCATWeb() throws SQLException {

        List<String> alist = new ArrayList<>();
		String sql = "SELECT DISTINCT cat FROM NewsWeb.TOI  ORDER BY cat ASC ";
		
		connect();

		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
                    alist.add(resultSet.getString("cat"));	
		}
                
                alist.add(0,"Select Category");
		resultSet.close();
		statement.close();

		disconnect();

		return alist;
       
    }
    
    
    public List<NewsList> listCATTOIWeb(String search, String cat) throws SQLException {

        List<NewsList> alist = new ArrayList<>();

		String sql = "SELECT * FROM NewsWeb.TOI ";
//		if (search != null && search.length() > 0 && cat != null && cat.length() > 0 ){
//                    sql += " where heading1 like '"+search+"%' and cat = '"+cat+"' ORDER BY time_date DESC ";
//		} 
//                else if (search != null && search.length() > 0 && cat == null){
                if (search != null && search.length() > 0){
                    sql += " where heading1 like '"+search+"%' or data like '"+search+"%' ";
                } 
                else if (cat != null && cat.length() > 0 && search== null){
                    sql += " where cat = '"+cat+"'  ";
                }
                else {
                    sql += "";
                }
                
                sql += " ORDER BY time_date DESC LIMIT 25 ";//OFFSET 25
                System.out.println("sql -->" + sql);
		connect();

		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		// ResultSetMetaData rsmd = resultSet.getMetaData();
		while (resultSet.next()) {
                    String s = resultSet.getString("image");
			if(s != null && s.length() > 2){
                           s =  s.substring(1,s.length()-1);
                          // s = s.split("",-1)[0].trim();
                           }else{
				s= null;
			}
		NewsList n = new NewsList(
                       resultSet.getDouble("id"), 
                        resultSet.getString("articlelink"),
			s,
                        resultSet.getString("data").substring(0,250)+" ...",
                        resultSet.getString("heading1"),
			resultSet.getString("cat"),
			resultSet.getString("auth_detail"),
			resultSet.getString("time_cptn"),
			resultSet.getString("timestamp"),
                        resultSet.getString("time_date").substring(0, 16)
                );
            alist.add(n);
                        //HashMap<String,Object> hm = new HashMap<>();
//			hm.put("id", resultSet.getDouble("id"));
//			hm.put("articlelink", resultSet.getString("articlelink"));
//			hm.put("heading1", resultSet.getString("heading1"));
//			String s = resultSet.getString("image");
//			if(s != null && s.length() > 2){
//				hm.put("image", s);
//			}else{
//				hm.put("image", null);
//			}
//			hm.put("data", resultSet.getString("data"));
//			hm.put("cat", resultSet.getString("cat"));
//			hm.put("auth_detail", resultSet.getString("auth_detail"));
//			hm.put("time_cptn", resultSet.getString("time_cptn"));
//			hm.put("time_date", resultSet.getDate("time_date"));
//			hm.put("timestamp", resultSet.getString("timestamp"));
			
		}

		resultSet.close();
		statement.close();

		disconnect();

		return alist;
       
    }

    public List<NewsList> detailsTOIWeb(String id) throws SQLException {

        List<NewsList> alist = new ArrayList<>();

		String sql = "SELECT * FROM NewsWeb.TOI where id = "+id+" ";

                System.out.println("sql -->" + sql);
		connect();

		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
                    String s = resultSet.getString("image");
			if(s != null && s.length() > 2){
                           s =  s.substring(1,s.length()-1);
                           }else{
				s= null;
			}
		NewsList n = new NewsList(
                       resultSet.getDouble("id"), 
                        resultSet.getString("articlelink"),
			s,
                        resultSet.getString("data"),
                        resultSet.getString("heading1"),
			resultSet.getString("cat"),
			resultSet.getString("auth_detail"),
			resultSet.getString("time_cptn"),
			resultSet.getString("timestamp"),
                        resultSet.getString("time_date")
                );
                alist.add(n);
			
		}

		resultSet.close();
		statement.close();

		disconnect();

		return alist;
       
    }


}
