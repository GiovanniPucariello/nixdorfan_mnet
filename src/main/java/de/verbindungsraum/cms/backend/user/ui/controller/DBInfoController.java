package de.verbindungsraum.cms.backend.user.ui.controller;

import de.bite.framework.context.extension.impl.ContextType;
import de.bite.framework.controller.impl.AbstractController;
import de.verbindungsraum.cms.backend.user.ui.CMSDBKonfigurator;

public class DBInfoController extends AbstractController {

	@Override
	public void dispatch() {
		CMSDBKonfigurator konfig = (CMSDBKonfigurator)this.iContext.getObject("cms.ui.dbkonf", ContextType.NEW, null);
		konfig.initTree();
		konfig.setVisible(true);
	}

	@Override
	public boolean isSuccessful() {
		return true;
	}

	@Override
	public String actualControllerState() {
		return "UI gestartet";
	}

}
