package com.ymedialabs.ci.cd.sample.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

@Component
public class Messages {
	
	private final MessageSourceAccessor accessor;

	public Messages(MessageSource messageSource) {
		this.accessor = new MessageSourceAccessor(messageSource, LocaleContextHolder.getLocale());
	}

	public String get(String code) {
		return accessor.getMessage(code);
	}

	public String get(String code, Locale locale) {

		return accessor.getMessage(code, locale);

	}

}
