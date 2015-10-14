package com.shieldsquare.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.shieldsquare.model.IPDelete;
import com.shieldsquare.utils.DBUtils;

public class DeleteIP_DAO_Impl implements DeleteIP_DAO {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public ArrayList<IPDelete> deleteIPfromTable(int sid, String ip_add,
			String R1, String R2, String R4, String R5, String R6) {

		ArrayList<IPDelete> ipDetailsList = new ArrayList<IPDelete>();
		try {

			con = DBUtils.getMySqlConnection();
			System.out.println("First Select Query");
			ps = con.prepareStatement("select dt,total_requests from ip_analysis where ip_address in (select id from ip_details where ip_address=?) and sid=?");
			ps.setString(1, ip_add);
			ps.setInt(2, sid);
			rs = ps.executeQuery();

			System.out.println("Executing While Loop Inside DaoImple Class");
			while (rs.next()) {
				String updatemsg;
				IPDelete ipd = new IPDelete();
				String Date = rs.getString("dt");
				int totalRequests = rs.getInt("total_requests");

				// System.out.println(Date);
				// System.out.println(totalRequests);

				ipd.setTotal_count(totalRequests);

				// R1=Bad_bots
				if (R1 != null) {
					PreparedStatement ps1 = con
							.prepareStatement("update rules_summary set bad_bots =bad_bots - ? where sid=? and dt=?");

					ps1.setInt(1, totalRequests);
					ps1.setInt(2, sid);
					ps1.setString(3, Date);
					int rs1 = ps1.executeUpdate();
					// System.out.println(rs1);
					updatemsg = "Updated in Bad_bots column value is__"
							+ totalRequests;
					// System.out.println(updatemsg);
					// System.out.println();
					ipd.setUpdateMsg(updatemsg);
					ipDetailsList.add(ipd);

				}

				// R2=Data_center_bots
				if (R2 != null) {
					PreparedStatement ps1 = con
							.prepareStatement("update rules_summary set datacenter_bots =datacenter_bots - ? where sid=? and dt=?");

					ps1.setInt(1, totalRequests);
					ps1.setInt(2, sid);
					ps1.setString(3, Date);
					int rs1 = ps1.executeUpdate();

					System.out.println(rs1);

					updatemsg = "Updated in data_center column";
					System.out.println(updatemsg);
					System.out.println();
					ipd.setUpdateMsg(updatemsg);
					ipDetailsList.add(ipd);

				}
				// R5=Known_UA_Bots

				if (R5 != null) {
					PreparedStatement ps1 = con
							.prepareStatement("update rules_summary set known_ua_bots =known_ua_bots - ? where sid=? and dt=?");

					ps1.setInt(1, totalRequests);
					ps1.setInt(2, sid);
					ps1.setString(3, Date);
					int rs1 = ps1.executeUpdate();
					// System.out.println(rs1);

					updatemsg = "Updated in known_ua_bots column";
					// System.out.println(updatemsg);
					// System.out.println();
					ipd.setUpdateMsg(updatemsg);
					ipDetailsList.add(ipd);

				}

				if (R4 != null) {
					PreparedStatement ps1 = con
							.prepareStatement("update rules_summary set r_aggregator =r_aggregator - ? where sid=? and dt=?");

					ps1.setInt(1, totalRequests);
					ps1.setInt(2, sid);
					ps1.setString(3, Date);
					int rs1 = ps1.executeUpdate();
					// System.out.println(rs1);
					updatemsg = "Updated in r_aggregator column";
					// System.out.println(updatemsg);
					// System.out.println();
					ipd.setUpdateMsg(updatemsg);
					ipDetailsList.add(ipd);

				}
			}

			PreparedStatement pss = con
			// .prepareStatement("delete from ip_analysis output deleted.total_requests as delTreq where ip_address in (select id from ip_details where ip_address=?) and sid=?");
					.prepareStatement("delete from ip_analysis where ip_address in (select id from ip_details where ip_address=?) and sid=?");
			pss.setString(1, ip_add);
			pss.setInt(2, sid);
			// ResultSet rss = pss.executeQuery();

			int rowsDeleted = pss.executeUpdate();
			if (rowsDeleted > 0) {
				con.close();
				// while (rss.next()) {
				// int count=rs.getInt("delTreq");
				// System.out.println("Finally Count");
				// System.out.println("Ip is deleted in Ip_analysis");
			}
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * finally{ try{ System.out.println("Delete query"); con =
		 * DBUtils.getMSSQLConnection(); //ps = con.prepareStatement(
		 * "delete from ip_analysis output deleted.total_requests as delTreq where ip_address in (select id from ip_details where ip_address=?) and sid=? and dt=?"
		 * );
		 * 
		 * PreparedStatement pss = con.prepareStatement(
		 * "delete from ip_analysis output deleted.total_requests as delTreq where ip_address in (select id from ip_details where ip_address=?) and sid=?"
		 * ); pss.setString(1, ip_add); pss.setInt(2, sid); ResultSet rss =
		 * pss.executeQuery(); while (rss.next()){
		 * 
		 * //int count=rs.getInt("delTreq");
		 * System.out.println("Finally Count");
		 * System.out.println("Ip is deleted in Ip_analysis");
		 * 
		 * } }catch(Exception e){ System.out.println(e); } }
		 */
		return ipDetailsList;
	}

}
