package com.wonders.dao.issueFields;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.wonders.utils.DateManage;
@Repository
public class IssueFieldsSearchDao{
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public String genSql(String blockType, String block, String status, String reporter, String days){
		StringBuffer sql = new StringBuffer("select count(*) from jiraissue where 1 = 1 ");
		sql = setBlockSql(sql, blockType, block);
		sql = setStatusSql(sql, status);
		sql = setReporterSql(sql, reporter);
		sql = setCrtDateSql(sql, days);
		return sql.toString();
	}
	public StringBuffer setBlockSql(StringBuffer sql, String blockType, String block){
		StringBuffer blockStrTp = new StringBuffer();
		String[] blockArray = blockType.split(",");
		if(!"".equals(block)){
			for(int i=0;i<blockArray.length;i++){				
				if("Summary".equals(blockArray[i])){
					blockStrTp.append(" or Summary = '"+block+"' ");
				}else if("Environment".equals(blockArray[i])){
					blockStrTp.append(" or Environment = '"+block+"' ");
				}else if("Description".equals(blockArray[i])){
					blockStrTp.append(" or Description = '"+block+"' ");
				}
			}
			return sql.append(" and ").append(dealBlockSql(blockStrTp.toString()).toString());
		}			
		return sql;
	}
	
	public StringBuffer dealBlockSql(String sql){
		StringBuffer blockStr = new StringBuffer();
		sql = sql.substring(3);
		blockStr.append(" (").append(sql).append(")");
		return blockStr;
	}
	
	public StringBuffer setStatusSql(StringBuffer sql, String status){
		status = status.replaceAll("Any", "");
		status = status.replaceAll("Open", "1");
		status = status.replaceAll("In Progress", "3");
		status = status.replaceAll("Reopened", "4");
		status = status.replaceAll("Resolved", "5");
		status = status.replaceAll("Closed", "6");
		if(!"".equals(status)){
			sql.append(" and issuestatus in (").append(status).append(") ");
		}
		return sql;
	}
	public StringBuffer setReporterSql(StringBuffer sql, String reporter){
		if(!"".equals(reporter)){
			sql.append(" and reporter = '"+reporter+"' ");
		}
		return sql;
	}
	public StringBuffer setCrtDateSql(StringBuffer sql, String days){
		if(!"".equals(days)){
			String date = DateManage.getDateTime(-Integer.parseInt(days), "DATE");
			sql.append(" and created > '"+date+"' ");
		}
		return sql;
	}
	public long returnCount(String blockType, String block, String status, String reporter, String days){
		String sql = genSql(blockType, block, status, reporter, days);
		System.out.println(sql);
		return jdbcTemplate.queryForLong(sql);
	}
}

