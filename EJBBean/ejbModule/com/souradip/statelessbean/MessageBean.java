package com.souradip.statelessbean;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;

/**
 * Session Bean implementation class MessageBean
 */
@Stateless(mappedName = "MessageBean")
@LocalBean
public class MessageBean implements MessageBeanRemote {

    /**
     * Default constructor. 
     */
    public MessageBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String message(String msg) {
		// TODO Auto-generated method stub
		return "hello "+msg;
	}

}
