package br.com.vinicius.todolist.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

public class Utils {

    /**
     * Copia apenas as propriedades NÃO NULAS do objeto source para o objeto target.
     *
     * Muito útil em operações de atualização parcial (ex: PATCH),
     * onde não queremos sobrescrever valores existentes com null.
     *
     * @param source objeto de origem com os novos valores
     * @param target objeto que será atualizado
     */
    public static void copyNonNullProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }

    /**
     * Retorna um array contendo o nome de todas as propriedades nulas
     * do objeto informado.
     *
     * Esse método é usado internamente para que o BeanUtils ignore
     * essas propriedades durante a cópia.
     *
     * @param source objeto que será inspecionado
     * @return array com os nomes das propriedades que estão null
     */
    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);

        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();

        for(PropertyDescriptor pd: pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if(srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
