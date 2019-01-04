package com.cg.plp.service;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import com.cg.plp.bean.AccountCreationBean;
import com.cg.plp.bean.UserLoginBean;
import com.cg.plp.dao.IQuoteDAO;
import com.cg.plp.dao.QuoteDAOImpl;

public class QuoteServiceImpl implements IQuoteService {

	IQuoteDAO iQuoteDAO=new QuoteDAOImpl();
	
	@Override
	public int checkValidLogin(UserLoginBean userLoginBean) throws ClassNotFoundException, FileNotFoundException, SQLException {
		
		
		
		//System.out.println("id"+userLoginBean.getLoginId());
		
		return iQuoteDAO.checkValidLogin(userLoginBean);
	}

	@Override
	public void profileCreation(UserLoginBean userLoginBean) throws ClassNotFoundException, FileNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		//System.out.println(userLoginBean.getPassword()+" "+userLoginBean.getLoginId());
		
		iQuoteDAO.profileCreation(userLoginBean);
		
		
	}

	@Override
	public void accountCreation(AccountCreationBean accountCreationBean) throws ClassNotFoundException, FileNotFoundException, SQLException {
		// TODO Auto-generated method stub
		iQuoteDAO.accountCreation(accountCreationBean);
	}

	
	
}
