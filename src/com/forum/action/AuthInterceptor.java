package com.forum.action;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import com.forum.entity.User;

public class AuthInterceptor extends AbstractInterceptor {
  private User user;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public String intercept(ActionInvocation invocation) throws Exception {
    // 取得请求的Url
    String url = ServletActionContext.getRequest().getRequestURL().toString();
    // 取得请求的Action名
    String ActionName = invocation.getInvocationContext().getName();
    System.out.println("经过拦截器的action:"+ActionName);

    ActionContext ac = invocation.getInvocationContext();
    Map session = (Map) ac.get(ServletActionContext.SESSION);
    if ("EnrollAction".equals(ActionName)||"Write".equals(ActionName)) {
      return invocation.invoke();
    } 
    
    else {
      if (session == null) {// 错误,回到登录界面
        System.out.println("拦截器错误编号:2:session为空");
        return "false";
      } else {
        String username = (String) session.get("nickname");
        if (username == null) {
          // Session不为空，但Session中没有用户信息，
          // 则让用户登陆
          System.out.println("拦截器错误编号:3:Session不为空，但Session中没有用户信息");
          return "false";
        } else {
          // 用户已经登陆，放行~执行拦截器栈后来的拦截器
          System.out.println("拦截器提示编号:4:用户已经登陆，放行~执行拦截器栈后来的拦截器");
          return invocation.invoke();
        }
      }
    }
  }

}
