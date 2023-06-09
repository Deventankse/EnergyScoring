package org.hanbo.general.web.security;

import org.hanbo.general.web.security.models.UserModel;

public interface LoginUserService
{
   UserModel getLoginUser(String userName);
}
