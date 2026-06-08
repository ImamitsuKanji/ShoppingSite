package jp.co.aforce.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.tool.LoginManager;

@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

        Object obj = se.getSession().getAttribute("user");

        if (obj instanceof UserBean) {

            UserBean user = (UserBean) obj;

            LoginManager.logout(user.getId());

            System.out.println(
                    "タイムアウト: " + user.getId());
        }
    }
}