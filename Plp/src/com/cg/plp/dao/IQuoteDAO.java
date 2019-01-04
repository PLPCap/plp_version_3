package com.cg.plp.dao;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import com.cg.plp.bean.AccountCreationBean;
import com.cg.plp.bean.UserLoginBean;

public interface IQuoteDAO {

	public int checkValidLogin(UserLoginBean userLoginBean) throws SQLException, ClassNotFoundException, FileNotFoundException;
	public void profileCreation(UserLoginBean userLoginBean) throws ClassNotFoundException, FileNotFoundException, SQLException;
	public void accountCreation(AccountCreationBean accountCreationBean) throws ClassNotFoundException, FileNotFoundException, SQLException;
	
}
