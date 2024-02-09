package com.uca.prog4.controladores.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;

public class JsfUtil {

    public static SelectItem[] getSelectItems(List<?> entities, boolean selectOne) {
        int size = selectOne ? entities.size() + 1 : entities.size();
        SelectItem[] items = new SelectItem[size];
        int i = 0;
        if (selectOne) {
            items[0] = new SelectItem("", "---");
            i++;
        }
        for (Object x : entities) {
            items[i++] = new SelectItem(x, x.toString());
        }
        return items;
    }
    
        public static void addErrorMessage(Exception e, String defaultMsgKey) {
        String detailedErrorMessage = extractRootCauseMessage(e);
        String localizedMessage = ResourceBundle.getBundle("/Bundle").getString(defaultMsgKey);
        
        FacesMessage facesMsg;
        
        if (detailedErrorMessage != null && !detailedErrorMessage.isEmpty()) {
            // Usar mensaje detallado de la causa raíz si está disponible
            facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, detailedErrorMessage, detailedErrorMessage);
        } else {
            // Usar mensaje genérico si no se encontró un mensaje detallado
            facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, localizedMessage, localizedMessage);
        }
        
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    private static String extractRootCauseMessage(Throwable throwable) {
        // Recorre las causas de la excepción para encontrar la causa raíz
        Throwable cause = throwable;
        String rootMessage = null;
        
        while (cause != null) {
            rootMessage = cause.getLocalizedMessage();
            cause = cause.getCause();
        }
        
        return rootMessage;
    }

//    public static void addErrorMessage(Exception ex, String defaultMsg) {
//        String msg = ex.getLocalizedMessage();
//        if (msg != null && msg.length() > 0) {
//            addErrorMessage(msg);
//        } else {
//            addErrorMessage(defaultMsg);
//        }
//    }

    public static void addErrorMessages(List<String> messages) {
        for (String message : messages) {
            addErrorMessage(message);
        }
    }

    public static void addErrorMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public static void addSuccessMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }

    public static String getRequestParameter(String key) {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(key);
    }

    public static Object getObjectFromRequestParameter(String requestParameterName, Converter converter, UIComponent component) {
        String theId = JsfUtil.getRequestParameter(requestParameterName);
        return converter.getAsObject(FacesContext.getCurrentInstance(), component, theId);
    }
    
//     public static String formatearGuaranies(BigDecimal numero, Locale locale) {
//        NumberFormat formateador = NumberFormat.getNumberInstance(locale);
//        formateador.setMaximumFractionDigits(0); // No mostrar decimales
//        return formateador.format(numero);
//    }
}
