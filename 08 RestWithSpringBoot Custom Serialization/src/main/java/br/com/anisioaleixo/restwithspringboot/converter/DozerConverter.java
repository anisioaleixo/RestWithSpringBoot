package br.com.anisioaleixo.restwithspringboot.converter;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerConverter {
	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

	public static <O, D> D parseObject(O origen, Class<D> destination) {
		return mapper.map(origen, destination);
	}
	
	public static <O, D> List<D> parseListObjects(List<O> origen, Class<D> destination) {
		List<D> destinationObject = new ArrayList<D>();
		for (Object o : origen) {
			destinationObject.add(mapper.map(o, destination));
		}
		return destinationObject;
	}
}
