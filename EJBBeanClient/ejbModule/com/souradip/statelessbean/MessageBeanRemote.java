package com.souradip.statelessbean;

import jakarta.ejb.Remote;

@Remote
public interface MessageBeanRemote {
 public String message(String msg);
}
