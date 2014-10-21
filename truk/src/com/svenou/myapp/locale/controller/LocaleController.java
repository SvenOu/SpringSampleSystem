package com.svenou.myapp.locale.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.svenou.myapp.commom.bean.CommonResponse;

@Controller
public class LocaleController {
	private static final Log log = LogFactory.getLog(LocaleController.class);

	private String defaultMessagesVarName = "AppLocaleMessages";

	@RequestMapping("messages.js")
	public String getMessages(HttpServletRequest request) {
		String messagesVarNameShortand = request
				.getParameter("messagesVarNameShortand");
		if ((messagesVarNameShortand == null)|| (messagesVarNameShortand.trim().equals("")))
			request.setAttribute("messagesVarNameShortand",this.defaultMessagesVarName);
		else {
			request.setAttribute("messagesVarNameShortand",messagesVarNameShortand);
		}
		return "messages";
	}

	@ResponseBody
	@RequestMapping("changeLocale")
	public CommonResponse changeLocale(HttpServletRequest request) {
		Locale locale = RequestContextUtils.getLocaleResolver(request)
				.resolveLocale(request);
		log.debug("country = " + locale.getDisplayCountry() + ", language = "
				+ locale.getDisplayLanguage());
		log.info("locale changed to: " + locale);

		Map data = new HashMap(1);
		data.put("locale", locale);

		return CommonResponse.success(data);
	}

	public String getDefaultMessagesVarName() {
		return this.defaultMessagesVarName;
	}

	public void setDefaultMessagesVarName(String defaultMessagesVarName) {
		this.defaultMessagesVarName = defaultMessagesVarName;
	}
}