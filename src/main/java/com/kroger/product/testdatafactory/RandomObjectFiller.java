package com.kroger.product.testdatafactory;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.Date;
import java.util.Random;

import io.github.benas.randombeans.randomizers.DateRandomizer;
import io.github.benas.randombeans.randomizers.StringRandomizer;

 
public class RandomObjectFiller {
 
    private Random random = new Random();
 
    public <T> T createAndFill(Class<T> clazz) throws Exception {
        T instance = clazz.newInstance();
        for(Field field: clazz.getDeclaredFields()) {
            field.setAccessible(true);
            Object value = getRandomValueForField(field);
            field.set(instance, value);
        }
        return instance;
    }
 
    private Object getRandomValueForField(Field field) throws Exception {
        Class<?> type = field.getType();
 
        if(type.isEnum()) {
            Object[] enumValues = type.getEnumConstants();
            return enumValues[random.nextInt(enumValues.length)];
        } else if(type.equals(Integer.TYPE) || type.equals(Integer.class)) {
            return  random.nextInt(9000000) + 1000000;
        } else if(type.equals(Long.TYPE) || type.equals(Long.class)) {
            return random.nextLong();
        } else if(type.equals(Double.TYPE) || type.equals(Double.class)) {
            return random.nextDouble();
        } else if(type.equals(Float.TYPE) || type.equals(Float.class)) {
            return random.nextFloat();
        } else if(type.equals(String.class)) {
           return new StringRandomizer().getRandomValue().toString();
        } else if(type.equals(BigInteger.class)){
            return BigInteger.valueOf(random.nextInt());
        }else if(type.equals(Date.class)){
        	return  DateRandomizer.aNewDateRandomizer().getRandomValue();
        }
        return createAndFill(type);
    }
}