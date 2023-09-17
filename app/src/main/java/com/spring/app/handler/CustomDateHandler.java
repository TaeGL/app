package com.spring.app.handler;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class CustomDateHandler {
	public Date getNullableResult(ResultSet rs, String columnName) throws SQLException {
		
		
		Timestamp sqlTimestamp = rs.getTimestamp(columnName);
		if (sqlTimestamp != null) {
			return new Date(sqlTimestamp.getTime());
		}
		return null;
	}

	public CustomDateHandler() {
		super();
		// TODO Auto-generated constructor stub
	}
}