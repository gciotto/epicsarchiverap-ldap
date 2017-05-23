package org.epics.archiverappliance.mgmt.bpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.epics.archiverappliance.common.BPLAction;
import org.epics.archiverappliance.config.ConfigService;
import org.epics.archiverappliance.utils.ui.MimeTypeConstants;
import org.json.simple.JSONValue;

public class GetLoginUsername implements BPLAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp, ConfigService configService)
			throws IOException {

		String username = req.getRemoteUser();
		
		HashMap<String, Object> infoValues = new HashMap<String, Object>();
		resp.setContentType(MimeTypeConstants.APPLICATION_JSON);
		
		if (username != null) 			
			infoValues.put("username", username);
		else 
			infoValues.put("validation", "No user has been authenticated.");
		
		try(PrintWriter out = resp.getWriter()) {
			out.println(JSONValue.toJSONString(infoValues));
		}
		
		return;
	}

}
