package com.example.demo.service.exeption;

import java.sql.SQLException;

import org.hibernate.exception.ConstraintViolationException;

public class ServiceSqlException extends ConstraintViolationException {

	private static final long serialVersionUID = 1L;

	public ServiceSqlException(String message, SQLException root, String constraintName) {
        super(message, root, constraintName);
    }

    public ServiceSqlException(String message, SQLException root, String sql, String constraintName) {
        super(message, root, sql, constraintName);
    }
    @Override
    public SQLException getSQLException() {
        return super.getSQLException();
    }

    @Override
    public String getConstraintName() {
        return super.getConstraintName();
    }
}
