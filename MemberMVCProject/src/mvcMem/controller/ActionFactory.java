package mvcMem.controller;

//command(명령어에 해당하는 실제 액션을 생성해주는 클래스(Factory))

import mvcMem.action.*;

public class ActionFactory {

	private static ActionFactory factory;
	
	private ActionFactory() {
	}
	
	public static synchronized ActionFactory getInstance() {
		if(factory == null) {
			factory = new ActionFactory();
		}
		return factory;
	}
	
	public Action getAction(String cmd) {
		
		Action action = null;
		
		switch(cmd) {
		
		case "index" :
			action = new IndexAction();
			break;
			
		case "login" :
			action = new LoginFormAction();
			break;
			
		case "regForm" :
			action = new RegFormAction();
			break;
			
		case "regProc" :
			action = new RegProcAction();
			break;
		
		case "modifyForm" :
			action = new ModifyFormAction();
			break;
			
		case "modifyProc" :
			action = new ModifyProcAction();
			break;
			
		case "deleteForm" :
			action = new DeleteFormAction();
			break;
			
		case "deleteProc" :
			action = new DeleteProcAction();
			break;
			
		case "IdCheck" :
			action = new IdCheckAction();
			break;
			
		case "zipCheck" :
			action = new IndexAction();
			break;
		}
		return action;
	}
	
	
}
