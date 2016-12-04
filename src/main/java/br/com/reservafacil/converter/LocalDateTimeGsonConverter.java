package br.com.reservafacil.converter;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

import javax.enterprise.context.Dependent;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

@Dependent
public class LocalDateTimeGsonConverter implements JsonSerializer<LocalDateTime> {

	@Override
	public JsonElement serialize(LocalDateTime localDateTime, Type typeOfSrc, JsonSerializationContext context) {
		String val = null;
		if (localDateTime != null) {
			val = localDateTime.toString();
		}
		return new JsonPrimitive(val);
	}

}
