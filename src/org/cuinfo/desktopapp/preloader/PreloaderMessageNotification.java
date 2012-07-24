/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cuinfo.desktopapp.preloader;

import javafx.application.Preloader;

/**
 * 消息事件
 * @author xiaoxi
 */
public class PreloaderMessageNotification implements Preloader.PreloaderNotification{
   private String message;

    public PreloaderMessageNotification(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
