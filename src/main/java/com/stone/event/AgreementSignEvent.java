package com.stone.event;

import java.util.Date;

public class AgreementSignEvent extends BaseEvent{
	
	public Integer getProjectId() {
        return projectId;
    }

    private Integer projectId;
    private int type;
    private Date loanTime;
    public AgreementSignEvent(Integer projectId , Date loanTime)
    {
        super("agreement_sign");
        this.projectId=projectId;
        this.setLoanTime(loanTime);
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


	/**
	 * @return the loanTime
	 */
	public Date getLoanTime() {
		return loanTime;
	}


	/**
	 * @param loanTime the loanTime to set
	 */
	public void setLoanTime(Date loanTime) {
		this.loanTime = loanTime;
	}
	
}
