package com.flowable.training;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoanApprovalService implements JavaDelegate {
	Logger logger = LoggerFactory.getLogger(LoanApprovalService.class);
	
	@Override
	public void execute(final DelegateExecution execution) {
		String applicantName = (String) execution.getVariable("applicantName");
		String contactNo = (String) execution.getVariable("contactNo");
		Integer loanAmount = (Integer) execution.getVariable("loanAmount");

		logger.info("applicantName : {}", applicantName);
		logger.info("contactNo : {}", contactNo);
		logger.info("loanAmount : {}", loanAmount);

		if(loanAmount < 10000) {
			execution.setVariable("isLoanApproved", false);
		}
		else if(loanAmount >= 10000 && loanAmount < 50000) {
			execution.setVariable("loanInterest", 9.0);
			execution.setVariable("isLoanApproved", true);
		}
		else if(loanAmount >= 50000 && loanAmount < 100000) {
			execution.setVariable("loanInterest", 8.0);
			execution.setVariable("isLoanApproved", true);
		}

		logger.info("loanInterest : {}", execution.getVariable("loanInterest"));
		logger.info("isLoanApproved : {}", execution.getVariable("isLoanApproved"));

	}
}