package br.com.reservafacil.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.lang.reflect.Type;

import javax.enterprise.context.Dependent;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * Para converter os dados do tipo localdate que sao enviados para view,
 * foi criado esse converter. 
 *  
 * @author fabiofiuza
 *
 */

@Dependent
public class LocalDateGsonConverter implements JsonSerializer<LocalDate> {

	@Override
	public JsonElement serialize(LocalDate localDate, Type typeOfSrc, JsonSerializationContext context) {
		String val = null;
		if (localDate != null) {
			val = localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString();
		}
		return new JsonPrimitive(val);
	}
}
